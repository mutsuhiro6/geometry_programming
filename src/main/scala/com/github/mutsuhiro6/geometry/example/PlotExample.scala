package com.github.mutsuhiro6.geometry.example

object PlotExample {

  def main(args: Array[String]): Unit = {

    import plotly._
    import element._

    val plot = Seq(
      Scatter().withFill(Fill.ToNext).withFillcolor(Color.RGBA.apply(255, 0, 0, 0.5))
    )


  }

}
