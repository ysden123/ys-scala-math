package com.stulsoft.scala.math.integration

import com.stulsoft.scala.math.integration.IntegralMethod.IntegralMethod

object IntegralMethod extends Enumeration {
  type IntegralMethod = Value
  val Rectangle = Value
}

/**
  * Numeric integration
  *
  * @author Yuriy Stul
  */
object Integral {

  /**
    * Computes integration by formula for rectangle method.
    *
    * Result is ((y1 + y2) / 2)*(x2 - x1)
    *
    * @param points input data: sequence of points(x,y)
    * @return value of integration
    */
  private def rectangle(points: Seq[(Double, Double)]): Double = {
    var s = 0.0
    for (i <- 1 until points.size) {
      s += (points(i - 1)._2 + points(i)._2) * 0.5 * (points(i)._1 - points(i - 1)._1)
    }
    s
  }

  /**
    * Computes integration with specified method
    *
    * @param points input data: sequence of points(x,y)
    * @param method specifies method of numeric integration
    * @return value of integration
    */
  def s(points: Seq[(Double, Double)], method: IntegralMethod = IntegralMethod.Rectangle): Double = {
    method match {
      case IntegralMethod.Rectangle => rectangle(points)
    }
  }
}
