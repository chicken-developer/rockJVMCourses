package Lec02_OOP

object MethodNotation extends App{
 class Person(val name: String, val favoriteMovie: String){
   def likes(movie: String): Boolean = this.favoriteMovie == movie
   def +(per: Person):String = s"${this.name} is hang out with ${per.name}"
   def unary_! : String = s"$name, what the heck!"//Put unary_! <space> :      not unary_!:
   def isAlive: Boolean = true // No have parameter
   def apply(): String = s"Hi, my name is $name and i like $favoriteMovie"
 }
  val marry = new Person("Marry","XCOM")
  val tom = new Person("Tom","XCOM 2")
  println(marry.likes("XCOM"))
  println(marry likes "XCOM") //Infix notation = operator notation(syntactic sugar)
  println(marry + tom)
  println(marry+(tom))
  println(1 + 2)
  println(1 +(2))
  //ALL OPERATORS ARE METHODS.

  //prefix notation
  val x = -1 //Equivalent with 1.unary_-
  val y = 1.unary_-
  println(!marry)
  println(marry.unary_!)
  //unary_prefix only work with + - * /

  //postfix notation
  println(marry.isAlive)
  //println(marry isAlive)

  //apply
  println(marry.apply()) // call this
  println(marry()) // when call object with nothing
}
