/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.interpolation

/**
  * @author Yuriy Stul
  */
trait Interpolation {
  protected var points: Seq[(Double, Double)]

  /**
    * Computes a interpolated value
    *
    * @param x argument
    * @return the interpolated value
    */
  def get(x: Double): Double
}

object Interpolation {
  def getInterpolation(name: String, points: Seq[(Double, Double)]): Interpolation = {
    new Inter1(points)
  }
}