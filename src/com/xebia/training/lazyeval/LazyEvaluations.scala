package com.xebia.training.lazyeval

/**
 * Created by sameerarora on 9/9/15.
 */
object LazyEvaluations extends App {

  def a: Int = {
    print(" a ");
    1
  }

  val b: Int = {
    print(" b ");
    2
  }

  lazy val c: Int = {
    print(" c ");
    3
  }

  private val result: Int = c + (b + a) + (b + a + a)

  println("Result " + result)

}
