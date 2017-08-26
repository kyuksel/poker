name := "poker"

version := "1.0"

scalaVersion := "2.12.3"

lazy val mainDependencies = Seq("org.json4s" % "json4s-native_2.10" % "3.5.3")
lazy val testDependencies = Seq("org.scalatest" %% "scalatest" % "3.0.0" % "test")

libraryDependencies ++= (mainDependencies ++ testDependencies)
