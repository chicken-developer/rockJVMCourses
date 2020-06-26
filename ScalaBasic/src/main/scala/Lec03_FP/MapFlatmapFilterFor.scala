package Lec03_FP

object MapFlatmapFilterFor extends App{
  //List
  val list = List(1, 2, 3)
  println(list)

  //map
  println(list.map(_ + 2))

  //fillter
  println(list.filter( _ % 2 == 0))

  //flatmap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val number = List(1, 2, 3)
  val character = List("a", "b", "c")
  val color = List("black", "white")

  val combinations = number.flatMap(number => character.flatMap(character => color.map(color => " " + number + character +" " + color)))
  println(combinations)

  //foreach
  list.foreach(println)

  //for-comprehensions
  val forCombinations = for {
    n <- number.filter(_ % 2 == 0)
    c <- character
    color <- color
  } yield n + " " + c + " " + color
  println(forCombinations)

  //Syntax overload
  list.map{ x =>
    x * 2
  }
}
