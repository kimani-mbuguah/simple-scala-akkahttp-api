import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.concurrent.{Await, ExecutionContext}
import akka.http.scaladsl.server.Directives._

import scala.util._
import scala.concurrent.duration._

object Server extends App {
  val host = "0.0.0.0"
  val port = 9000

  implicit val system: ActorSystem = ActorSystem("helloworld")
  implicit val executor: ExecutionContext = system.dispatcher
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  def route = path("hello") {
    get {
      complete("Hello, World!")
    }
  }

  val bindingFuture = Http().bindAndHandle(route, host, port)

  bindingFuture.onComplete {
    case Success(serverBinding) => println(s"listening to ${serverBinding.localAddress}")
    case Failure(error) => println(s"error: ${error.getMessage}")
  }

  Await.result(bindingFuture, 3.seconds)

}
