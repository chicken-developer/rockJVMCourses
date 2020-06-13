package Lec02_OOP

object OOPBasic extends App{
  val person = new Person("John",25)
  println(person.x)
  person.greeting("Dniel")
}

//Constructor
class Person(name: String, val age: Int) {
  //Body of class
  val x = 2
  println(x)

  def greeting(name: String): Unit = println(s"${this.name} say that: Hi, my name is $name") // print parameter name - obj name
  def greeting(): Unit = println(s"Hi, my name is $name") // print object name

  //Overloading

  //Multi constructor
  def this(name: String) = this(name,0)
}
//Class parameters are NOT FIELDS
//Add val or var to make parameters as class members
