/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.interpolation

/**
  * Y = Y0 + (X - X0)*(Y1 - Y0)/(X1 - X0)
  *
  * @param points sequence of points (x, y)
  * @author Yuriy Stul
  */
case class PiecewiseLinearInterpolation(points: Seq[(Double, Double)]) {
  require(points != null, "The points must be specified.")
  require(points.size > 1, "The points must contain at least two items.")

  // Validate input sequence
  points.tail
    .foldLeft(points.head._1) {
      (prev, current) => {
        if (current._1 <= prev)
          throw new IllegalArgumentException("Unsorted input sequence")
        else
          current._1
      }
    }

  /**
    * Computes a interpolated value
    *
    * @param x argument
    * @return the interpolated value
    */
  def get(x: Double): Double = {
    val startAndEndX = getBoundPoints(x)

    if (startAndEndX.isEmpty) {
      val lastPoint = points.reverse.head
      if (Math.abs(lastPoint._1 - x) < 0.000001)
        return lastPoint._2
      else
        throw new IllegalArgumentException(s"Argument $x is out of boundary [${points.head._1} - ${points.reverse.head._1}]")
    }

    (startAndEndX.get._1._2
      + (x - startAndEndX.get._1._1) * (startAndEndX.get._2._2 - startAndEndX.get._1._2)
      / (startAndEndX.get._2._1 - startAndEndX.get._1._1))
  }

  private def getBoundPoints(x: Double): Option[((Double, Double), (Double, Double))] = {
    val xStart = points.reverse
      .find(p => p._1 <= x)

    if (xStart.isDefined) {
      val xEnd = points.find(p => p._1 > x)
      if (xEnd.isDefined)
        Option(Tuple2(xStart.get, xEnd.get))
      else
        Option.empty
    } else {
      Option.empty
    }
  }
}
