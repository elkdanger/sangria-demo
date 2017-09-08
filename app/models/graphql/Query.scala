package models.graphql

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Query(query: String, operationName: Option[String], variables: JsObject)

object Query {
  implicit val reads: Reads[Query] =
    (
      (__ \ "query").read[String] ~
        (__ \ "operationName").readNullable[String] ~
        (__ \ "variables").readNullable[JsObject].map(j => j.getOrElse(Json.obj()))
      )(Query.apply _)

}
