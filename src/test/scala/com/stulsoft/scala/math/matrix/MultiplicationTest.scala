/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.matrix

import org.scalatest.{FlatSpec, Matchers}

/**
  * Unit tests for Multiplication class
  *
  * @author Yuriy Stul
  */
class MultiplicationTest extends FlatSpec with Matchers {
  behavior of "Multiplication"

  "simpleProduct" should "prevent usage of incorrect arguments" in {
    assertThrows[IllegalArgumentException] {
      Multiplication.simpleProduct(null, Array.ofDim[Double](3, 3))
    }
    assertThrows[IllegalArgumentException] {
      Multiplication.simpleProduct(Array.ofDim[Double](3, 3), null)
    }
    assertThrows[IllegalArgumentException] {
      Multiplication.simpleProduct(Array.ofDim[Double](0, 0), Array.ofDim[Double](3, 3))
    }
    assertThrows[IllegalArgumentException] {
      Multiplication.simpleProduct(Array.ofDim[Double](7, 8), Array.ofDim[Double](0, 0))
    }
    assertThrows[IllegalArgumentException] {
      Multiplication.simpleProduct(Array.ofDim[Double](7, 8), Array.ofDim[Double](11, 12))
    }

    Multiplication.simpleProduct(Array.ofDim[Double](7, 8), Array.ofDim[Double](8, 7))
  }
}
