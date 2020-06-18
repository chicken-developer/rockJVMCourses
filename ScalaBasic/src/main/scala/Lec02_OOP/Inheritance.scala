package Lec02_OOP

object Inheritance extends App {
  sealed class Animal{ //Sealed: Cho phep ke thua va override trong cung 1 file
    val creatureType = "Wild"
    def eat(): Unit = println("NoamNoamNoam")
    final def cantOverride(): Unit = println("Can't override this")
  }

  class Cat extends Animal{
    def crunch(): Unit = {
      eat() //protected variable
      println("Crunch crunch")
    }
  }
  val cat = new Cat
  cat.crunch()

  //Constructor
  class Person(name: String, age: Int) {
    def this(name: String ) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  //Overriding
  class Dog(override val creatureType: String) extends Animal { //Short hand to override
    //override val creatureType = "Domestic"
    override def eat(): Unit = {
      super.eat()
      println("crunch, crunch")
    }

  }

  val dog = new Dog("Domestic")
  dog.eat()
  println(dog.creatureType)

  //Type substituation
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat()

  //overRIDING vs overLOADING
  //Super

  //Not override:
  //- Using "final" for method, val, var or class
  //-seal the class - in a file
}
