package com.xebia.training.aop

/**
 * Created by sameerarora on 9/12/15.
 */
object AopExample extends App{

  trait Stuff {
    def doStuff
  }

  trait LoggingStuff extends Stuff with PerformanceMonitor{
    abstract override def doStuff: Unit = {
      println("Logging starts...")
      super.doStuff
      println("Logging ends...")
    }
  }

  trait TransactionalStuff extends Stuff {
    abstract override def doStuff = {
      println("Starting Tx")
      super.doStuff
      println("Stopping Tx")
    }
  }

  trait PerformanceMonitor extends Stuff{
    abstract override def doStuff={
      println("Starting Time monitor...")
      val startTime = System.currentTimeMillis();
      super.doStuff
      println("Time taken by method "+(System.currentTimeMillis()-startTime) +" ms")
    }
  }


  class RealStuff extends Stuff{
    override def doStuff = println("doing real stuff")
  }

  val realStuff = new RealStuff with TransactionalStuff with LoggingStuff

  realStuff.doStuff
}
