import play.Project._

name := "play-cpreader"

version := "1.0.1-SNAPSHOT"

libraryDependencies ++= Seq(
  cache,
  "joda-time" % "joda-time" % "2.3",      
  "com.unboundid" % "unboundid-ldapsdk" % "2.3.4",
  "com.google.inject" % "guice" % "3.0",
  "org.perf4j" % "perf4j" % "0.9.16",
  "org.mockito" % "mockito-all" % "1.9.5" % "test")     

play.Project.playJavaSettings

requireJs += "main.js"

requireJsShim += "main.js"

lazy val jaxws = project

lazy val root = project.in(file("."))
    .aggregate(jaxws)
    .dependsOn(jaxws)