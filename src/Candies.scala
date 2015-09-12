/**
 * Created by sameerarora on 4/30/15.
 */
object Candies extends App {

  println("Candies required : " + candies(List[Int](1, 3, 2, 4, 10,8)))

  def candies(ratings: List[Int]): Int = {
    scan(ratings) + scan(ratings.reverse) + ratings.size
  }

  def scan(list: List[Int]): Int = list.sliding(3, 2).foldLeft(0)((candies, a) => {
    a.size match {
      case 3 =>  pred(a.tail.head > a.tail.tail.head,pred(a.head > a.tail.head,candies))
      case _ => pred(a.head > a.tail.head, candies)
    }
  })

  def pred(b: Boolean, n: Int): Int = if (b) n + 1 else n
}
