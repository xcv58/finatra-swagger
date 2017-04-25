package com.jakehschwartz.finatra.swagger

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import io.swagger.models.Swagger
import io.swagger.util.Json

class DocsController(docPath: String = "/api-docs", swagger: Swagger) extends Controller {
  get(s"$docPath/model") { _: Request =>
    response
      .ok(Json.mapper.writeValueAsString(swagger))
      .contentTypeJson
  }

  get(s"$docPath/ui") { _: Request =>
    response
      .temporaryRedirect
      .location(s"/webjars/swagger-ui/2.2.8/index.html?url=$docPath/model")
  }
}
