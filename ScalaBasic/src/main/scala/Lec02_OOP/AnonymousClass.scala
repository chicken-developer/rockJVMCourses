package Lec02_OOP

object AnonymousClass extends App {
  abstract class Animal{
    def eat: Unit
  }


  //Anonymous class
  val funnyAnimal: Animal = new Animal{
    override def eat: Unit = println("hahahahahah")
  }
  /* quivalent with:
  class AnonymousClass$$anon$1 extends Animal{
    override def eat: Unit = println("ahahahahahaha")
  }
  val funnyAnimal: Animal = new AnonymousClass$$anon$1
   */
  println(funnyAnimal.getClass)

  class Person(name: String){
    def sayHi: Unit = println(s"Hi, my name is $name, how can i help ?")
  }

  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi, my name is Jim")
  }
}
