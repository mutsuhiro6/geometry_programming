package com.github.mutsuhiro6.geometry

case class Point(x: Double, y: Double) extends Shape {

  def +(that: Point): Point = {
    Point(this.x + that.x, this.y + that.y)
  }

  def -(that: Point): Point = {
    Point(this.x - that.x, this.y - that.y)
  }

  def cross(that: Point): Double = {
    this.x * that.y - this.y * that.x
  }

  def dot(that: Point): Double = {
    this.x * that.x + this.y * that.y
  }
}