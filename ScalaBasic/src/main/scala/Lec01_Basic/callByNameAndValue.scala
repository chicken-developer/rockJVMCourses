package Lec01_Basic

object callByNameAndValue extends App{

  def callByValue(x: Long): Unit ={
    println("By value: " + x)
    println("By value: " + x)
  }

  def callByName(x: => Long): Unit ={
    println("By name: " + x)
    println("By name: " + x)
  }
  callByValue(System.nanoTime())
  callByName(System.nanoTime())
}
