package com.xebia.training.generics

/**
 * Created by sameerarora on 9/9/15.
 */
object Variance extends App {

  /*def isLargeEnough(a: Arena[Mammal]): Boolean = {
    true
  }

  isLargeEnough(new Arena[Zebra] {
    //retrieves the animal that lives in that Arena
    override def get: Zebra = new Zebra
  })

  def treatMammals(vet: Vet[Mammal])={
    println("")
  }

  treatMammals(new Vet[Animal] {
    override def treat(a: Animal): Unit = {}
  })*/


}

abstract class Arena[A] {
  //retrieves the animal that lives in that Arena
  def get: A
}

abstract class Vet[A] {
  def treat(a: A)
}


abstract class Animal

abstract class Mammal extends Animal

abstract class Amphibian extends Animal

class Zebra extends Mammal

class Crocodile extends Amphibian