package Exercises

object OOPEx extends App {
  val author = new Writter("Quynh", "Nguyen",2000)
  val imposter = new Writter("Quynh", "Nguyen",2000)
  val noval = new Noval("C Basic",2020,author)
  println(noval.authorAge)
  println(noval.isWrittenBy(author))
  println(noval.isWrittenBy(imposter))

  val couter = new Counter
  couter.inc.print
  couter.inc.inc.inc.print
}
class Writter(firstName: String, surname: String, val year: Int){
  def fullName: String = firstName + " " + surname
}

class Noval(name: String, year: Int, author: Writter){
  def authorAge = year - author.year
  def isWrittenBy(author: Writter) = author == this.author
  def copy(newYear: Int): Noval = new Noval(name,newYear,author)
}

class Counter(val cout: Int = 0){
  def count = cout
  def inc = {
    println("Incrementing")
    new Counter(cout + 1)
  } // Immutable
  def dec ={
    println("Decrementing")
    new Counter(cout - 1)
  }

  def inc(n: Int): Counter = {
    if( n <= 0) this
    else inc.inc(n-1)
  //    new Counter(cout + n)
  }
  def dec(n: Int): Counter = {
    if(n <= 0) this
    else dec.dec(n-1)
    //new Counter(cout - n)
  }

  def print = println(count)
}