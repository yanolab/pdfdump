import AssemblyKeys._

name := "pdfdump"

version := "1.0"

organization := "com.izumobase"

scalaVersion := "2.9.2"

assemblySettings

mainClass in assembly := Some("com.izumobase.pdf.Main")

libraryDependencies ++= Seq(
		    "log4j" % "log4j" % "1.2.17",
		    "org.scalatest" %% "scalatest" % "1.8",
		    "junit" % "junit" % "4.10",
		    "com.lowagie" % "itext" % "2.1.7"
		    )
