package com.jakehschwartz.finatra.swagger

import com.google.inject.Provides
import io.swagger.models.auth.BasicAuthDefinition
import io.swagger.models.{Info, Swagger}
import javax.inject.Singleton

object SampleSwaggerModule extends SwaggerModule {

  @Singleton
  @Provides
  def swagger: Swagger = {
    val swagger = new Swagger()

    val info = new Info()
      .description(
        "The Student / Course management API, this is a sample for swagger document generation")
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
