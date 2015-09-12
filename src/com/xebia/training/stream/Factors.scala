package com.xebia.training.stream

/**
 * Created by sameerarora on 9/8/15.
 */
object Factors extends App {

  def factorsOfN(n: Int, x: Int): Boolean = x % n == 0

  val factorsOf5: (Int) => Boolean = factorsOfN(5, _) //Partially applied function

  //This evaluation constructs all numbers from 1 to 100 and uses only very little of them - BAD
  println(((1 to 100) filter factorsOf5)(2))

  //Avoid computing the tail of a sequence until it is needed to do so.

  //Using Stream class avoids this, Tail of a stream is only evaluated on demand.

  //Streams can be created as follows

  println(Stream.cons(1, Stream.cons(2, Stream.empty)))

  println((1000 to 1000000).toStream)

  println(XStream.cons(1, XStream.cons(2, XStream.cons(3, XStream.empty))))


  def take[T](count: Int, n: Int, stream: XStream[T]): Option[T] = stream match {
    case XStream.empty => None
    case _ =>
      if (count == n) Some(stream.head)
      else take(count + 1, n, stream.tail)
  }

  val takeFromBeginning = take(0, _: Int, _: XStream[Int])


  println(takeFromBeginning(2, XStream.cons(1, XStream.cons(2, XStream.cons(3, XStream.empty)))))

}

trait XStream[+T] {

  def isEmpty: Boolean

  def head: T

  def tail: XStream[T]

  override def toString: String = "XStream(" + head + ", " + tail + ")"

}


object XStream {
  // Notice the tail parameter b :=> B means b is a value of type B but it would be called *by name* i.e it will be evaluated
  //only on demand , basically not until xstream.tail method is invoked and even then only head of the tail will be evaluated.
  def cons[T](h: T, t: => XStream[T]) = new XStream[T] {

    override def isEmpty: Boolean = false

    override def tail: XStream[T] = t

    override def head: T = h
  }

  val empty = new XStream[Nothing] {

    override def isEmpty: Boolean = true

    override def tail: XStream[Nothing] = throw new NoSuchElementException("Tail")

    override def head: Nothing = throw new NoSuchElementException("Head")

    override def toString: String = "?"

  }

}
