import scala.concurrent.Future

/**
 * Created by sameerarora on 4/30/15.
 */
object Futures extends App {

  def retry[T](n: Int)(block: => Future[T]): Future[T] = {
    if (n == 0) Future.failed(new RuntimeException("Boom!!"))
    else block fallbackTo{
      retry(n-1)(block)
    }
  }


  def retryfp[T](n: Int)(block: => Future[T]): Future[T] = {
    val ns = (1 to n).toList
    val attempts = ns.map(_ => () => block)
    val failed: Future[Nothing] = Future.failed(new scala.RuntimeException("Boom!!"))
    //attempts.foldLeft(failed)((a,block) => a recoverWith(block))
    failed
  }




}
