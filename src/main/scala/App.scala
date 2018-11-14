import akka.actor.{ActorRef, ActorSystem, Props, Actor, PoisonPill}
object ActorPath extends App {
  val system = ActorSystem("Actor-Paths")
  val counter1 = system.actorOf(Props[Counter], "Counter")
  println(s"Actor Reference for counter1: ${counter1}")

  val counterSelection1 = system.actorSelection("counter")
  println(s"Actor selection for counter1: ${counterSelection1}")

  counter1 ! PoisonPill

  Thread.sleep(100)

  val counter2 = system.actorOf(Props[Counter],"counter")
  println(s"Actor Reference for count2 is: ${counter2}")

  val counterSelection2 = system.actorSelection("counter")
  println(s"Actor selection for counter3 is: ${counterSelection2}")

  system.terminate()
}