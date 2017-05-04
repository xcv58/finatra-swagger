name := "finatra-swagger"

organization := "com.jakehschwartz"

scalaVersion := "2.12.2"

sbtVersion := "0.13.15"

version := "2.9.1-SNAPSHOT"

libraryDependencies ++= Seq(
  "com.twitter" %% "finatra-http" % "2.9.0",
  "io.swagger" % "swagger-core" % "1.5.13",
  "io.swagger" %% "swagger-scala-module" % "1.0.3",
  "org.webjars" % "swagger-ui" % "3.0.7",
  "net.bytebuddy" % "byte-buddy" % "1.6.13",
  "org.scalatest" % "scalatest_2.12" % "3.0.2" % "test"
)

scalacOptions ++= Seq(
  "-feature",
  "-language:existentials",
  "-language:implicitConversions"
)

pomIncludeRepository := { _ => false }

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomExtra in Global := {
  <url>https://jakehschwartz.github.io/finatra-swagger</url>
    <licenses>
      <license>
        <name>Apache 2</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      </license>
    </licenses>
    <scm>
      <connection>https://github.com/jakehschwartz/finatra-swagger.git</connection>
      <developerConnection>https://github.com/jakehschwartz/finatra-swagger.git</developerConnection>
      <url>https://github.com/jakehschwartz/finatra-swagger</url>
    </scm>
    <developers>
      <developer>
        <id>jakehschwartz</id>
        <name>Jake Schwartz</name>
        <url>https://www.jakehschwartz.com</url>
      </developer>
      <developer>
        <id>xiaodongw</id>
        <name>Xiaodong Wang</name>
        <url>https://github.com/xiaodongw</url>
      </developer>
    </developers>
}