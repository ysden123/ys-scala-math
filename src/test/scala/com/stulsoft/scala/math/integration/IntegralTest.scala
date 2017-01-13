/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.integration

import org.scalatest.{FlatSpec, Matchers}

/**
  * Unit tests for methods of the Integral class
  *
  * @author Yuriy Stul
  */
class IntegralTest extends FlatSpec with Matchers {
  behavior of "Integral"

  "s" should "compute integration with trapezoidal method for points" in {
    var r = Integral.s(List((1.0, 2.0), (2.0, 3.0)))
    r should equal(2.5)

    r = Integral.s(List((1.0, 2.0), (2.0, 3.0), (3.0, 4.0)))
    r should equal(6.0)

    r = Integral.s(List((0, 0), (1, 1), (2, 2)))
    r should equal(Math.pow(2.0, 2.0) / 2.0)
  }

  it should "compute 0 for empty collection" in {
    val r = Integral.s(List())
    r should equal(0.0)
  }

  it should "compute 0 for collection with 1 item" in {
    val r = Integral.s(List((1.0, 2.0)))
    r should equal(0.0)
  }

  "s" should "compute integration with rectangle method for function" in {
    var r = Integral.s((x) => x, 0.0, 3.0, 10, IntegralMethod.Rectangle)
    Math.abs(r - 4.5) should be < 0.0001

    r = Integral.s((x) => x, 0.0, 3.0, 100, IntegralMethod.Rectangle)
    Math.abs(r - 4.5) should be < 0.0001
  }

  it should "compute integration with rectangle method for function with default method" in {
    val r = Integral.s((x) => x, 0.0, 3.0, 10)
    Math.abs(r - 4.5) should be < 0.0001
  }

  it should "compute integration with trapezoidal method" in {
    var r = Integral.s((x) => x, 0.0, 3.0, 10, IntegralMethod.Trapezoidal)
    Math.abs(r - 4.5) should be < 0.0001

    r = Integral.s((x) => x, 0.0, 3.0, 100, IntegralMethod.Trapezoidal)
    Math.abs(r - 4.5) should be < 0.0001

    r = Integral.s((x) => x, 0.0, 3.0, 100, IntegralMethod.Trapezoidal)
    Math.abs(r - 4.5) should be < 0.0001
  }

  it should "compute integration with simpson method" in {
    var r = Integral.s((x) => x, 0.0, 3.0, 10, IntegralMethod.Simpson)
    Math.abs(r - 4.5) should be < 0.0001

    r = Integral.s((x) => x, 0.0, 3.0, 100, IntegralMethod.Simpson)
    Math.abs(r - 4.5) should be < 0.0001

    r = Integral.s((x) => x, 0.0, 3.0, 100, IntegralMethod.Simpson)
    Math.abs(r - 4.5) should be < 0.0001
  }
}
