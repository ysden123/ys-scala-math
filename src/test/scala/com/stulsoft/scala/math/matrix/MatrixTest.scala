/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.matrix

import org.scalatest.{FlatSpec, Matchers}

/**
  * Unit tests for Matrix class
  *
  * @author Yuriy Stul
  */
class MatrixTest extends FlatSpec with Matchers {
  behavior of "Matrix"
  "MatrixDouble" should "support equals operator" in {
    val a = new MatrixDouble(Array(
      Array(1.0, 2.0),
      Array(2.0, 3.0)))
    val b = new MatrixDouble(Array(
      Array(1.0, 2.0),
      Array(2.0, 3.0)))

    a.equals(b) should be(true)
  }

  it should "support toString implementation" in {
    val m = new MatrixDouble(Array(
      Array(1.0, 2.0),
      Array(2.0, 3.0)))
    m.toString shouldBe a [String]
  }

  "constructor" should "prevent usage of incorrect arguments" in {
    assertThrows[IllegalArgumentException] {
      new Matrix(null)
    }
    assertThrows[IllegalArgumentException] {
      new Matrix(Array.ofDim[Int](0, 0))
    }
    assertThrows[IllegalArgumentException] {
      new Matrix(Array.ofDim[Int](0, 1))
    }
  }

  "*" should "compute product of two square matrices" in {
    val a = new MatrixDouble(Array(
      Array(1.0, 2.0),
      Array(2.0, 3.0)))
    val b = new MatrixDouble(Array(
      Array(10.0, 20.0),
      Array(20.0, 30.0)))
    a * b should equal(b * a)
  }

  it should "prevent usage of incorrect arguments" in {
    val a = new MatrixDouble(Array(
      Array(1, 2),
      Array(2, 3)))
    assertThrows[IllegalArgumentException] {
      a * new MatrixDouble(Array.ofDim[Double](1, 0))
    }
    assertThrows[IllegalArgumentException] {
      a * new MatrixDouble(Array.ofDim[Double](1, 3))
    }
  }

  it should "compute product of two rectangle matrices" in {
    val a = new MatrixDouble(Array(
      Array(-1.0, 1.0),
      Array(2.0, 0.0),
      Array(0.0, 3.0)))
    val b = new MatrixDouble(Array(
      Array(3.0, 1.0, 2.0),
      Array(0.0, -1.0, 4.0)))

    a * b should equal(new MatrixDouble(Array(
      Array(-3.0, -2.0, 2.0),
      Array(6.0, 2.0, 4.0),
      Array(0.0, -3.0, 12.0)
    )))

    b * a should equal(new MatrixDouble(Array(
      Array(-1.0, 9.0),
      Array(-2.0, 12.0))))
  }

  it should "compute product of matrix and vector" in {
    val a = new MatrixDouble(Array(
      Array(2.0, 0.0, 4.0, -1.0),
      Array(1.0, -1.0, 1.0, 0.0)))
    val b = new MatrixDouble(Array(
      Array(2.0),
      Array(1.0),
      Array(0.0),
      Array(-2.0)))
    a * b should equal(new MatrixDouble(Array(
      Array(6.0),
      Array(1.0)
    )))
  }

  "MatrixInt" should "compute product of two square matrices" in {
    val a = new MatrixInt(Array(
      Array(1, 2),
      Array(2, 3)))
    val b = new MatrixInt(Array(
      Array(10, 20),
      Array(20, 30)))
    a * b should equal(b * a)
  }

  it should "prevent usage of incorrect arguments" in {
    val a = new MatrixInt(Array(
      Array(1, 2),
      Array(2, 3)))
    assertThrows[IllegalArgumentException] {
      a * new MatrixInt(Array.ofDim[Int](1, 0))
    }
    assertThrows[IllegalArgumentException] {
      a * new MatrixInt(Array.ofDim[Int](1, 3))
    }
  }

  "Matrix: transpose" should "transpose a vector" in {
    val m1 = new Matrix(Array(
      Array(1.0),
      Array(2.0),
      Array(3.0),
      Array(4.0),
      Array(5.0)
    ))
    m1.transpose() should equal(new Matrix(Array(
      Array(1.0, 2.0, 3.0, 4.0, 5.0)
    )))
  }

  it should "transpose a square matrix" in {
    val m1 = new Matrix(Array(
      Array(1.0, 2.0),
      Array(3.0, 4.0)
    ))
    m1.transpose() should equal(new Matrix(Array(
      Array(1.0, 3.0),
      Array(2.0, 4.0)
    )))
  }

  it should "transpose a rectangle matrix" in {
    val m1 = new Matrix(Array(
      Array(1.0, 2.0, 3.0),
      Array(4.0, 5.0, 6.0)
    ))
    m1.transpose() should equal(new Matrix(Array(
      Array(1.0, 4.0),
      Array(2.0, 5.0),
      Array(3.0, 6.0)
    )))
  }
}
