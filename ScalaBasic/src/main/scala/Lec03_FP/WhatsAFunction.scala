package Lec03_FP

object WhatsAFunction extends App{

  val doubler = new MyFunction[Int, Int] {
    override def apply(elem: Int): Int = elem * 2
  }
  println(doubler(2))
  //function type = Function[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }
  println(stringToIntConverter("20") + 2)

  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  //Function type Function2[A, B, R] === (A, B) => R
  //ALL SCALA FUNCTIONS ARE OBJECT
  println(adder(2,3))
}

trait MyFunction[A, B]{
  def apply(element: A): B
}