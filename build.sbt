name := "scala-graphql"

version := "0.1"

scalaVersion := "2.12.3"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies += "org.sangria-graphql" %% "sangria" % "1.3.0"
libraryDependencies += "org.sangria-graphql" %% "sangria-circe" % "1.1.0"
libraryDependencies += "io.circe" %% "circe-parser" % "0.9.0-M1"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "org.sangria-graphql" %% "sangria-spray-json" % "1.0.0"
libraryDependencies += "org.sangria-graphql" %% "sangria-play-json" % "1.0.3"
libraryDependencies += guice