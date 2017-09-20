package graphql

class DataRepository {

  private val teams = Map(
    1 -> Team(1, "Mercedes", "Mercedes", privateer = false),
    2 -> Team(2, "Ferrari", "Ferrari", privateer = false),
    3 -> Team(3, "Red Bull", "Renault", privateer = true),
    4 -> Team(4, "McLaren", "Honda", privateer = false),
    5 -> Team(5, "Williams", "Mercedes", privateer = true),
    6 -> Team(6, "Force India", "Mercedes", privateer = true),
    7 -> Team(7, "Sauber", "Ferrari", privateer = true),
    8 -> Team(8, "Haas", "Ferrari", privateer = true),
    9 -> Team(9, "Renault", "Renault", privateer = false)
  )

  private val drivers = Map(
    1 -> Driver(1, "Lewis Hamilton", "British"),
    2 -> Driver(2, "Valtteri Bottas", "Finnish"),
    3 -> Driver(3, "Sebastian Vettel", "German"),
    4 -> Driver(4, "Kimi Raikkönen", "Finnish"),
    5 -> Driver(5, "Daniel Ricciardo", "Australian"),
    6 -> Driver(6, "Max Verstappen", "Dutch"),
    7 -> Driver(7, "Fernando Alonso", "Spanish"),
    8 -> Driver(8, "Stoffel Van Doorne", "Dutch"),
    9 -> Driver(9, "Felipe Massa", "Brazilian"),
    10 -> Driver(10, "Lance Stroll", "Canadian"),
    11 -> Driver(11, "Esteban Ocon", "French"),
    12 -> Driver(12, "Sergio Perez", "Mexican"),
    13 -> Driver(13, "Pascal Wehrlein", "German"),
    14 -> Driver(14, "Marcus Ericsson", "Swedish"),
    15 -> Driver(15, "Romain Grosjean", "French"),
    16 -> Driver(16, "Kevin Magnusson", "Danish"),
    17 -> Driver(17, "Jolyon Palmer", "British"),
    18 -> Driver(18, "Nico Hülkenburg", "German")
  )

  def getTeams = teams.values.toSeq

  def getDrivers = drivers.values.toSeq

  def getTeam(id: Int) = if(teams.contains(id)) Some(teams(id)) else None

  def getDriver(id: Int) = if(drivers.contains(id)) Some(drivers(id)) else None

}
