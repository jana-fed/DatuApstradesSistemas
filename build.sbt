ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "DatuApstradesSistemas"
  )
// https://mvnrepository.com/artifact/net.debasishg/redisclient
libraryDependencies += "net.debasishg" %% "redisclient" % "3.42"

// https://mvnrepository.com/artifact/org.neo4j.driver/neo4j-java-driver
libraryDependencies += "org.neo4j.driver" % "neo4j-java-driver" % "4.4.9"

libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.10"