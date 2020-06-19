package Lec02_OOP

object Exceptions extends App{
  val x: String = null
  //println(x.length)

  //1. How to throw exceptions
  // val aWeirdValue: String = throw new NullPointerException
  //throwable classes extend the Throwable class.
  //Exception and Error are the major Throwable subtypes

  //2. How to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("No have int")
    else 42

  val potentialFail = try{
    //Code that might fail
    getInt(true)
  } catch{
    //case e: RuntimeException => println("Runtime exceptions")
    //case e: NullPointerException => println("No pointer exceptions")
    case e: RuntimeException => 43
  } finally{
    // Code that will get executed NO MATTER WHAT
    println("Finally")
    //Optional
    // Does not influence the return type of this expression
    //Use finally only for side effects
  }
  println(potentialFail)

  //3. How to define my own exceptions
  class MyException extends Exception{
    val exception = new MyException
    throw exception
   }

  /* Exercises
   1. Crash program with an OutOfMemoryError
   2. Crash program with StackOverflowError
   3. PocketCalculator
     -add(x, y)
     -subtract(x, y)
     -multiply(x, y)
     -divide(x, y)
    Throw
    - overflowException if add(x, y) exceeds Int.MAX_VALUE
    - UnderflowException if subtract(x, y) exceeds Int.MIN_VALUE
    -MathCalculationException for division by 0
    */
//  val array = Array.ofDim(Int.MaxValue) // Out of Memory Error
//
//  def infinite: Int = 1 + infinite
//  val noLimit = infinite // Stack Overflow Error

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator{
    def add(x: Int,y: Int): Int ={
      val result = x + y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if( x <0 && y < 0 && result > 0) throw  new UnderflowException
      else result
    }

    def subtract(x: Int, y : Int): Int = {
      val result = x - y
      if(x > 0 &&  y < 0 && result < 0) throw new OverflowException
      if( x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int ={
      val result = x * y
      if(x > 0 && y > 0 && result < 0) throw  new OverflowException
      else if(x < 0 && y < 0 && result < 0) throw new OverflowException
      else if(x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if(x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Int ={
      if( y == 0) throw new MathCalculationException
      else x/ y
    }
  }
  //println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))
}
