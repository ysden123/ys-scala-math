/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.interpolation

import com.stulsoft.scala.math.interpolation.InterpolationMethod.InterpolationMethod

/**
  * @author Yuriy Stul
  */
trait Interpolation {
  protected var points: Seq[(Double, Double)]

  // Validate arguments
  require(points != null, "The points must be specified.")
  require(points.size > 1, "The points must contain at least two items.")

  if (isInstanceOf[PiecewiseQuadraticInterpolation])
    require(points.size > 2, "The points must contain at least three items.")


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
  protected val startPoint: (Double, Double) = points.head
  protected val endPoint: (Double, Double) = points.reverse.head
  protected val preEndPoint: (Double, Double) = points.reverse.tail.head
  protected val prePreEndPoint: (Double, Double) = points.reverse.tail.tail.head

  /**
    * Computes a interpolated value
    *
    * @param x argument
    * @return the interpolated value
    */
  def get(x: Double): Double
}

/**
  * Specifies implemented interpolation methods
  */
object InterpolationMethod extends Enumeration {
  type InterpolationMethod = Value
  val PiecewiseLinear, PiecewiseQuadratic = Value
}

object Interpolation {
  def getInterpolation(method: InterpolationMethod, points: Seq[(Double, Double)]): Interpolation = {
    method match {
      case InterpolationMethod.PiecewiseLinear => PiecewiseLinearInterpolation(points)
      case InterpolationMethod.PiecewiseQuadratic => PiecewiseQuadraticInterpolation(points)
      case _ => throw new RuntimeException(s"Unsupported method $method")
    }
  }
}