
import akka.actor.ActorSystem
import spray.routing.SimpleRoutingApp

/**
  * @author Gabriel Francisco <gabfssilva@gmail.com>
  */
object Main extends App with SimpleRoutingApp {
  implicit val system = ActorSystem("hello-world-system")

  val port = args.headOption.orElse(Some("8080")).head.toInt

  startServer(interface = "localhost", port = port) {
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
