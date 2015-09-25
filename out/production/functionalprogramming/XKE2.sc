import scala.annotation.tailrec

val list: List[Int] = List(1, 2, 3, 3, 3, 6)

list.head

list.tail

def filter(list: List[Int], resultant: List[Int]): List[Int] = list match {
  case Nil => resultant
  case x :: xs => {
    if (x % 2 == 0)
      filter(xs, (resultant :+ x))
    else
      filter(xs, resultant)
  }
}

filter(list, List())

val filter1 = filter(_: List[Int], List())

filter1(list)


def double(list: List[Int], resultant: List[Int]): List[Int] = list match {
  case Nil => resultant
  case x :: xs => {
    double(xs, (resultant :+ x * 2))
  }
}

def map(list: List[Int], resultant: List[Int], p: Int => Int): List[Int] = list match {
  case Nil => resultant
  case x :: xs => {
    map(xs, (resultant :+ p(x)), p)
  }
}


map(list, List(), (x: Int) => x - 1)

double(list, List())

val specificMap = map(_: List[Int], List(), (x: Int) => x - 1)

specificMap(list)

@tailrec
def factorial(n: Int): Int = {
  if (n == 1) 1
  else factorial(n - 1) * n
}

@tailrec
def factorial(acc: Int, n: Int): Int = {
  if (n == 1) acc
  else factorial(acc * n, n - 1)
}
val fact = factorial(1, _: Int)
fact(5)

//Partial Function
//A partial function is a function that is valid
// for only a subset of values of those types you might pass in to it

def fun: PartialFunction[Int, Int] = {
  case 1 => 30
  case 2 => 40
}
val partial: PartialFunction[Int, Int] = fun

partial.isDefinedAt(2)
//This partial function is not defined for 5
partial.isDefinedAt(5)
partial(2)
//Partially Applied Function
def add(i: Int, j: Int) = i + j

val add2 = add(_: Int, 5)
add2(10)
//(A,B) => C into A => B => C

val addTupled = (add _).tupled
List((1, 2), (4, 5), (3, 8)).map(addTupled)
val addCurried = (add _).curried
val functions: List[(Int) => Int] = List(1, 4, 3).map(addCurried)
// 1st element list.map(_ => addCurried(_)) => addCurried(1) => add(_,1) => add(_,1)(5) => add(1,5)

functions.head(5)
// 2nd Element list.map(_ => addCurried(_)) => addCurried(4) => add(_,4) => add(_,4)(5) => add(4,5)
functions.tail.head(5)
// 3rd Element list.map(_ => addCurried(_)) => addCurried(3) => add(_,3) => add(_,3)(5) => add(3,5)
functions.tail.tail.head(5)

//Applying functions Partially

def multiply(x: Int, y: Int) = x * y
//this becomes a curried function

val multiply4 = multiply(_: Int, 4)
multiply4(5)
val fact1 = factorial(1, _: Int)
fact1(5)