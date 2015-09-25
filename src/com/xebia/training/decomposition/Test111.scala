package com.xebia.training.decomposition

/**
 * Created by sameerarora on 9/12/15.
 */
object Test111 extends App {

  private val person: Person  = new Person("") with Foo //with Bar
  println(person.foo(5))
}


case class Person(name: String) extends Foo with Bar {
  override def foo(x: Int) = //super.foo(1);
    println("Bar")
}



trait Bar  {
     def foo(x: Int) = //super.foo(1);
  println("Bar")
}

trait Foo  {
    def foo(x: Int) = //super.foo(1);
  println("Foo")
}


