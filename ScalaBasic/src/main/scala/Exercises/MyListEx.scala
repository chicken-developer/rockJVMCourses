//package Exercises
// Just comment for run MyListGenerics Ex
//abstract class MyList {
//    //Head: first elements of the list
//  /*
//  tail: remainder of the list
//  isEmpty = bool isEmpty LIst
//  add(Int)
//  toString
//   */
//
//  def head: Int
//  def tail: MyList
//  def isEmpty: Boolean
//  def add(element: Int): MyList
//  def printElements: String
//  override def toString: String = "[" + printElements + "]"
//}
//
//object Empty extends MyList{
//  def head: Int = throw new NoSuchElementException
//  def tail: MyList = throw new NoSuchElementException
//  def isEmpty: Boolean = true
//  def add(element: Int): MyList = new Cons(element,Empty)
//  def printElements: String = ""
//}
//
//class Cons(_head: Int, _tail: MyList) extends MyList{
//  def head: Int = _head
//  def tail: MyList = _tail
//  def isEmpty: Boolean = false
//  def add(element: Int): MyList = new Cons(element,this)
//  def printElements: String =
//    if (_tail.isEmpty) "" + _head
//    else _head + " " + _tail.printElements
//}
//
//object ListTest extends App{
//  val list = new Cons(1,new Cons(2,new Cons(3,Empty)))
//  println(list.tail.head)
//  println(list.add(4).head)
//  println(list.toString)
//}
