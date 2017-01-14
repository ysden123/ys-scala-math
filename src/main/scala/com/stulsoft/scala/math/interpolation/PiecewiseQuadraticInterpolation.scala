/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.interpolation

/**
  * Y = a0 + a1*x + a2 * x&#94;2
  *
  * @param points sequence of points (x, y)
  * @author Yuriy Stul
  */
protected case class PiecewiseQuadraticInterpolation(var points: Seq[(Double, Double)]) extends Interpolation {
  require(points.size > 2, "The points must contain at least three items.")

  /**
    * Computes a interpolated value
    *
    * @param x argument
    * @return the interpolated value
    */
  override def get(x: Double): Double = {
    0.0
  }
}
