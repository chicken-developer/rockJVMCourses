package Lec01_Basic

object StringOps extends App {
  val aStr: String = "Hello I am learning Scala"

  println(aStr.charAt(2)) // Print character at aStr[2]
  println(aStr.substring(7,11)) // Print characters at aStr[7 - 12]
  println(aStr.split(" ").toList)
  println(aStr.startsWith("Hello")) // true
  println(aStr.replace(" ","."))
  println(aStr.toLowerCase)
  println(aStr.length)
  println(aStr.reverse)
  println(aStr.take(5))

  val numberStr = "234234234"
  val aNumber = numberStr.toInt + 1
  println(aNumber)
  println('a' +: numberStr :+ 'z')

  //S - intepolator
  val name = "quynh"
  val age = 20
  val greeting = s"Hi, my name is $name and I am $age year old"
  val otherGreeting = s"Hi, my name is ${name.toUpperCase} and I am ${age * 2} year old"
  println(greeting)
  println(otherGreeting)

  //F - intepolator - Like printf
  val otherName = "Quynh"
  val eatSpeed = 100.2f
  val fStr = f"$name%s can eat $eatSpeed%1.4f burgers per minute"
  //1.4%f ....Viet 1 so truoc dau . va 4 so sau dau .
  // Neu ph
  println(fStr)
  //Use %s %f %d to check type

  //raw - intepolator
  println(raw"This is \n new line")
  val escaped = "This is \n new line"
  println(escaped)
  println(raw"$escaped")
}
