package com.xebia.training

/**
 * Created by sameerarora on 9/12/15.
 */
class CaseClasses {

  val p = Person("a", 21)

  private val unapply: Option[(String, Int)] = Person.unapply(p)

  val b = new Person1("AAAA");

  val a: (Int, String, Float) = (1, "AAA", 1.0f)
  a._3

}

class Person1(name: String)

case class Person(name: String, age: Int)

/*
object Person {

  def apply(name: String): Person = {
    Person(name, 20)
  }

  def apply():Person={
    Person("hhah")
  }

  def unapply(p: Person): (String) = (p.name)
}
*/



