import Counter._
import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor
class Counter extends Actor {
  var count = 0
  def receive = {
    case Inc(x) =>
      count += x
    case Dec(x) =>
      count -= x
  }

}

object Counter {
  final case class Inc(num: Int)
  final case class Dec(num: Int)
}
