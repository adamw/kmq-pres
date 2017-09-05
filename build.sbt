import sbt._
import Keys._

name := "kmq-pres"
organization := "com.softwaremill"
scalaVersion := "2.12.3"

val kmqVersion = "0.2.1"

libraryDependencies ++= Seq(
  "com.softwaremill.kmq" %% "core" % kmqVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)
