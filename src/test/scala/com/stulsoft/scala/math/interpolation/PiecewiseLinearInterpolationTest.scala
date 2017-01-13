/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.interpolation

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Yuriy Stul
  */
class PiecewiseLinearInterpolationTest extends FlatSpec with Matchers {
  behavior of "PiecewiseLinearInterpolation"

  "constructor" should "initialize instance of the PiecewiseLinearInterpolation class" in {
    val c = PiecewiseLinearInterpolation(Seq((1.0, 2.0), (2.0, 4.0), (3.0, 9.0)))
    c.points.toString should be("List((1.0,2.0), (2.0,4.0), (3.0,9.0))")
  }

  it should "prevent usage of undefined points" in {
    assertThrows[IllegalArgumentException] {
      PiecewiseLinearInterpolation(null)
    }
  }

  it should "prevent usage of list of points with number of items less than 2" in {
    assertThrows[IllegalArgumentException] {
      PiecewiseLinearInterpolation(Seq((2, 1)))
    }
  }

  it should "prevent usage of unsorted sequence" in {
    assertThrows[IllegalArgumentException] {
      PiecewiseLinearInterpolation(Seq((2, 1), (1, 2), (3, 4)))
    }
  }

  "get" should "compute value" in {
    val c = PiecewiseLinearInterpolation(Seq((1.0, 1.0), (2.0, 2.0), (3.0, 3.0)))
    c.get(1.0) should be(1.0)
    c.get(1.5) should be(1.5)
    c.get(2.0) should be(2.0)
    c.get(2.9) should be(2.9)
    c.get(3.0) should be(3.0)
  }

  it should "throw exception for x outside boundary" in {
    val c = PiecewiseLinearInterpolation(Seq((1.0, 1.0), (2.0, 2.0), (3.0, 3.0)))
    assertThrows[IllegalArgumentException] {
      c.get(0.5)
    }
    assertThrows[IllegalArgumentException] {
      c.get(3.001)
    }
  }
}
