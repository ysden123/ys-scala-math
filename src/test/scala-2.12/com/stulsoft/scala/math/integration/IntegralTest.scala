package com.stulsoft.scala.math.integration

import org.scalatest.{FlatSpec, Matchers}

/**
  * Unit tests for methods of the Integral class
  *
  * @author Yuriy Stul
  */
class IntegralTest extends FlatSpec with Matchers {

  behavior of "IntegralTest"

  "s" should "compute integration with rectangle method by default" in {
    var r = Integral.s(List((1.0, 2.0), (2.0, 3.0)), IntegralMethod.Rectangle)
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
}
