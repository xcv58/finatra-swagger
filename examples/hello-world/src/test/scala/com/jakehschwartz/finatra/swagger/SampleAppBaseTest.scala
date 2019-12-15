package com.jakehschwartz.finatra.swagger

import com.google.inject.Stage
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest
import org.scalatest.Matchers

trait SampleAppBaseTest extends FeatureTest with Matchers {

  override protected def beforeEach(): Unit = {
    server.assertStarted()
    server.assertHealthy()
  }

  def stage: Stage = Stage.DEVELOPMENT
  override def server: EmbeddedHttpServer

  protected def makeServer(serverName: String): EmbeddedHttpServer = new EmbeddedHttpServer(
    twitterServer = new SampleApp { override val name: String = serverName },
    stage = stage
  )

}
