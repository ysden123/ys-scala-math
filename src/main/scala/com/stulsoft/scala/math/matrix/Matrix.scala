/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.matrix

import scala.reflect.ClassTag

/**
  * Matrix operations.
  *
  * @param m matrix
  * @author Yuriy Stul
  */
class Matrix[T: ClassTag](val m: Array[Array[T]]) {
  require(m != null, "m must be specified")
  require(m.length != 0, "m must have at least 1 element")

  override def equals(obj: scala.Any): Boolean = this.m.deep == obj.asInstanceOf[Matrix[T]].m.deep

  override def toString: String = {
    val b: StringBuilder = new StringBuilder("MatrixT[T]: ")
    m.indices.foreach(i => {
      b.append( s"""[${m(i).mkString(", ")}]""")
    })
    b.toString
  }

  /**
    * Matrix transpose
    *
    * @return transposed matrix
    */
  def transpose(): Matrix[T] = {
    val r = Array.ofDim[T](m(0).length, m.length)
    m.indices.foreach(i =>
      m(0).indices.foreach(j => r(j)(i) = m(i)(j))
    )
    new Matrix[T](r)
  }
}

/**
  * Matrix arithmetic
  *
  * @param m matrix
  */
class MatrixDouble(m: Array[Array[Double]]) extends Matrix(m: Array[Array[Double]]) {
  /**
    * Multiplication
    *
    * @param that multiplier
    * @return product of this matrix on that matrix
    */
  def *(that: MatrixDouble): MatrixDouble = {
    require(m(0).length == that.m.length, "Number of columns in 1st matrix (m) must be equal to number of rows in second matrix (that)")

    // Initialize result matrix
    val c = Array.fill[Double](m.length, that.m(0).length)(0.0)
    m.indices.foreach(i => {
      that.m(0).indices.foreach(j => {
        m(0).indices.foreach(r => {
          c(i)(j) += m(i)(r) * that.m(r)(j)
        })
      })
    })
    new MatrixDouble(c)
  }
}

object Test extends App {
  val m = new Matrix[Int](Array(
    Array(1, 2, 3),
    Array(10, 20, 30)
  ))
  println(m)

  val mDouble = new MatrixDouble(Array(
    Array(1.0, 2.0, 3.0),
    Array(10.0, 20.0, 30.0)
  ))
  println(mDouble)
}
