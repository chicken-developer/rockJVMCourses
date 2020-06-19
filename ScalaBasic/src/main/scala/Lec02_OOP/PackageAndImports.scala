package Lec02_OOP

import java.sql
import java.util.Date

import Playground.DemoPackage.{sayHelp, SPEED_OF_LIGHT => speed}

object PackageAndImports extends App{
  //val writer = new Writer("Quynh","Scala Basic", 2020)

 // val demo = new Demo // Playground.DemoPackage.Demo = fully qualified name

  //package are in hierarchy
  //matching folder structure

  //package object
  sayHelp()
  println(speed)

  //imports
  val date = new Date()
  val sqlDate = new sql.Date(2020,6,18)
  //using aliasing

  //default imports
  //java.lang - String, Object, Exception
  //scala - Int, Nothing, Function
  //scala.Predef - println(), ???

}
