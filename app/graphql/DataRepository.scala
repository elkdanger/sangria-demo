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

  def getTeams = teams.values.toSeq

  def getTeam(id: Int) = if(teams.contains(id)) Some(teams(id)) else None

}
