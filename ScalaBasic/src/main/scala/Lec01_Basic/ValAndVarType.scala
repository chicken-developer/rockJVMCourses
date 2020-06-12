package Lec01_Basic

object ValAndVarType extends App{
  val x: Int = 42 // Val is immutable
  val aString: String  = "Hello"
  val aBool: Boolean = true
  val aChar: Char= 'a'
  val aNumber: Int = x
  val aShort: Short = 223
  val aLong: Long = 55324234234234L //last L character
  val aFloat: Float = 2.0f //last f character
  val aDouble: Double = 3.14

  var aVariable = 5 // Mutable
  aVariable = 10 // Side effect


  println(x)
}