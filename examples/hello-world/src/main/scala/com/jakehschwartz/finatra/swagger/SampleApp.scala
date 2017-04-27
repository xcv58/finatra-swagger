package com.jakehschwartz.finatra.swagger

import javax.inject.Singleton

import com.google.inject.Provides
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter
import io.swagger.models.auth.BasicAuthDefinition
import io.swagger.models.{Info, Swagger}

object SampleSwaggerModule extends SwaggerModule {

  @Singleton
  @Provides
  def swagger: Swagger = {
    val swagger = new Swagger()

    val info = new Info()
      .description("The Student / Course management API, this is a sample for swagger document generation")
      .version("1.0.1")
      .title("Student / Course Management API")

    swagger
      .info(info)
      .addSecurityDefinition("sampleBasic", {
        val d = new BasicAuthDefinition()
        d.setType("basic")
        d
      })

    swagger
  }
}

object SampleApp extends HttpServer {

  override protected def modules = Seq(SampleSwaggerModule)

  override def configureHttp(router: HttpRouter) {
    router
      .filter[CommonFilters]
      .add[DocsController]
      .add[SampleController]
  }
}
