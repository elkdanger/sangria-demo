package graphql

import io.circe.Json
import io.circe.parser._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{MustMatchers, WordSpec}
import sangria.execution._
import sangria.macros._
import sangria.marshalling.circe._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class SchemaSpec extends WordSpec with MustMatchers with ScalaFutures {

  "The team schema" should {
    "parse a basic query" in {

      val query =
        graphql"""
             query {
               team(id: 1) {
                 id,
                 name,
                 engine,
                 privateer
                 }
              }
          """

      val result: Future[Json] =
        Executor.execute(SchemaDefinition.TeamSchema, query, new TeamRepo)

      val expectedJson =
        """
          | {
          |   "data": {
          |     "team": {
          |       "id": 1,
          |       "name": "Mercedes",
          |       "engine": "Mercedes",
          |       "privateer": false
          |     }
          |   }
          | }
        """.stripMargin

      whenReady(result) { j =>
        parse(expectedJson) match {
          case Right(v) => v mustBe j
          case Left(f) => fail(f.message)
        }
      }

    }
  }

}
