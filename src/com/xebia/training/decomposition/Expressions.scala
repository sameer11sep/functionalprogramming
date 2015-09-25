package com.xebia.training.decomposition

/**
 * Created by sameerarora on 9/5/15.
 */
object Expressions extends App {

  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(l: Expr, r: Expr) extends Expr

  case class Prod(left: Expr, right: Expr) extends Expr

  case class Div(left: Expr, right: Expr) extends Expr

  case class Subtract(value: Expr, value1: Expr) extends Expr


  def eval(expr: Expr): Int = {
    expr match {
      case Number(n) => n
      case Sum(left, right) => eval(left) + eval(right)
      case Prod(left, right) => eval(left) * eval(right)
      case Div(left, right) => eval(left) / eval(right)
      case Subtract(left,right) => eval(left) - eval(right)
    }
  }


  def show(expr: Expr): String = {
    expr match {
      case Number(n) => n + ""
      case _ => parenthesize(expr)
    }

  }

  def parenthesize(e: Expr): String = {
    val s: String = e match {
      case Sum(left, right) => show(left) + " + " + show(right)
      case Prod(left, right) => show(left) + " * " + show(right)
      case Div(left, right) => show(left) + " / " + show(right)
    }
    "(" + s + ")"
  }

  println(eval(Sum(Number(5), Number(6))))
  println(show(Div(Prod(Sum(Number(5), Number(7)), Number(6)), Number(8))))

  println(eval(Div(Prod(Sum(Number(5), Number(7)), Number(6)), Number(8))))

}



