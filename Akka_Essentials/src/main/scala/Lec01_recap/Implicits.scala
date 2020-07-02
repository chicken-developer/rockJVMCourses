package Lec01_recap
//I'm learning at Udemy from another computer
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

  case class Purchase(nUnits: Int, unitPrice: Double)
  object Purchase{
    implicit val totalPriceOrdering: Ordering[Purchase] = Ordering.fromLessThan((a,b) => a.nUnits * a.unitPrice > b.nUnits * b.unitPrice)
  }
  object UnitCountOrdering{
    implicit val unitCountOrdering: Ordering[Purchase] = Ordering.fromLessThan(_.nUnits < _.nUnits)

  }
  object UnitCountOrder{
    implicit val unitPriceOrdering: Ordering[Purchase] = Ordering.fromLessThan(_.unitPrice < _.unitPrice)
  }
  val purchase = List(
    Purchase(2,20000),
    Purchase(4,50000),
    Purchase(5,10000)
  )
  import UnitCountOrder._
  println(purchase.sorted)

}
