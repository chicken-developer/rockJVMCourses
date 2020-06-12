package Lec01_Basic

object Functions extends App {
  def aFunction(a: String,b: Int): String ={
    "hello" + a + b
    //Can delete return type : String here
  }

  def aParameterLessFunction(): Int = 42
  println(aParameterLessFunction())

  def repeatString(aString: String, repeatTime: Int): String ={
    if(repeatTime == 1) aString
    else aString + repeatString(aString ,repeatTime - 1)
    //Can't delete return type : String here
  }

  def aBigFunc(n: Int): Int ={
    def aSmallFunc(a: Int, b: Int): Int ={
      a + b
    }
    aSmallFunc(n,n)
  }


}
