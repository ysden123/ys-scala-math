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
class IntegrationTest extends FlatSpec with Matchers {
  behavior of "Integration"

  "constructor" should "prevent usage of unsupported interpolation method" in {
    assertThrows[RuntimeException] {
      Integration.s((x) => x, 0.0, 3.0, 10, null)
    }
  }

  "s" should "compute integration with trapezoidal method for points" in {
    var r = Integration.s(List((1.0, 2.0), (2.0, 3.0)))
    r should equal(2.5)

    r = Integration.s(List((1.0, 2.0), (2.0, 3.0), (3.0, 4.0)))
    r should equal(6.0)

    r = Integration.s(List((0, 0), (1, 1), (2, 2)))
    r should equal(Math.pow(2.0, 2.0) / 2.0)
  }

  it should "compute 0 for empty collection" in {
    val r = Integration.s(List())
    r should equal(0.0)
  }

  it should "compute 0 for collection with 1 item" in {
    val r = Integration.s(List((1.0, 2.0)))
    r should equal(0.0)
  }

  "s" should "compute integration with rectangle method for function" in {
    var r = Integration.s((x) => x, 0.0, 3.0, 10, IntegrationMethod.Rectangle)
    Math.abs(r - 4.5) should be < 0.0001

    r = Integration.s((x) => x, 0.0, 3.0, 100, IntegrationMethod.Rectangle)
    Math.abs(r - 4.5) should be < 0.0001
  }

  it should "compute integration with rectangle method for function with default method" in {
    val r = Integration.s((x) => x, 0.0, 3.0, 10)
    Math.abs(r - 4.5) should be < 0.0001
  }

  it should "compute integration with trapezoidal method" in {
    var r = Integration.s((x) => x, 0.0, 3.0, 10, IntegrationMethod.Trapezoidal)
    Math.abs(r - 4.5) should be < 0.0001

    r = Integration.s((x) => x, 0.0, 3.0, 100, IntegrationMethod.Trapezoidal)
    Math.abs(r - 4.5) should be < 0.0001

    r = Integration.s((x) => x, 0.0, 3.0, 100, IntegrationMethod.Trapezoidal)
    Math.abs(r - 4.5) should be < 0.0001
  }

  it should "compute integration with simpson method" in {
    var r = Integration.s((x) => x, 0.0, 3.0, 10, IntegrationMethod.Simpson)
    Math.abs(r - 4.5) should be < 0.0001

    r = Integration.s((x) => x, 0.0, 3.0, 100, IntegrationMethod.Simpson)
    Math.abs(r - 4.5) should be < 0.0001

    r = Integration.s((x) => x, 0.0, 3.0, 100, IntegrationMethod.Simpson)
    Math.abs(r - 4.5) should be < 0.0001
  }
}
