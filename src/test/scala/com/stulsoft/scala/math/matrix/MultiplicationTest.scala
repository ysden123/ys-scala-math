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

  it should "compute product of two square matrices" in {
    val a = Array(Array(1.0, 2.0),
      Array(2.0, 3.0))
    val b = Array(Array(10.0, 20.0),
      Array(20.0, 30.0))
    Multiplication.simpleProduct(a, b) should equal(Multiplication.simpleProduct(b, a))
  }

  it should "compute product of two rectangle matrices" in {
    val a = Array(Array(-1.0, 1.0),
      Array(2.0, 0.0),
      Array(0.0, 3.0))
    val b = Array(Array(3.0, 1.0, 2.0),
      Array(0.0, -1.0, 4.0))

    //    displayMatrix(Multiplication.simpleProduct(a, b))
    //    displayMatrix(Multiplication.simpleProduct(b, a))
    Multiplication.simpleProduct(a, b) should equal(Array(
      Array(-3.0, -2.0, 2.0),
      Array(6.0, 2.0, 4.0),
      Array(0.0, -3.0, 12.0)
    ))
    Multiplication.simpleProduct(b, a) should equal(Array(
      Array(-1.0, 9.0),
      Array(-2.0, 12.0)))
  }

  it should "compute product of matrix and vector" in {
    val a = Array(
      Array(2.0, 0.0, 4.0, -1.0),
      Array(1.0, -1.0, 1.0, 0.0))
    val b = Array(
      Array(2.0),
      Array(1.0),
      Array(0.0),
      Array(-2.0))
    Multiplication.simpleProduct(a, b) should equal(Array(
      Array(6.0),
      Array(1.0)
    ))
  }

  def displayMatrix(a: Array[Array[Double]]): Unit = {
    a.indices.foreach(i => {
      println(s"""[${a(i).mkString(", ")}]""")
    })
  }
}
