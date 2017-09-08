package controllers

import javax.inject.Inject

import graphql.{SchemaDefinition, TeamRepo}
import models.graphql.Query
import play.api.libs.json.{JsObject, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import sangria.ast.Document
import sangria.execution.{ErrorWithResolver, Executor, QueryAnalysisError}
import sangria.marshalling.playJson._
import sangria.parser.{QueryParser, SyntaxError}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def graphql = Action.async(parse.json) {
    implicit request =>

      request.body.asOpt[Query] map { query =>

        QueryParser.parse(query.query) match {
          case Success(queryAst) => executeGraphQLQuery(queryAst, query.operationName, query.variables)
          case Failure(error: SyntaxError) =>
            Future.successful(BadRequest(Json.obj("error" -> error.getMessage())))
        }

      } getOrElse Future.successful(BadRequest)
  }

  private def executeGraphQLQuery(query: Document, operation: Option[String], vars: JsObject) =
    Executor.execute(SchemaDefinition.TeamSchema, query, new TeamRepo, operationName = operation, variables = vars)
      .map(Ok(_))
      .recover {
        case error: QueryAnalysisError => BadRequest(error.resolveError)
        case error: ErrorWithResolver => InternalServerError(error.resolveError)
      }

}
