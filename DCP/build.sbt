ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.13"

libraryDependencies += "org.slf4j" % "slf4j-api" % "2.0.12"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.5.6"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test

lazy val root = (project in file("."))
  .settings(
    name := "DCP"
  )
