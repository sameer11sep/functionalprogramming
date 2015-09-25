package com.xebia.training

/**
 * Created by sameerarora on 9/12/15.
 */
class Training(c: String) {

  val a: Int = 5

  var b: Int = 10

  /*def foo() = {

    if (a < b) {
      a + b
    } else println("hello")

  }*/

  def add(x: Int, y: Int) = x + y

  def expression(a: Int, f: (Int, Int) => Int) = {
    a * f(5, a)
  }

  def foo(a: Int, b: String) = {
    print(b)
    a
  }

  val foo1: (String) => Int = foo(1, _)

  def expr(a: Int, f: (Int, String) => Int) = {
    foo1("String")
  }

  //expr(3,foo1)

 // foo1("Smamamam")

  expression(5, (x: Int, y: Int) => x * y)


  expression(5, add)

  //Define a function expr which takes an integer value and applies a function which takes
  // a String and an int expression , prints the sring and adds the int expression to the first argument


}

object Test extends App {

  def add(x: Int, y: Int) = x + y

  def expression(a: Int, f: (Int, Int) => Int) = {
    a * f(5, a)
  }

  def foo(a: Int)( b: String) = {
    print(b)
    a
  }

  /*lazy val foo1: (String) => Int = {
    println("Partially applying")
    foo(1, _)
    1
  }
*/



  println("AAAAAAA")

  /*def expr(a: Int, f: (Int, String) => Int) = {
    foo1("String")
  }


  foo1("ABBCDDD")*/

  //expr(3,foo1)


  // foo1("Smamamam")

  expression(5, (x: Int, y: Int) => x * y)


  expression(5, add)

}

