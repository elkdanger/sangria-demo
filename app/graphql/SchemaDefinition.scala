package graphql

import sangria.macros.derive._
import sangria.schema._

object SchemaDefinition {

  val Team: ObjectType[Unit, Team] = deriveObjectType[Unit, Team](
    ObjectTypeDescription("A team"),
    DocumentField("name", "The name of the team"))

  val ID = Argument("id", IntType, description = "The id of an entity")

  val Query = ObjectType(
    "Query", fields[TeamRepo, Unit](
      Field("team", OptionType(Team),
        arguments = ID :: Nil,
        resolve = ctx => ctx.ctx.getTeam(ctx arg ID)
      )
    )
  )

  val TeamSchema = Schema(Query)

}
