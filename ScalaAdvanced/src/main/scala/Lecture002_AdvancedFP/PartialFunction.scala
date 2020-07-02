package Lecture002_AdvancedFP

object PartialFunction extends App{
  val aFunction = (x: Int) => x + 1

  class FunctionNotApplicableException extends RuntimeException

  val aFussyFunction = (x: Int) =>
    if (x == 1) 2
    else if (x == 2) 3
    else if (x == 3) 4
    else throw new FunctionNotApplicableException

  val nicerFussyFunction = (x: Int) => x  match {
    case 1 => 2
    case 2 => 3
    case 3 => 4
    case 4 => 5
  }

  //partial function
  val aPartialFunction: PartialFunction[Int, Int] ={
    case 1 => 2
    case 2 => 3
    case 3 => 4
    case 4 => 5
  }
  println(aPartialFunction(1))
  println(aPartialFunction isDefinedAt 4)

  //Lift
  val lifted = aPartialFunction.lift
  println(lifted(2))
  println(lifted(213423))

  //Chain
  val pfChain = aPartialFunction.orElse[Int, Int] { //Not ={ at here
    case 45 => 46
    case 46 => 47
  }

  println(pfChain(2))
  println(pfChain(45))

  //PF extends normal function
  val aNormalPF: Int => Int ={
    case 1 => 100
  }

  //HOFs accept partial functions as well
  val aMappedList = List(1, 2, 3).map {
    case 1 => 100
    case 2 => 200
    case 3 => 300
      //If missing case will throw match err
  }
  println(aMappedList)

  //Partial Fucntion have one parameter only
}