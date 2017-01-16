/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.scala.math.assessment.interpolation

import com.stulsoft.scala.math.interpolation.{Interpolation, InterpolationMethod}

/**
  * Assessments for interpolation methods
  *
  * @author Yuriy Stul
  */
private object InterpolationAssessment extends App {
  lazy val step = 0.5
  // Prepare data
  lazy val sinusData = (0.001 to 10.00 by step)
    .map(x => (x, Math.sin(x)))

  lazy val quadraticData = (0.001 to 10.00 by step)
    .map(x => (x, x * x))

  private def sinusInterpolationLinear(): Unit = {
    println("==>sinusInterpolationLinear")
    val i = Interpolation.getInterpolation(InterpolationMethod.PiecewiseLinear, sinusData)

    var maxDif = 0.0
    (0.001 to 10.00 - step by 0.01).foreach(x => {
      val dif = Math.abs(i.get(x) - Math.sin(x))
      if (dif > maxDif) maxDif = dif
    })

    println(s"Max difference is $maxDif")

    println("<==sinusInterpolationLinear")
  }

  private def sinusInterpolationQuadratic(): Unit = {
    println("==>sinusInterpolationQuadratic")
    val i = Interpolation.getInterpolation(InterpolationMethod.PiecewiseQuadratic, sinusData)

    var maxDif = 0.0
    (0.001 to 10.00 - step by 0.01).foreach(x => {
      val dif = Math.abs(i.get(x) - Math.sin(x))
      if (dif > maxDif) maxDif = dif
    })

    println(s"Max difference is $maxDif")

    println("<==sinusInterpolationQuadratic")
  }

  private def quadraticInterpolationLinear(): Unit = {
    println("==>quadraticInterpolationLinear")
    val i = Interpolation.getInterpolation(InterpolationMethod.PiecewiseLinear, quadraticData)

    var maxDif = 0.0
    (0.001 to 10.00 - step by 0.01).foreach(x => {
      val dif = Math.abs(i.get(x) - x * x)
      if (dif > maxDif) maxDif = dif
    })

    println(s"Max difference is $maxDif")

    println("<==quadraticInterpolationLinear")
  }

  private def quadraticInterpolationQuadratic(): Unit = {
    println("==>quadraticInterpolationQuadratic")
    val i = Interpolation.getInterpolation(InterpolationMethod.PiecewiseQuadratic, quadraticData)

    var maxDif = 0.0
    (0.001 to 10.00 - step by 0.01).foreach(x => {
      val dif = Math.abs(i.get(x) - x * x)
      if (dif > maxDif) maxDif = dif
    })

    println(s"Max difference is $maxDif")

    println("<==quadraticInterpolationQuadratic")
  }

  println("==>main")
  sinusInterpolationLinear()
  sinusInterpolationQuadratic()

  quadraticInterpolationLinear()
  quadraticInterpolationQuadratic()
  println("<==main")

}
