
import akka.actor.ActorSystem
import spray.routing.SimpleRoutingApp

/**
  * @author Gabriel Francisco <gabfssilva@gmail.com>
  */
object Main extends App with SimpleRoutingApp {
  implicit val system = ActorSystem("hello-world-system")

  startServer(interface = "localhost", port = System.getenv("$PORT0").toInt) {
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
