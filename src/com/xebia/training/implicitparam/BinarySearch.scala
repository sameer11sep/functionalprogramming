package com.xebia.training.implicitparam

/**
 * Created by sameerarora on 9/8/15.
 */
case class BinarySearch[T](a: List[T]) {

  def exists(elem: T)(implicit f: (T, T) => Boolean): Boolean = {
    if (f(a(a.size / 2), elem))
      BinarySearch(a.slice(a.size / 2 + 1, a.size - 1)).exists(elem)
    else if (f(a(a.size / 2), elem))
      BinarySearch(a.slice(0, a.size / 2)).exists(elem)
    true
  }

}

object foo extends App {

  //implicit def gt(l: Int, r: Int) = l > r

  implicit def lt(l: Int, r: Int) = l > r

  println(BinarySearch(List(1, 2, 4, 8, 10, 17)).exists(5))
}