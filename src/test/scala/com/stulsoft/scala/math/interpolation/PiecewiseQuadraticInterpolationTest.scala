/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.interpolation

import org.scalatest.{FlatSpec, Matchers}

/**
  * Unit tests for PiecewiseQuadraticInterpolation class
  *
  * @author Yuriy Stul
  */
class PiecewiseQuadraticInterpolationTest extends FlatSpec with Matchers {
  behavior of "PiecewiseQuadraticInterpolation"

  "constructor" should "initialize instance of the PiecewiseLinearInterpolation class" in {
    val c = Interpolation.getInterpolation(InterpolationMethod.PiecewiseQuadratic,
      Seq((1.0, 2.0), (2.0, 4.0), (3.0, 9.0)))
    c shouldBe an[PiecewiseQuadraticInterpolation]
  }

  it should "prevent usage of list of points with number of items less than 3" in {
    assertThrows[IllegalArgumentException] {
      Interpolation.getInterpolation(InterpolationMethod.PiecewiseQuadratic,
        Seq((2, 1), (3, 2)))
    }
  }

  "get" should "compute value" in {
    val c = Interpolation.getInterpolation(InterpolationMethod.PiecewiseQuadratic,
      Seq((1.0, 1.0), (2.0, 2.0), (3.0, 3.0)))
    c.get(1.0) should be(1.0)
    c.get(1.5) should be(1.5)
    c.get(2.0) should be(2.0)
    c.get(2.9) should be(2.9)
    c.get(3.0) should be(3.0)
  }

}
