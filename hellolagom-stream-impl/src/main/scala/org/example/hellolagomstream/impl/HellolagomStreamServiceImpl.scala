package org.example.hellolagomstream.impl

import com.lightbend.lagom.scaladsl.api.ServiceCall
import org.example.hellolagomstream.api.HellolagomStreamService
import org.example.hellolagom.api.HellolagomService

import scala.concurrent.Future

/**
  * Implementation of the HellolagomStreamService.
  */
class HellolagomStreamServiceImpl(hellolagomService: HellolagomService) extends HellolagomStreamService {
  def stream = ServiceCall { hellos =>
    Future.successful(hellos.mapAsync(8)(hellolagomService.hello(_).invoke()))
  }
}
