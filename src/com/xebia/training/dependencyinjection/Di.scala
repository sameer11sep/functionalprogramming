package com.xebia.training.dependencyinjection

/**
 * Created by sameerarora on 9/11/15.
 */
class Service[T] {

  def create(t: T) = JDBCDao.save(t)

  def delete(t: T) = JDBCDao.delete(t)

}




object JDBCDao {

  def save[T](t: T) = print("Saving entity to RDBMS")

  def delete[T](t: T) = print("Deleting entity from RDBMS")

}

