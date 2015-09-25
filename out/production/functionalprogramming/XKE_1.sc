//Higher Order Functions are functions that accepts function as an argument
//x*x + 5x - 7 Lets represent this as a scala expression

def expr(x: Int, p: Int => Int,q: => Int) = {
  (x * x) + p(x) - q
}

def p(x:Int) = 5*x

def q:Int = 7

expr(5, (x:Int) => 5*x , 5)

expr(5,p,q)

//Recursive Functions

def successor(x: Int) = x + 1

def predecessor(x: Int) = x - 1

def addRec(x: Int, y: Int): Int = {
  if (y == 0) x
  else addRec(successor(x), predecessor(y))
}

addRec(5, 6)

def factorial(n: Int): Int = {
  if (n == 1) 1
  else factorial(n - 1) * n
}

def factorial(acc:Int,n:Int):Int={
  if(n==1) acc
  else factorial(acc*n, n-1)
}




factorial(5)

factorial(1,5)



//Partial Function
//A partial function is a function that is valid
// for only a subset of values of those types you might pass in to it
val partial:PartialFunction[Int,Int] = {
  case 1 => 30
  case 2 => 40
}

partial.isDefinedAt(2)
//This partial function is not defined for 5
partial.isDefinedAt(5)
//Partially Applied Function
def add(i: Int, j: Int) = i + j
val add2= add(_:Int,5)
add2(10)
//(A,B) => C into A => B => C


val addTupled = (add _).tupled
List((1,2), (4,5), (3,8)).map(addTupled)
val addCurried = (add _).curried

val functions: List[(Int) => Int] = List(1,4,3).map(addCurried)
// 1st element list.map(_ => addCurried(_)) => addCurried(1) => add(_,1) => add(_,1)(5) => add(1,5)

functions.head(5)

// 2nd Element list.map(_ => addCurried(_)) => addCurried(4) => add(_,4) => add(_,4)(5) => add(4,5)
functions.tail.head(5)

// 3rd Element list.map(_ => addCurried(_)) => addCurried(3) => add(_,3) => add(_,3)(5) => add(3,5)
functions.tail.tail.head(5)


//Applying functions Partially

def multiply(x:Int,y:Int) = x*y

//this becomes a curried function

val multiply4 = multiply(_:Int,4)

multiply4(5)

val fact1 = factorial(1,_:Int)

fact1(5)