/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.matrix

/**
  * Matrix multiplication
  *
  * @author Yuriy Stul
  */
object Multiplication {
  /**
    * Computes the product of two matrices.
    *
    * c(i)(j) = sum(a(i,r)*b(r,j))
    *
    * @param a first matrix (multiplicand)
    * @param b second matrix (multiplier)
    * @return product of two matrices
    */
  def simpleProduct(a: Array[Array[Double]], b: Array[Array[Double]]): Array[Array[Double]] = {
    require(a != null, "a must be specified")
    require(a.length != 0, "a must have at least 1 element")
    require(b != null, "b must be specified")
    require(b.length != 0, "b must have at least 1 element")
    require(a(0).length == b.length, "Number of columns in 1st matrix (a) must be equal to number of rows in second matrix (b)")

    // Initialize result matrix
    val c = Array.fill[Double](a.length, b(0).length)(0.0)

    a.indices.foreach(i => {
      b(0).indices.foreach(j => {
        a(0).indices.foreach(r => {
          c(i)(j) += a(i)(r) * b(r)(j)
        })
      })
    })
    c
  }
}
