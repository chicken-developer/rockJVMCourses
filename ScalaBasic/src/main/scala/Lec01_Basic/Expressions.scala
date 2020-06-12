package Lec01_Basic

object Expressions extends App {
  val x = 1 + 2
  println(x)
  var aVariable = 5
  val aCondition = true
  val aValue = if(aCondition) 5 else 3

  //NEVER WRITE CODE LIKE THIS
  var number = 0
  while (number < 10){
    println(number)
    number += 1
  }
  // NEVER.

  //Everything in Scala is expression

  val aWeirdValue: Unit = (aVariable = 3)  // Unit === void

  //Code block
  val aCodeBlock = {
    val y = 2
    val z = 10
    if(y > 2) "hello" else "goodbye"
    //The last line is return type of code block
  }
}
