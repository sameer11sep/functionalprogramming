import scala.concurrent
import scala.concurrent.Future


val ns = (1 to 10).toList
val attempts = ns.map(_ => () => Future)
val failed: Future[Nothing] = Future.failed(new scala.RuntimeException("Boom!!"))
attempts.foldLeft(failed)((a,block) => a recoverWith(block()))
