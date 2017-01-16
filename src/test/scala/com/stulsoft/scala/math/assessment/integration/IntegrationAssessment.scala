/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.assessment.integration

import com.stulsoft.scala.math.integration.{Integration,IntegrationMethod}

/**
  * Assessments for interpolation methods
  *
  * @author Yuriy Stul
  */
private object IntegrationAssessment extends App {
  private def sinRectangleFunction(): Unit = {
    println("==>sinRectangleFunction")
    val computedValue = Integration.s(Math.sin, 0.0, Math.PI, 40, IntegrationMethod.Rectangle)
    val dif = Math.abs(computedValue - 2.0)
    println(s"Difference is $dif")
    println("<==sinRectangleFunction")
  }

  private def sinTrapezoidalFunction(): Unit = {
    println("==>sinTrapezoidalFunction")
    val computedValue = Integration.s(Math.sin, 0.0, Math.PI, 40, IntegrationMethod.Trapezoidal)
    val dif = Math.abs(computedValue - 2.0)
    println(s"Difference is $dif")
    println("<==sinTrapezoidalFunction")
  }

  private def sinSimpsonFunction(): Unit = {
    println("==>sinSimpsonFunction")
    val computedValue = Integration.s(Math.sin, 0.0, Math.PI, 40, IntegrationMethod.Simpson)
    val dif = Math.abs(computedValue - 2.0)
    println(s"Difference is $dif")
    println("<==sinSimpsonFunction")
  }

  println("==>main")
  sinRectangleFunction()
  sinTrapezoidalFunction()
  sinSimpsonFunction()
  println("<==main")
}
