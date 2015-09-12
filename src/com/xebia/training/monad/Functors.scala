package com.xebia.training.monad

/**
 * Created by sameerarora on 9/10/15.
 */
object Functors extends App {

  def toXml(head: Contact): Node = Node("contact", Option(List[Node](Node("name", None, Option(head.name)), Node("email", None, Option(head.email)))))

  def toJson(head: Contact): Json = Json("contact", Map[String, String]("name" -> head.name, "email" -> head.email))

  def listToXml(contacts: List[Contact]): List[Node] = contacts match {
    case Nil => Nil
    case head :: tail => toXml(head) :: listToXml(tail)

  }

  def listToJson(contacts: List[Contact]): List[Json] = contacts match {
    case Nil => Nil
    case head :: tail => toJson(head) :: listToJson(tail)
  }


  //removes duplication of code by abstracting out json and xml conversion to higher order function
  //passed as an argument
  def listMap[A, B](f: A => B)(list: List[A]): List[B] = list match {
    case Nil => Nil
    case head :: tail => f(head) :: listMap(f)(tail)
  }

  // Partially Applied functions
  val listToXml_ = listMap(toXml) _

  val listToJson_ = listMap(toJson) _

  def optionMap[A, B](f: A => B)(o: Option[A]): Option[B] = o match {
    case None => None
    case Some(x) => Some(f(x))
  }

  val optionToXml = optionMap(toXml) _

  val optionToJson = optionMap(toJson) _

  //Signature of the above map methods look like
  // (A => B) => List[A] => List[B]
  //(A => B) => Option[A] => Option[B] i.e a function from A to B returns a function that transforms List[A] to List[B]

  //can we generalize above to write a function toJsonF that applies to the context i.e List or Option
  // (A => B) => F[A] => F[B]

  trait Functor[F[_]] {
    def fmap[A, B](f: A => B): F[A] => F[B]
  }

  implicit val listFunctor = new Functor[List] {
    override def fmap[A, B](f: (A) => B): (List[A]) => List[B] = {
      case Nil => Nil
      case head :: tail => f(head) :: fmap(f)(tail)
    }
  }

  implicit val optionFunctor = new Functor[Option] {
    override def fmap[A, B](f: (A) => B): (Option[A]) => Option[B] = {
      case None => None
      case Some(x) => Some(f(x))
    }
  }

  val noneFunctor = new Functor[Option] {
    override def fmap[A, B](f: (A) => B): (Option[A]) => Option[B] = {
      case None => None
      case Some(x) => None
    }
  }

  def toJsonF[F[_]](fc: F[Contact])(implicit functor: Functor[F]): F[Json] =
    functor.fmap(toJson)(fc)

  def toXmlF[F[_]](functor: Functor[F]): F[Contact] => F[Node] = functor.fmap(toXml)


  private val JOHN: Contact = Contact("John", "41")

  println(toJsonF(List[Contact](JOHN)))

  println(toJsonF(Option(JOHN)))

  println(toXmlF(listFunctor)(List[Contact](JOHN)))


  //Identity function

  // def identity[F[_], A](functor: Functor[A], a: F[A]): F[A] = functor.fmap((a: A) => a)(a)

  def identity[F[_], A](fa: F[A], functor: Functor[F]): F[A] =
    functor.fmap((a: A) => a)(fa)

  assert(Option[Contact](JOHN) == identity(Option[Contact](JOHN),optionFunctor))

  //left unit law is broken here because of the identity function
  assert(Option[Contact](JOHN) == identity(Option[Contact](JOHN),noneFunctor))
}


case class Json(name: String, map: Map[String, String])

case class Node(name: String, children: Option[List[Node]], value: Option[String] = None)

case class Contact(name: String, email: String)


