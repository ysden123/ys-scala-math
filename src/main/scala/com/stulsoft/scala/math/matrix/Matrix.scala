/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.matrix

import scala.reflect.ClassTag

/**
  * @author Yuriy Stul
  */
case class Matrix[T: ClassTag](m: Array[Array[T]]) {
  require(m != null, "m must be specified")
  require(m.length != 0, "m must have at least 1 element")


  override def equals(obj: scala.Any): Boolean = {
    this.m.deep == obj.asInstanceOf[Matrix[T]].m.deep
  }

  override def toString: String = {
    val b: StringBuilder = new StringBuilder("Matrix[T]: ")
    m.indices.foreach(i => {
      b.append( s"""[${m(i).mkString(", ")}]""")
    })
    b.toString
  }

  def *(that: Matrix[Double]): Matrix[Double] = {
    require(m(0).length == that.m.length, "Number of columns in 1st matrix (m) must be equal to number of rows in second matrix (that)")

    // Initialize result matrix
    val c = Array.fill[Double](m.length, that.m(0).length)(0.0)
    m.indices.foreach(i => {
      that.m(0).indices.foreach(j => {
        m(0).indices.foreach(r => {
          c(i)(j) += m(i)(r).asInstanceOf[Double] * that.m(r)(j)
        })
      })
    })
    Matrix(c)
  }

  def transpose(): Matrix[T] = {
    val r = Array.ofDim[T](m(0).length, m.length)
    m.indices.foreach(i =>
      m(0).indices.foreach(j => r(j)(i) = m(i)(j))
    )
    Matrix(r)
  }
}
