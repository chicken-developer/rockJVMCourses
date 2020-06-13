package Exercises

object Recursion extends App {
  def myConcatString(aString: String, n: Int): String ={
    def helpConcat(aString: String,n: Int, helpString: String = ""): String =
      if (n <= 0) helpString
      else helpConcat(aString,n - 1,helpString + aString + " ")
  helpConcat(aString,n)
  }
  println(myConcatString("Hello", 5))


  def myIsPrime(n: Int): Boolean ={
    def helpFunc(number: Int, x: Int = n): Boolean ={
      true //TODO:Need code here
    }
    helpFunc(n)
  }
  println(myIsPrime(13*56))
  println(myIsPrime(101))


  def myFibonacci(n: Int) : Int ={
    def saveNumber(number: Int, total: Int = 0): Int =
      if (number == 0) total
      else saveNumber(number - 1,total) //TODO: Need code here
    saveNumber(n)
  }


  //Answers
  def concatenateTailrec(aString: String,n: Int,accumulator: String = ""): String =
    if( n <= 0) accumulator
    else concatenateTailrec(aString, n - 1, aString + accumulator )
  println(concatenateTailrec("Hello", 5))


  def isPrime(n: Int): Boolean ={
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if(t <= 1) true
      else isPrimeTailrec(t -1, n% t != 0 && isStillPrime)
    isPrimeTailrec(n/2,true)
  }
  println(isPrime(100))
  println(isPrime(2003))


  def fibonacci(n: Int): Int ={
    def fiboTailrec(i: Int, last: Int = 1, nextLast: Int = 1): Int =
      if( i >= n ) last
      else fiboTailrec(i + 1,last + nextLast, last)
    if (n <= 2) 1
    fiboTailrec(n)
  }
}
