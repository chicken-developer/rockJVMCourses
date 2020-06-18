package Exercises

object OOEx extends App {
  /*
  1. Generics trait MyPredicate[-T] with a little method test(T) => Boolean
  2. Generic trao MyTransformer[-A, B] with a method transform(A) => B
  3. MyList:
    map(transformer) => MyList
    filter(predicate) => MyList
    flatMap(transformer from A to MyList[B]) => MyList[B]

   class EvenPredicate extends MyPredicate[Int]
   class StringToIntTransformer extends MyTransformet[String, Int]
   [1, 2, 3].map(n * 2) = [2, 4, 6]
   [1, 2, 3, 4].filter(n % 2) = [2, 4]
   [1, 2, 3].flatMap(n => [n, n + 1]) = [1, 2, 2, 3, 3, 4]
   */
}

abstract class MyListGenerics[+A] {
  def head: A
  def tail: MyListGenerics[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListGenerics[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B](transformer: MyTransformer[A, B]): MyListGenerics[B]
  def flatMap[B](transformer: MyTransformer[A, MyListGenerics[B]]): MyListGenerics[B]
  def filter(predicate: MyPredicate[A]): MyListGenerics[A]
  def ++[B >: A](list: MyListGenerics[B]): MyListGenerics[B]
}

object Empty extends MyListGenerics[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail:MyListGenerics[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyListGenerics[B] = new Cons(element,Empty)
  def printElements: String = ""
  def map[B](transformer: MyTransformer[Nothing, B]): MyListGenerics[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyListGenerics[B]]): MyListGenerics[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyListGenerics[Nothing] = Empty
  def ++[B >: Nothing](list: MyListGenerics[B]): MyListGenerics[B] = list
}

class Cons[+A](_head: A, _tail: MyListGenerics[A]) extends MyListGenerics[A] {
  def head: A = _head
  def tail: MyListGenerics[A] = _tail
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyListGenerics[B] = new Cons(element,this)
  def printElements: String =
    if (_tail.isEmpty) "" + _head
    else _head + " " + _tail.printElements
  def map[B](transformer: MyTransformer[A, B]): MyListGenerics[B] =
    new Cons(transformer.transform(_head), _tail.map(transformer))
/*
[1, 2, 3].map(n * 2) = new Cons(2, [2, 3].map(n * 2))
                     = new Cons(2, new Cons(4, [3].map(n * 2)))
                     = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
                     = new Cons(2, new Cons(4, new Cons(6, Empty)))
 */


  def filter(predicate: MyPredicate[A]): MyListGenerics[A] =
    if(predicate.test(_head)) new Cons(_head, _tail.filter(predicate))
    else _tail.filter(predicate)
  /*
  [1, 2, 3].filter(n  % 2 == 0) =
     [2, 3].filter(n % 2 == 0) =
    = new Cons(2, [3].filter(n % 2 == 0))
    = new Cons(2, Empty.filter(n % 2 == 0))
    = new Cons(2 , Empty)
   */

  def ++[B >: A](list: MyListGenerics[B]): MyListGenerics[B] = new Cons(_head, _tail ++ list)
  /*
  [1, 2] ++ [3, 4, 5]
  = new Cons(1, [2] ++ [3, 4, 5])
  = new Cons(1, new Cons(2, Empty ++ [3, 4, 5]))
  = new Cons(1, new Cons(2, new Cons(3, new Cons(44, new Cons(5)))))
   */
  def flatMap[B](transformer: MyTransformer[A, MyListGenerics[B]]): MyListGenerics[B] =
    transformer.transform(_head) ++ _tail.flatMap(transformer)
  /*
  [1, 2].flatMap(n => [n, n + 1])
  = [1, 2] ++ [2].flatMap(n => [nm n + 1])
  = [1, 2] ++ [2, 3] ++ Empty.flatmap(n => [n, n + 1])
  = [1, 2] ++ [2, 3] ++ Empty
  = [1, 2, 2, 3]
   */
}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B]{
  def transform(elem: A): B
}

object ListTest extends App{
  val listOfIntegers: MyListGenerics[Int] = new Cons(1, new Cons(2,new Cons(3, Empty)))
  val anotherListOfIntegers: MyListGenerics[Int] = new Cons(4, new Cons(5,new Cons(6, Empty)))

  println(listOfIntegers.toString)
  val listOfStrings: MyListGenerics[String] = new Cons("hello", new Cons("world", new Cons("from scala", Empty)))
  println(listOfStrings.toString)

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(listOfIntegers.filter( new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)
  println(listOfIntegers.flatMap(new MyTransformer[Int, MyListGenerics[Int]] {
    override def transform(elem: Int): MyListGenerics[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  }).toString)
}
