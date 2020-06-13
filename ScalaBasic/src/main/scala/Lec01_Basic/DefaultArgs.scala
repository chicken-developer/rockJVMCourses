package Lec01_Basic

object DefaultArgs extends App{
  def trFact(n: Int, acc: Int = 1): Int =
    if ( n <= 1) acc
    else trFact(n -1, n *acc)

  val fact10 = trFact(10)

  def savePicture(format: String = "", width: Int = 1920, height: Int = 1080): Unit =
    println("saving pictures")

  savePicture("",720,460)
  // savePicture(720) => Will fail
  savePicture(width = 720) //=> OK, that is name the arg
  savePicture(width = 1920,height = 1080,format = "png") //Can change location args
}
