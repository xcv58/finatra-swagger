# finatra-swagger
Add Swagger support to Finatra web framework.

Currently only supports Scala 2.12 with Finatra 2.9. 

For older versions, see the original repository by [xiaodongw](https://github.com/xiaodongw/swagger-finatra)

# Getting started

The major and minor version of the library matches the Finatra major and minor version:

    libraryDependencies += "com.jakehschwartz" %% "finatra-swagger" % "2.9.0"

First, add a Swagger object into the Server

    object SampleSwagger extends Swagger
    
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

Then configure the endpoints using the `SwaggerRouteDSL`

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

To see the Swagger UI, use the `/api-docs/ui` endpoint. To see the model that is JSON document that is generated, use
`/api-docs/model`