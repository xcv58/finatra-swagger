name := "finatra-swagger-example"

scalaVersion := "2.12.11"

lazy val twitterReleaseVersion = "20.4.1"

lazy val swaggerUIVersion = SettingKey[String]("swaggerUIVersion")

swaggerUIVersion := "3.24.3"

libraryDependencies ++= Seq(
  "com.jakehschwartz" %% "finatra-swagger" % twitterReleaseVersion,
  "com.twitter" %% "finatra-http" % twitterReleaseVersion,
  "io.swagger" % "swagger-core" % "1.5.23",
  "io.swagger" %% "swagger-scala-module" % "1.0.6",
  "org.webjars" % "swagger-ui" % swaggerUIVersion.value,
  "net.bytebuddy" % "byte-buddy" % "1.10.5",
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)

resolvers +=
  "Twitter" at "https://maven.twttr.com"
