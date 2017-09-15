name := "Common"

version := "1.0"

scalaVersion := "2.11.0"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.16"

// for debugging sbt problems
logLevel := Level.Debug

//scalacOptions += "-deprecation"