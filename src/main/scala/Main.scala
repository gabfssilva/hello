
import akka.actor.ActorSystem
import spray.routing.SimpleRoutingApp

/**
  * @author Gabriel Francisco <gabfssilva@gmail.com>
  */
object Main extends App with SimpleRoutingApp {
  implicit val system = ActorSystem("hello-world-system")

  val interface = args(0)
  val port = args(1).toInt

  startServer(interface = interface, port = port) {
    path("hello") {
      get {
        complete {
          "hello, world!"
        }
      }
    } ~
    path("health") {
      get {
        complete {
          "ok!"
        }
      }
    }
  }
}
