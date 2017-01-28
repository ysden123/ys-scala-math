/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.matrix

import org.scalatest.{FlatSpec, Matchers}

/**
  * Unit tests for Transpose class
  *
  * @author Yuriy Stul
  */
class TransposeTest extends FlatSpec with Matchers {
  behavior of "Transpose"
  "transpose" should "prevent usage of incorrect arguments" in {
    assertThrows[IllegalArgumentException] {
      Transpose.transpose(null)
    }

    assertThrows[IllegalArgumentException] {
      Transpose.transpose(Array.ofDim[Double](0, 0))
    }
  }

  it should "transpose a vector" in {
    val a = Array(
      Array(1.0),
      Array(2.0),
      Array(3.0),
      Array(4.0),
      Array(5.0)
    )
    Transpose.transpose(a) should equal(Array(
      Array(1.0, 2.0, 3.0, 4.0, 5.0)
    ))
  }

  it should "transpose a square matrix" in {
    val a = Array(
      Array(1.0, 2.0),
      Array(3.0, 4.0)
    )
    Transpose.transpose(a) should equal(Array(
      Array(1.0, 3.0),
      Array(2.0, 4.0)
    ))
  }

  it should "transpose a rectangle matrix" in {
    val a = Array(
      Array(1.0, 2.0, 3.0),
      Array(4.0, 5.0, 6.0)
    )
    Transpose.transpose(a) should equal(Array(
      Array(1.0, 4.0),
      Array(2.0, 5.0),
      Array(3.0, 6.0)
    ))
  }
}
