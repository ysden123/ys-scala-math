package integration

import integration.IntegralMethod.IntegralMethod

object IntegralMethod extends Enumeration {
  type IntegralMethod = Value
  val Rectangle, Trapezoidal = Value
}

/**
  * Numeric integration
  *
  * @author Yuriy Stul
  */
object Integral {

  /**
    * Computes integration by formula for trapezoidal method.
    *
    * Result is ((y1 + y2) / 2)*(x2 - x1)
    *
    * @param points input data: sequence of points(x,y)
    * @return value of integration
    */
  private def trapezoidal(points: Seq[(Double, Double)]): Double = {
    var s = 0.0
    points.indices.foreach(i=> if (i > 0) s += (points(i - 1)._2 + points(i)._2) * 0.5 * (points(i)._1 - points(i - 1)._1))
    s
  }

  private def trapezoidal(f: Double => Double, xStart: Double, xEnd: Double, n: Int): Double = {
    var s = 0.0
    val step = (xEnd - xStart) / n
    for (i <- 0 until n) {
      val x1 = xStart + step * i
      val x2 = xStart + step * (i + 1)
      s += (f(x1) + f(x2)) * step
    }
    s * 0.5
  }

  private def rectangle(f: Double => Double, xStart: Double, xEnd: Double, n: Int): Double = {
    var s = 0.0
    val step = (xEnd - xStart) / n
    for (i <- 0 until n) {
      val x1 = xStart + step * i
      val x2 = xStart + step * (i + 1)
      s += f((x1 + x2) / 2) * step
    }
    s
  }

  /**
    * Computes integration for points
    *
    * @param points input data: sequence of points(x,y)
    * @return value of integration
    */
  def s(points: Seq[(Double, Double)]): Double = {
    trapezoidal(points)
  }

  /**
    * Computes integration for function
    *
    * @param f      the function (integrand expression)
    * @param xStart start argument
    * @param xEnd   last argument
    * @param n      number of points
    * @param method a method; optional, Rectangle is default method
    * @return value of integration
    */
  def s(f: Double => Double, xStart: Double, xEnd: Double, n: Int, method: IntegralMethod = IntegralMethod.Rectangle): Double = {
    method match {
      case IntegralMethod.Rectangle => rectangle(f, xStart, xEnd, n)
      case IntegralMethod.Trapezoidal => trapezoidal(f, xStart, xEnd, n)
      case _ => throw new RuntimeException(s"Unsupported method $method")
    }
  }
}
