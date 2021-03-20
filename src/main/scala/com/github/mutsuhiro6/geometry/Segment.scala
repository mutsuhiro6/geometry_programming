package com.github.mutsuhiro6.geometry

case class Segment(begin: Point, end: Point) extends Shape {

  def intersect(that: Segment): Boolean = {

    // 線分ABと線分CDが交差するかを判定する
    val segAB = this.end - this.begin
    val segCD = that.end - that.begin
    // 平行ならfalse
    if ((segAB cross segCD) == 0) false
    else {
      // 直線thisに対してthatの両端点がthisをまたぐか？
      val segAC = that.begin - this.begin
      val segAD = that.end - this.begin
      val s = segAB cross segAC
      val t = segAB cross segAD

      // 直線thatに対してthisの両端点がthatをまたぐか？
      val segCA = this.begin - that.begin
      val segCB = this.end - that.begin
      val u = segCD cross segCA
      val v = segCD cross segCB
      s*t <= 0 && u*v <= 0
    }
  }

  def contains(point: Point): Boolean = {
    ((end - begin) dot (point - begin)) == 1
  }

}
