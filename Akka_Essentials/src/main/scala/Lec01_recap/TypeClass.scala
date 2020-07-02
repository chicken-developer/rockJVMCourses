package Lec01_recap
//I'm learning on Udemy from another Computer
object TypeClass extends App{

  trait HTMLWriteable{
    def toHTml: String
  }
  case class User(name: String,age: Int, email: String) extends HTMLWriteable{
    override def toHTml: String = s" <div> $name ($age yo) <a href=$email/> </div>"
  }
  User("John",20,"john@gmail.com").toHTml
  /*
  1 - for the types we write
  2 - ONE implementation out of quite a number
   */

  // Option 2: Pattern matching
  object HtmlSerializerPM{
    def serializeToHtml(value: Any) = value match {
      case User(n, a, m) =>
    //  case java.util.Date =>
      case _ =>
    }
  }
  /*
  Lost type safe
  Need to modify the code every time
  still ONE implementation
   */

  //Better option
  trait HTMLSerializer[T]{
    def serializable(value: T): String
  }
  object UserSerializer extends HTMLSerializer[User]{
    override def serializable(user: User): String = s" <div> ${user.name} (${user.age} yo) <a href=${user.email}/> </div>"
  }
  val john = User("John",20,"John@email")
  println(UserSerializer.serializable(john))

  //Benefits
  //1. We can define serializers for others types
  import java.util.Date
  object DateSerializer extends HTMLSerializer[Date]{
    override def serializable(date: Date): String = s"<div> {${date.toString} </div>"
  }
}
