package org.scala.api

import akka.actor.{Props, ActorSystem}
import akka.io.IO
import akka.util.Timeout
import spray.can.Http

/**
  * Created by dimas on 29/01/16.
  */
object Boot extends App{

  // Create actor system //
  implicit val system = ActorSystem("rest-api")
  val service = system.actorOf(Props[SJServiceActor], "sj-rest-api")

  // Bind HTTP to the specified service //
  //implicit val timeout = Timeout(
  IO(Http) ! Http.Bind(service, interface = "localhost", port = 8080)

}
