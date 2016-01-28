package org.scala.api

import spray.http.MediaTypes
import spray.routing.HttpService

/**
  * Created by dimas on 29/01/16.
  */
trait SJService extends HttpService{

  var json = "{" + "\"" + "response_code" + "\"" + ":" + "\"" + "00" + "\"" + "}"

  def pingRoute = pathPrefix("scala"){
    pathPrefix("rest"){
      pathPrefix("api"){
        pathPrefix("v1.0"){
          pathPrefix("ping"){
            pathEnd{
              respondWithMediaType(MediaTypes.`application/json`)
              get { complete(json) }
            }
          }
        }
      }
    }
  }

  def pongRoute = path("pong"){
    get{ complete("ping") }
  }

  def rootRoute = pingRoute ~ pongRoute
}
