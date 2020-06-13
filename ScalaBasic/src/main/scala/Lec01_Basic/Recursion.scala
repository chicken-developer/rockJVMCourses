package Lec01_Basic

object Recursion extends App {
  //Stack memory have about 5000 slot for stack recursive
  def factorial(n: Int): Int ={
    if(n <= 1) 1
    else {
      println("Computing factorial of "+ n + " First need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computing factorial of " + n)

      result
    }
  }
  println("Factorial of 10: " +factorial(10))

  //Err stack overflow if call like this:
  //println(factorial(5000))

  def anotherFactorial(n: Int ): BigInt ={
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if(x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
    factHelper(n,1)
    //Tail recursion is use recursive call as the lass expression
  }
  println("Factory of 5000: " + anotherFactorial(5000))

}
