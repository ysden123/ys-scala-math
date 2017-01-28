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
  def simpleProduct(a: Array[Array[Double]], b: Array[Array[Double]]): Array[Array[Double]] = {
    require(a != null, "a must be specified")
    require(a.length != 0, "a must have at least 1 element")
    require(b != null, "b must be specified")
    require(b.length != 0, "b must have at least 1 element")
    require(a(0).length == b.length, "Number of columns in 1st matrix (a) must be equal to number of rows in second matrix (b)")
    val c = Array.ofDim[Double](a.length, b(0).length)

    c
  }
}
