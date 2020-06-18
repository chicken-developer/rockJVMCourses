package Lec02_OOP

object Objects extends App {
  //Scala not have static
  object Person{
    val N_EYES = 2
    def isCanFly: Boolean = false
    //Factory method:
    def apply(mother: Person, father: Person): Person = new Person("Boobie")
  }

  class Person(val name: String){
    //Design Pattern: COMPANIONS - object and class have same name in same file


  }
  println(Person.N_EYES)
  println(Person.isCanFly)
  //Object is Singleton - check by this:
  val mary = Person
  val john = Person
  println(mary == john) //true

  val mary_2 = new Person("mary")
  val john_2 = new Person("john")
  val boobie = Person(mary_2,john_2)
  println(mary_2 == john_2) // false

  //Scala application = scala object with main method like this:
  //def main(args: Array[String]): Unit

}
