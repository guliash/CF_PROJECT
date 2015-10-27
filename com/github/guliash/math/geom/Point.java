package com.github.guliash.math.geom;

/**
 * Created by gulash on 07.06.15.
 */
public class Point {
    public double x, y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return x + " " + y;
    }

    public boolean equals(Object obj) {
        Point p = (Point)obj;
        return Math.abs(this.x - p.x) <= GeomUtils.eps && Math.abs(this.y - p.y) <= GeomUtils.eps;
    }

    public Point clone() {
        return new Point(x, y);
    }
}
