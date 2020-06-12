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
  println(factorial(10))

  //Err stack overflow if call like this:
  //println(factorial(5000))
  
}
