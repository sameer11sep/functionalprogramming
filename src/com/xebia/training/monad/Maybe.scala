package com.xebia.training.monad

/**
 * Created by sameerarora on 9/5/15.
 */
object Maybe {

  def apply[T](x: T): Maybe[T] = if (x != null) Be(x) else NotToBe

}

sealed abstract class Maybe[+T] {

  def isEmpty: Boolean

  def get: T

  def bind[B](f: T => Maybe[B]) = if (isEmpty) NotToBe else f(this.get)

}
final case class Be[T](x: T) extends Maybe[T] {
  def isEmpty = false

  def get = x
}

object NotToBe extends Maybe {
  def isEmpty = true

  def get = throw new NoSuchElementException("NotToBe.get")
}

object MayBeTest extends App {

  val maybe: Maybe[Int] = Maybe(5)

  val empty: Maybe[String] = Maybe(null)

  println(maybe.bind(n => Maybe(n * n)))

  println(empty.bind(x => Maybe(x)))

  println(Maybe(maybe.bind(x => Maybe(x * x)).bind(x => Maybe(x * x * x))))

  println(5 * 5 * 5 * 5 * 5 * 5)

  println(Option(Option(5).flatMap(x => Option(x * x))))

  println(empty.bind(x => Maybe(x)))

  //Unit Function that takes a value of type X and wraps in the Monadic container MayBe
  def f(x: Int) = Maybe(x) // f:: x -> Maybe(x)

  def m = Maybe

  //Right Unit Law proof
  // MonadicContainer M bind m of kind Unit => M itself
  println(Be(10).bind(f) + " equals" + " " + m(10))

  //Left Unit Law
  println(Maybe(5).bind(f) +" equals"+" "+f(5))

}