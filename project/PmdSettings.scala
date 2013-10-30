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

//Adapted from https://github.com/ymasory/sbt-code-quality.g8
object PmdSettings {

  val pmd = TaskKey[Unit]("pmd", "run pmd, placing results in target/pmd")
  val pmdTask = pmd <<=
    (streams, baseDirectory, sourceDirectory in Compile, target) map {
      (streams, base, src, target) =>
      import net.sourceforge.pmd.PMD.{ main => PmdMain }
      import streams.log
      val outputDir = (target / "pmd").mkdirs
      val outputFile = (target / "pmd" / "pmd-report.xml").getAbsolutePath

      val args = List(
          src.getAbsolutePath,
          "xml",
          (base / "project" / "pmd-ruleset.xml").getAbsolutePath,
          "-reportfile", outputFile
      )

      log info ("Running PMD...")
      trappingExits {
        PmdMain(args.toArray)
      }
      
      // Print out results to console
      val source = scala.io.Source.fromFile(outputFile)
      log info (source.mkString)
      source.close()
    }

  def trappingExits(thunk: => Unit): Unit = {
    val originalSecManager = System.getSecurityManager
    case class NoExitsException() extends SecurityException
    System setSecurityManager new SecurityManager() {
      import java.security.Permission
      override def checkPermission(perm: Permission) {
        if (perm.getName startsWith "exitVM") throw NoExitsException()
      }
    }
    try {
      thunk
    } catch {
      case _: NoExitsException =>
      case e => throw e
    } finally {
      System setSecurityManager originalSecManager
    }
  }
}
  