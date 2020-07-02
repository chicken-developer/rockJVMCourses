package Lec01_recap

object Implicits extends App{
  implicit def reverseOrdering: Ordering[Int]  = Ordering.fromLessThan(_ > _)
 // implicit def normal: Ordering[Int]  = Ordering.fromLessThan(_ < _)

  println(List(4,21,1,5,6).sorted)


  case class Person(name: String, age: Int){
    // Method here
  }
  implicit def sortPerson: Ordering[Person] = Ordering.fromLessThan(_.age > _.age)
  val persons = List(
    Person("Quynh", 20),
    Person("An", 12),
    Person("Ngoc", 22)
  )
  println(persons.sorted)
}
