name := "simple-scala-akkahttp-api"

version := "0.1"

scalaVersion := "2.12.7"

//required dependencies because akka HTTP depends on actors and streams

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.13",
  "com.typesafe.akka" %% "akka-stream" % "2.5.13",
  "com.typesafe.akka" %% "akka-http" % "10.1.3",
)