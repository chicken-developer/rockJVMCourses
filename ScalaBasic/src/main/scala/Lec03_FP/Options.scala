package Lec03_FP

import scala.util.Random

object Options extends App{
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None
  println(myFirstOption)

  def unSafeMethod(): String = null
  val result = Some(unSafeMethod()) // Never use this

  val result_2 = Option(unSafeMethod())
  println(result_2)

  //Chained methods
  def backOFMethod() : String = "A valid result"
  val chainedResult = Option(unSafeMethod()).orElse(Option(backOFMethod()))

  //Design unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterbackupMethod(): Option[String] = Some("A valid result")
  val betterChainedResult = betterUnsafeMethod() orElse betterbackupMethod()

  //functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // Unsafe - not use this -> can throw null pointer exception

  //map, flatmap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(_ > 0))
  println(myFirstOption.flatMap(x => Option(x * 10)))
  //for-comprehensions

  val config: Map[String, String] = Map (
    "host" -> "192.168.1.1",
    "port" -> "8080"
  )
  class Connection{
    def connect = "Connected" //Connect to some server
  }

  object Connection{
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  val host = config.get("host")
  val port = config.get("port")
  /*
  if( h != null)
    if(c != null)
      return Connection.apply(h,p)
   return
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h,p)))
  /*
  if( c != null)
    return c.connect
  return null
   */
  val connectionStatus = connection.map(c => c.connect)
  connectionStatus.foreach(println)

  //Chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  //for - comprehensions
  val forconnectionStatus = for{
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  forconnectionStatus.foreach(println)
}
