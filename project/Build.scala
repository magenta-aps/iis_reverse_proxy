import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "play-cprlookupj"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "com.unboundid" % "unboundid-ldapsdk" % "2.3.4"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
