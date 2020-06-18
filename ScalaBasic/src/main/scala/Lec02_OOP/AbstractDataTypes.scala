package Lec02_OOP

object AbstractDataTypes extends App {
  //Abstract
  abstract class Animal{ //can't not init
    val creatureType: String
    def eat(): Unit
  }

  class Dog extends Animal {
    val creatureType: String = "canine"
    //No need override keyword here
    def eat(): Unit = println("Crunch crunch")
  }
  val animal = new Dog


  //Traits
  trait Carnivore{
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded{
    //
  }

  class Crocodile extends Animal with Carnivore with ColdBlooded {
     val creatureType: String = "Croc"
     def eat(): Unit = println("NoamNoam")
     def eat(animal: Animal): Unit = println(s"I' m a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //trait vs abstract
  //-Traits do not have constructor parameters
  //-Multi traits may be inheritance by same class
  //-Trait == behavior, abstract class == "things"
}
