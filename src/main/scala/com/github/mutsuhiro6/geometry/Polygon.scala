package com.github.mutsuhiro6.geometry

case class Polygon(points: Seq[Point]) extends Shape {

  private lazy val xs = points.map(_.x)
  private lazy val ys = points.map(_.y)
  private lazy val (xMin, xMax, yMin, yMax) = (xs.min, xs.max, ys.min, ys.max)

  private lazy val centroid = {
    val len = points.length.toDouble
    val x = xs.sum / len
    val y = ys.sum / len
    Point(x, y)
  }

  private lazy val poly = points.sortBy { pt =>
    math.atan2(pt.y - centroid.y, pt.x - centroid.x)
  }

  private lazy val segments = (poly :+ poly(0)).sliding(2)
    .map { slide =>
      val begin = slide.head
      val end = slide.last
      Segment(begin, end)
    }
    .toArray

  def contains(point: Point): Boolean = {
    val x = point.x
    val y = point.y
    if (x <= xMin || x >= xMax || y <= yMin || y >= yMax) return false
    // pointからx軸に平行な（擬似）半直線を考える。
    val halfLine = Segment(point, Point(xMax, y))
    var flag = false
    // Crossing Number Algorithm
    for (seg <- segments) {
      if (seg.end.y == y) {
        // continue
      }
      else if (halfLine intersect seg) {
        println("intersect")
        flag = !flag
      }
    }
    flag
  }
}