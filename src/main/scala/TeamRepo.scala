class TeamRepo {

  private val teams = Map(
    1 -> Team(1, "Mercedes", "Mercedes", false),
    2 -> Team(2, "Ferrari", "Ferrari", false),
    3 -> Team(3, "Red Bull", "Renault", true),
    4 -> Team(4, "McLaren", "Honda", false),
    5 -> Team(5, "Williams", "Mercedes", true),
    6 -> Team(6, "Force India", "Mercedes", true),
    7 -> Team(7, "Sauber", "Ferrari", true),
    8 -> Team(8, "Haas", "Ferrari", true),
    9 -> Team(9, "Renault", "Renault", false)
  )

  def getTeam(id: Int) = if(teams.contains(id)) Some(teams(id)) else None

}
