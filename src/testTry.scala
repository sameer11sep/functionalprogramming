import scala.util.Try

/**
 * Created by sameerarora on 5/26/15.
 */
object testTry extends App {


  def bar(i: Int): Integer = {
    i match {
      case 1 => throw new IllegalStateException("Exception")
      case _ => 10
    }
  }

  def foo(i: Int): Option[Integer] = {
    Option(Try(bar(i)) recover {
      case e: RuntimeException => println("Exception Occurred ...")
        null
    } getOrElse null)
  }

  println(foo(1))
  println(foo(2))


  val a: Array[String] = Array[String]("a", "b", "c", "d")

  a.length match {
    case 0 => println("Array is empty")
    case _ => println("Yippie " + a.mkString)

  }


}
