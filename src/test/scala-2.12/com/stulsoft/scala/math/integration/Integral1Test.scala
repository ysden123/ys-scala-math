package com.stulsoft.scala.math.integration

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Yuriy Stul
  */
class Integral1Test extends FlatSpec with Matchers {

  behavior of "Integral1Test"

  "s" should "compute integration" in {
    val i = new Integral1
    var r = i.s(List((1.0, 2.0), (2.0, 3.0)))
    r should equal(2.5)

    r = i.s(List((1.0, 2.0), (2.0, 3.0), (3.0, 4.0)))
    r should equal(6.0)

    r = i.s(List((0,0),(1,1),(2,2)))
    r should equal(Math.pow(2.0,2.0) / 2.0)
  }

  it should "compute 0 for empty collection" in {
    val i = new Integral1
    val r = i.s(List())
    r should equal(0.0)
  }

  it should "compute 0 for collection with 1 item" in {
    val i = new Integral1
    val r = i.s(List((1.0, 2.0)))
    r should equal(0.0)
  }

}
