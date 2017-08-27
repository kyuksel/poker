name := "poker"

version := "1.0"

scalaVersion := "2.12.3"

lazy val mainDependencies = Seq("io.spray" %%  "spray-json" % "1.3.3")
lazy val testDependencies = Seq("org.scalatest" %% "scalatest" % "3.0.0" % "test")

libraryDependencies ++= (mainDependencies ++ testDependencies)
