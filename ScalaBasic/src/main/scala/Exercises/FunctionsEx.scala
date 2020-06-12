package Exercises

object FunctionsEx extends App {

  //MyAnswers
  def myGreeting(name: String, age: Int): String ={
    "Hi, my name is " + name + " and I am" + age + " years old."
  }
  println(greetingForKids("Quynh",20))


  def myFactorial(number: Int): Int ={
    @scala.annotation.tailrec
    def helpFunc(numberH: Int, helpNumber: Int = number): Int ={
      if(helpNumber == 1) numberH
      else helpFunc(numberH * helpNumber, helpNumber - 1)
    }
    helpFunc(number)
  }
  println(factorial(5))


  def myFibonacciNumber(number: Int): Int ={
    @scala.annotation.tailrec
    def helpFunc(numberH: Int, helpNumber: Int = 1, pinNumber: Int = 1, pinNumber2: Int = number): Int ={
      if (pinNumber == pinNumber2) numberH
      else helpFunc(numberH + helpNumber,helpNumber + helpNumber,pinNumber + 1)
    }
    helpFunc(number)
  }
  println(myFactorial(8))


  def myIsPrime(number: Int): Boolean ={
    def helpFunc(number: Int): Boolean ={
      // TODO: Code here
      true
    }
    helpFunc(number)
  }


  //Answer
  def greetingForKids(name: String, age : Int): String =
    "Hi, my name is " + name + " and I am " + age + " years old."
  println(greetingForKids("Quynh",20)) // Correct


  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n - 1)

  println(factorial(5)) //-Correct and better


  def fibonacci(n: Int): Int =
    if( n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  println(fibonacci(8)) //Fail


  def isPrime(n: Int): Boolean ={
    @scala.annotation.tailrec
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    isPrimeUntil(n / 2)
  }
  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))


}
