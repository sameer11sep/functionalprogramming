package com.xebia.training.monad

/**
 * Created by sameerarora on 9/8/15.
 */
class Composable {

  def f(x:Int):(Int,String) = (x,"Hello")

  def g(x:Int):(Int,String) = (x,"World")

  //f(g(10))


  val o:Option[String]=Option("Sameer")

  val v:Option[(String,Int)] = Option(("Sameer",1))

  for{
    old <- o
    vv <- v
  } yield vv._1


}
