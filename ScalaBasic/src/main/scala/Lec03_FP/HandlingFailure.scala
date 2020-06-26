package Lec03_FP

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App{
  //Create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

  println(aSuccess)
  println(aFailure)

  def unSafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU BUSTER")
  val potentialFailure = Try(unSafeMethod)
  println(potentialFailure)

  //Syntax sugar
  val anotherPotentialFailure = Try{
    // Code here
  }

  //utilities
  println(potentialFailure.isSuccess)

  //orElse
  def backupMethod(): String = "A valid result"
  val fallbackTry = Try(unSafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry)

//IF Design API
  def betterUnsafemethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod():  Try[String] = Success("A valid result")

  val betterFallback = betterUnsafemethod() orElse betterBackupMethod()
  println(betterFallback)

  //map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.filter( _ > 0))
  println(aSuccess.flatMap(x => Success(x * 10)))

  //for-comprehensions
  val host = "localhost"
  val port = "8080"
  def renderHTML(page: String) = println(page)

  class Connection{
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if(random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService{
    val random = new Random(System.nanoTime())
    def getConnection(hostname: String, port: String): Connection ={
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Some else took the port")
    }

    def getSafeConnection(hostname: String, port: String): Try[Connection] = Try(getConnection(hostname,port))
  }

  val possibleConnection = HttpService.getSafeConnection(host, port)
  val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHTML.foreach(renderHTML)

  HttpService.getSafeConnection(host, port)
    .flatMap(collection => collection.getSafe("/home"))
    .foreach(renderHTML)


  for{
    connection <- HttpService.getSafeConnection(host, port)
    html <- connection.getSafe("/home")
  } renderHTML(html)
}
