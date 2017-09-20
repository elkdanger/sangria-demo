package graphql

import sangria.macros.derive._
import sangria.schema._

object SchemaDefinition {

  implicit val DriverType: ObjectType[Unit, Driver] = deriveObjectType[Unit, Driver](
    ObjectTypeDescription("A driver"),
    DocumentField("name", "The name of the driver"))

  val TeamType: ObjectType[Unit, Team] = deriveObjectType[Unit, Team](
    ObjectTypeDescription("A team"),
    DocumentField("name", "The name of the team"))

  val ID = Argument("id", IntType, description = "The id of an entity")

  val Query = ObjectType(
    "Query", fields[DataRepository, Unit](
      Field("team", OptionType(TeamType),
        arguments = ID :: Nil,
        resolve = ctx => ctx.ctx.getTeam(ctx arg ID)
      ),
      Field("teams", ListType(TeamType),
        description = Some("Returns the list of teams"),
        resolve = _.ctx.getTeams
      ),
      Field("driver", OptionType(DriverType),
        arguments = ID :: Nil,
        resolve = ctx => ctx.ctx.getDriver(ctx arg ID)
      ),
      Field("drivers", ListType(DriverType),
        description = Some("Returns a list of drivers"),
        resolve = _.ctx.getDrivers
      )
    )
  )

  val TeamSchema = Schema(Query)

}
