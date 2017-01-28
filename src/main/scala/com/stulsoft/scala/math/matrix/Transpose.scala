/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.matrix

/**
  * Transpose a matrix
  *
  * @author Yuriy Stul
  */
object Transpose {
  def transpose(a: Array[Array[Double]]): Array[Array[Double]] = {
    require(a != null, "a must be specified")
    require(a.length != 0, "a must have at least 1 element")
    val c = Array.ofDim[Double](a(0).length, a.length)
    a.indices.foreach(i =>
      a(0).indices.foreach(j => c(j)(i) = a(i)(j))
    )
    c
  }
}
