package org.scala.api

import akka.actor.Actor
import spray.routing.HttpService

/**
  * Created by dimas on 29/01/16.
  */
class SJServiceActor extends SJService with Actor{

  // required as implicit value for the HttpService //
  // include from SJService //
  def actorRefFactory = context
  def receive = runRoute(rootRoute)
}
