package hello.scala


import akka.actor.ActorSystem
import spray.routing.SimpleRoutingApp

import scala.language.postfixOps

/**
  * @author Gabriel Francisco <gabfssilva@gmail.com>
  */
object Main extends App with SimpleRoutingApp {
  implicit val system = ActorSystem("hello-world-system")

  val interface = args(0)
  val port = args(1).toInt

  startServer(interface = interface, port = port) {
    pathPrefix("hello-scala") {
      path("hello") {
        get {
          complete {
            s"hello-scala, world! running on $interface:$port"
          }
        }
      } ~
        path("health") {
          get {
            complete {
              "ok!"
            }
          }
        } ~ //this is for the loader.io verify our server
        path("loaderio-93f4cb143cf6225704731e0dfc39c59a" /) {
          get {
            complete {
              "loaderio-93f4cb143cf6225704731e0dfc39c59a"
            }
          }
        }
    }
  }
}
