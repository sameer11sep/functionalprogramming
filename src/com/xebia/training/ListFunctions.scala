package com.xebia.training

/**
 * Created by sameerarora on 9/12/15.
 */
object ListFunctions extends App {

  val list: List[Int] = List[Int](1,2, 3, 4, 5)

  // 1 :: [2,3,4,5] 1 :: 2 :: [3,4,5] 1::2::..::5 :: Nil

  val strings: List[String] = List[String]("AB", "BA")

  def foo(x: Int) = x * x

  def bar(x: String) = x.reverse

  println(strings.map(bar))


  //to append an elemeny to list use list :+ x

  def map(list: List[Int], resultant: List[Int], p: Int => Int): List[Int] = list match {
    case Nil => resultant
    case x :: xs if (x % 2 == 0) => {
      map(xs, (resultant :+ p(x)), p)
    }
    case _ => map(list.tail, (resultant :+ 0), p)
  }


  println(map(list,List[Int](),foo))


}


