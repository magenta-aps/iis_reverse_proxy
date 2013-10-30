/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 2.0/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * Contributor(s):
 * Søren Kirkegård
 *
 * The code is currently governed by OS2 - Offentligt digitaliserings-
 * fællesskab / http://www.os2web.dk .
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */

import sbt._
import Keys._
import play.Project._
import de.johoop.findbugs4sbt.FindBugs._
import de.johoop.jacoco4sbt._
import JacocoPlugin._
import java.io.File

object ApplicationBuild extends Build {

  val appName         = "play-cpreader"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "joda-time" % "joda-time" % "2.3",
    "com.unboundid" % "unboundid-ldapsdk" % "2.3.4",
    "org.webjars" %% "webjars-play" % "2.2.0",
    "org.webjars" % "bootstrap" % "3.0.0-rc.2",
    "org.webjars" % "bootstrap-glyphicons" % "bdd2cbfba0",
    "com.google.inject" % "guice" % "3.0",
    "org.mockito" % "mockito-all" % "1.9.5",
    "org.pitest" % "pitest" % "0.31",
    "org.perf4j" % "perf4j" % "0.9.16"
    
    
  )
  
  // Update settings for findbugs and jacoco SBT plugins.
  lazy val s = playScalaSettings ++ findbugsSettings ++ Seq(jacoco.settings:_*)

  val main = play.Project(appName, appVersion, appDependencies, settings = s).settings(

    // Add 'pmd' command to Play console. 
    // Configuration file: project/pmd-ruleset.xml
    // Output file: target/pmd/pmd-report.txt
    PmdSettings.pmdTask,

    // Add 'checkstyle' command to Play console. 
    // Configuration file: project/checkstyle-config.xml
    // Output file: target/checkstyle/checkstyle-report.txt
    CheckstyleSettings.checkstyleTask,

    // Add 'api-doc' command (JavaDoc + ScalaDoc) to Play console. 
    // Output directory: target/doc/api
    ApiDocSettings.apiDocTask,

    // Add the 'findbugs' command to Play console.
    // Configuration file: project/findbugs-excludefilter.xml
    // Output file: target/findbugs/findbugs.xml
    // You want the report name file extension to match the report type. 
    findbugsReportType := Some(de.johoop.findbugs4sbt.ReportType.Xml),
    findbugsReportName := Some("findbugs.xml"),
    //findbugsTargetPath <<= target (_ / "findbugs"),
    //findbugsExcludeFilters <<= baseDirectory { base => Some(scala.xml.XML.loadFile(BuildPaths.projectStandard(base) / "findbugs-excludefilter.xml")) },

    // Add the 'jacoco:cover' command to Play console. 
    // Output file: target/jacoco/html/index.html
    parallelExecution      in jacoco.Config := false,
    jacoco.outputDirectory in jacoco.Config := file("target/jacoco"),
    jacoco.reportFormats   in jacoco.Config := Seq(XMLReport("utf-8"), HTMLReport("utf-8")),
    jacoco.excludes        in jacoco.Config := Seq("views*", "*Routes*", "controllers*routes*", "controllers*Reverse*", "controllers*javascript*", "controller*ref*")
    
  )

}