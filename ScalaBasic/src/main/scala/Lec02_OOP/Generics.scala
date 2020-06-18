package Lec02_O
object Generics extends App {
  class MyList[+A] {
    //Use type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
     B = Dog = Animal
     */
  }
  class MyMap[Key, Value]{

  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]
  val map = new MyMap[Int, String]

  //Generics method:
  object MyList{
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]
  //Varriance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //1. YES - List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? - HARD QUESTION => return List Animal

  //2. NO = INVARIANCE
  class InvarianceList[A]
  val invariantAnimalList: InvarianceList[Animal] = new InvarianceList[Animal]

  //3.Hell, no !Contravariance
  class ContravarianceList[-A]
  val contravarianceList: ContravarianceList[Cat] = new ContravarianceList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //Bounded typed
//  class Cage[A <:  Animal](animal: A) // Only accept type A( is a subtype of Animal Type)
//  val cage = new Cage(new Dog)
//  class Car
//  val newCage = new Cage(new Car) // Get err here
//  class Cage2[A >: Animal](animal: A) // Only accept type A( is a super type of Animal Type)


  //Expnad MyList to be generics

}
