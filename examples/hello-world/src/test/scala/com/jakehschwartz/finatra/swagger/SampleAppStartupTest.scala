package com.jakehschwartz.finatra.swagger

import com.google.inject.Stage
import com.twitter.conversions.DurationOps._
import com.twitter.finatra.http.EmbeddedHttpServer

class SampleAppStartupTest extends SampleAppBaseTest {

  override def stage: Stage = Stage.PRODUCTION

  override lazy val server: EmbeddedHttpServer = makeServer("startupSampleApp")

  test("Startup and be healthy") {
    server.assertStarted()
    server.assertHealthy()
    server.close(20.seconds)
    server.assertCleanShutdown()
  }
}
