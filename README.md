# swagger-finatra
Add Swagger support to Finatra web framework.

Currently only supports Scala 2.12 with Finatra 2.9. For older versions, see the
original repository by [xiaodongw](https://github.com/xiaodongw/swagger-finatra)

# Getting started

	resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/releases/"

    libraryDependencies += "com.jakehschwartz" %% "swagger-finatra" % "0.7.2"

## Add document information for you controller
    object SampleSwagger extends Swagger

    class SampleController extends Controller with SwaggerSupport {
      implicit protected val swagger = SampleSwagger

      getWithDoc("/students/:id") { o =>
        o.summary("Read the detail information about the student")
          .tag("Student")
          .routeParam[String]("id", "the student id")
          .responseWith[Student](200, "the student details")
          .responseWith(404, "the student is not found")
      } { request =>
        ...
      }

## Add document controller

##### Finatra 2.2.0
    object SampleApp extends HttpServer {
      val info = new Info()
        .description("The Student / Course management API, this is a sample for swagger document generation")
        .version("1.0.1")
        .title("Student / Course Management API")
      SampleSwagger.info(info)

      override def configureHttp(router: HttpRouter) {
        router
          .add[WebjarsController]
          .add(new SwaggerController(swagger = SampleSwagger))
          ...
      }
    }
Swagger API document: ```http://localhost:8888/api-docs/model```

Swagger UI: ```http://localhost:8888/api-docs/ui```
