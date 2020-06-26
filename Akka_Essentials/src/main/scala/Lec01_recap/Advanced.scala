package Lec01_recap

object Advanced extends App {
  //partial function
  val partialFunction: PartialFunction[Int, Int] = {
    case 1 => 42
    case 3 => 65
    case 5 => 999
  }

  val pf = (x: Int) => x match {
    case 1 => 42
    case 3 => 65
    case 5 => 999
  }

  val function: (Int => Int) = partialFunction
  val modifiedList = List(1, 2, 3).map{
    case 1 => 42
    case _ => 0
  }


  //Lifting
val lifted = partialFunction.lift
  lifted(2) // Some(65)
  lifted(5000) // None

  //orElse
  val pfChain = partialFunction.orElse[Int, Int]{
    case 60 => 9000
  }
  pfChain(5) //=> 999
  pfChain(60) //=> 9000

  //Type aliases - like #define in c++
  type ReceiveFunction = PartialFunction[Any, Unit]
  def receive: ReceiveFunction ={
    case 1 => println("1")
    case _ => println("___")
  }

  //implicits

}
