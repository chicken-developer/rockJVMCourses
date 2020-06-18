//package Exercises
// Comment for run OOEX file
//abstract class MyListGenerics[+A] {
//  //Head: first elements of the list
//  /*
//  tail: remainder of the list
//  isEmpty = bool isEmpty LIst
//  add(Int)
//  toString
//   */
//
//  def head: A
//  def tail: MyListGenerics[A]
//  def isEmpty: Boolean
//  def add[B >: A](element: B): MyListGenerics[B]
//  def printElements: String
//  override def toString: String = "[" + printElements + "]"
//}
//
//object Empty extends MyListGenerics[Nothing]{
//  def head: Nothing = throw new NoSuchElementException
//  def tail:MyListGenerics[Nothing] = throw new NoSuchElementException
//  def isEmpty: Boolean = true
//  def add[B >: Nothing](element: B): MyListGenerics[B] = new Cons(element,Empty)
//  def printElements: String = ""
//}
//
//class Cons[+A](_head: A, _tail: MyListGenerics[A]) extends MyListGenerics[A] {
//  def head: A = _head
//  def tail: MyListGenerics[A] = _tail
//  def isEmpty: Boolean = false
//  def add[B >: A](element: B): MyListGenerics[B] = new Cons(element,this)
//  def printElements: String =
//    if (_tail.isEmpty) "" + _head
//    else _head + " " + _tail.printElements
//}
//
//object ListTest extends App{
// val listOfIntegers: MyListGenerics[Int] = new Cons(1, new Cons(2,new Cons(3, Empty)))
//  println(listOfIntegers.toString)
// val listOfStrings: MyListGenerics[String] = new Cons("hello", new Cons("world", new Cons("from scala", Empty)))
//  println(listOfStrings.toString)
//}
