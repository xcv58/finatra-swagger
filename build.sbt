name := "finatra-swagger"

organization := "com.jakehschwartz"

scalaVersion := "2.12.2"

sbtVersion := "0.13.15"

version := "2.9.0"

libraryDependencies ++= Seq(
  "com.twitter" %% "finatra-http" % "2.9.0",
  "io.swagger" % "swagger-core" % "1.5.13",
  "io.swagger" %% "swagger-scala-module" % "1.0.3",
  "org.webjars" % "swagger-ui" % "3.0.5",
  "net.bytebuddy" % "byte-buddy" % "1.6.13",
  "org.scalatest" % "scalatest_2.12" % "3.0.2" % "test"
)

homepage := Some(url("https://jakehschwartz.github.io/finatra-swagger"))

scmInfo := Some(ScmInfo(url("https://github.com/jakehschwartz/finatra-swagger"),
  "git@github.com:jakehschwartz/finatra-swagger.git"))

developers += Developer("jakehschwartz",
  "Jake Schwartz",
  "jakehschwartz@gmail.com",
  url("https://github.com/jakehschwartz"))

developers += Developer("xiaodongw",
  "Xiaodong Wang",
  "xiaodongw79@gmail.com",
  url("https://github.com/xiaodongw"))

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

pomIncludeRepository := (_ => false)