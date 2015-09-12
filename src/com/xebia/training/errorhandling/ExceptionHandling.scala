package com.xebia.training.errorhandling

import scala.util.Try

/**
 * Created by sameerarora on 4/27/15.
 */
object TreasureAndMonster extends App {

  def eatenByMonster: Boolean = true

  def collectCoins = Try {
    if (eatenByMonster)
      throw new IllegalStateException("Eaten By Monster , game Over!!")
    List(Gold, Silver)
  }

  def buyTreasure(coins: List[Coin]) = Try {
    coins match {
      case Nil => println("Exception!!!!"); throw new IllegalArgumentException("No Tikee, No Laundry")
      case _ => println("Successfully bought treasure!!")
    }
  }

  println(collectCoins.flatMap(coins => buyTreasure(coins)))

  private val triedUnit: Try[Unit] = for {
    coins <- collectCoins
    treasure <- buyTreasure(coins)
  } yield treasure

  private[this] def multiples(multiplier: Int, list: List[Int], n: Int): List[Int] = {
    if (multiplier > n) return list
    multiples(multiplier + 1, list :+ 1 * multiplier, n)
  }

  val multiples1 = multiples(1, List[Int](), _: Int)

  def take(n: Int): Int => List[Int] = {
    multiples(1, List[Int](), _: Int)
  }


  take(100)(4)

  val coin1: Coin = new Coin("Gold", 100)

  val coin2: Coin = new Coin("Gold", 100)

  println(coin1 == coin2)
  println(coin1 eq coin1)

}


case class Coin(name: String, value: Int)

object Gold extends Coin("gold", 100)

object Silver extends Coin("silver", 10)








