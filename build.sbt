name := "poker"
version := "0.1"
scalaVersion := "2.12.3"

import sbt.complete.Parsers.spaceDelimited

lazy val mainDependencies = Seq("io.spray" %%  "spray-json" % "1.3.3")
lazy val testDependencies = Seq("org.scalatest" %% "scalatest" % "3.0.0" % "test")

libraryDependencies ++= (mainDependencies ++ testDependencies)

lazy val classify = inputKey[Unit]("Classify hand")

classify := {
  val args: Seq[String] = spaceDelimited("<arg>").parsed
}

fullRunInputTask(classify, Compile, "poker.app.Classification")

