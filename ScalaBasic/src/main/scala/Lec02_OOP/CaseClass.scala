package Lec02_OOP

object CaseClass extends App {
  case class Person(name: String, age: Int)
  // 1. case class parameters are fields
  val jim = new Person("Jim",34)
  println(jim.name)

  //2. Sensible to string
  println(jim.toString)
  println(jim) // println(instance) == println(instance.toString)

  //3. Equals and hashCode implemented OOTB
  val jim2 = new Person("Jim",34)
  println(jim == jim2) // true

  //4. Have copy method
  val jim3 = jim.copy(age = 45) // Copy all jim info, but age is 45
  println(jim3)

  //5. Have companion objects
  val thePerson = Person
  val mary = Person("Mary", 25)

  //6. Are serializable
  //Akka

  //7. Have extractor patterns = can be used in PATTERN MATCHING

  //8. Case object == same as case class
  case object UnitedKingdom{
    def name: String = "The UK of GB and NI"
  }
}
