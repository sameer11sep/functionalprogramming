package com.xebia.training.implicitparam

/**
 * Created by sameerarora on 9/8/15.
 */
object BubbleSort extends App {

  def sort[T](input: List[T])(implicit f: (T, T) => Boolean): List[T] = {
    input match {
      case head :: tailHead :: tail => {
        if (f(input.head, input.tail.head)) {
          sort(List(input.tail.head, input.head) ::: input.tail.tail)
        } else {
          val sortResult = sort(input.tail)
          if (f(input.head, sortResult.head))
            sort(List(sortResult.head, input.head) ::: sortResult.tail)
          else
            List(input.head) ::: sortResult
        }
      }
      case _ => input
    }
  }


  implicit def gtI(l: Int, r: Int): Boolean = l > r

  implicit def gtS(l: String, r: String): Boolean = l.compareTo(r) > 0

  println(sort(List[String]("Sameer", "Aditya", "Yoshis", "Toads", "Hammers")))

}
