package Exercises

object MethodNotationEx extends App {
  class Person(val name: String, favoriteMovie: String,val age: Int = 0){
    def likes(movies: String): Boolean = movies == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    //Override
    def +(nickname: String): Person = new Person(s"$name ($nickname)",favoriteMovie )
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def learn(thing: String) = s"$name is learning $thing"
    def learnScala: String = this learn("Scala")
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    //Override apply
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }

  val mary = new Person("Mary","DETROIT")
  println((mary + "The rock start") ())
  println((+mary).age)
  println(x = mary learnScala)
  println(mary(10))
}
