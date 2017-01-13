/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.interpolation

/**
  * Y = Y0 + (X - X0)*(Y1 - Y0)/(X1 - X0)
  *
  * @author Yuriy Stul
  */
case class PiecewiseLinearInterpolation(points: Seq[(Double, Double)]) {
  require(points != null, "The points must be specified.")
  require(points.size > 1, "The points must contain at least two items.")
}
