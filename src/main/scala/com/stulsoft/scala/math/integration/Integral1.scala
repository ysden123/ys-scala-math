package com.stulsoft.scala.math.integration

/**
  * Integration with rectangle method
  *
  * @author Yuriy Stul
  */
class Integral1 {
  /**
    * Computes integration by formula for rectangle method.
    *
    * Result is ((y1 + y2) / 2)*(x2 - x1)
    *
    * @param points input data
    * @return
    */
  def s(points: Seq[(Double, Double)]): Double = {
    var s = 0.0
    for (i <- 1 until points.size) {
      s += (points(i - 1)._2 + points(i)._2) * 0.5 * (points(i)._1 - points(i - 1)._1)
    }
    s
  }
}
