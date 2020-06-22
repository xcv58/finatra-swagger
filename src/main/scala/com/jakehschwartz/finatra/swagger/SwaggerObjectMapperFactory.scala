package com.jakehschwartz.finatra.swagger

import com.fasterxml.jackson.databind.ObjectWriter
import io.swagger.util.ObjectMapperFactory

object SwaggerObjectMapperFactory extends ObjectMapperFactory {
  lazy val jsonFactory: ObjectWriter = ObjectMapperFactory.createJson().writer()
}
