package org.example.hellolagomstream.api

import akka.NotUsed
import akka.stream.scaladsl.Source
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}

/**
  * The hellolagom stream interface.
  *
  * This describes everything that Lagom needs to know about how to serve and
  * consume the HellolagomStream service.
  */
trait HellolagomStreamService extends Service {

  def stream: ServiceCall[Source[String, NotUsed], Source[String, NotUsed]]

  override final def descriptor = {
    import Service._

    named("hellolagom-stream")
      .withCalls(
        namedCall("stream", stream)
      ).withAutoAcl(true)
  }
}

