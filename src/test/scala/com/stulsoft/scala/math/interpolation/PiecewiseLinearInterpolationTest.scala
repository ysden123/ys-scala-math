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
      PiecewiseLinearInterpolation(null)
    }
  }
}
