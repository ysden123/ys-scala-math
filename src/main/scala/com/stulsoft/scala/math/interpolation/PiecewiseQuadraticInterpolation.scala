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

  /**
    * Computes a interpolated value
    *
    * @param x argument
    * @return the interpolated value
    */
  override def get(x: Double): Double = {
    // Get three closest X-s
    val triad = getTriad(x)

    // Compute a0, a1, and a2
    val a2 = (
      (triad._3._2 - triad._1._2) / ((triad._3._1 - triad._1._1) * (triad._3._1 - triad._2._1))
        -
        (triad._2._2 - triad._1._2) / ((triad._2._1 - triad._1._1) * (triad._3._1 - triad._2._1))
      )
    val a1 = (
      (triad._2._2 - triad._1._2) / (triad._2._1 - triad._1._1)
        -
        (a2 * (triad._2._1 + triad._1._1))
      )

    val a0 = triad._3._2 - a1 * triad._3._1 - a2 * triad._3._1 * triad._3._1

    // Compute the value
    a0 + a1 * x + a2 * x * x
  }

  def getTriad(x: Double): ((Double, Double), (Double, Double), (Double, Double)) = {
    var firstPoint: (Double, Double) = null
    var secondPoint: (Double, Double) = null
    var thirdPoint: (Double, Double) = null

    firstPoint = points.find(p => p._1 >= x).get
    if (firstPoint == endPoint) {
      firstPoint = prePreEndPoint
      secondPoint = preEndPoint
      thirdPoint = endPoint
    } else {
      secondPoint = points.find(p => p._1 > firstPoint._1).get
      if (secondPoint == endPoint) {
        firstPoint = prePreEndPoint
        secondPoint = preEndPoint
        thirdPoint = endPoint
      } else {
        thirdPoint = points.find(p => p._1 > secondPoint._1).get
      }
    }
    (firstPoint, secondPoint, thirdPoint)
  }
}
