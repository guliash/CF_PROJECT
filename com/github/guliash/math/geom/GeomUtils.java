package com.github.guliash.math.geom;

/**
 * Created by gulash on 07.06.15.
 */
public class GeomUtils {

    public static final double eps = 1e-14;

    public static double dist(Point p1, Point p2) {
        return Math.sqrt(dist2(p1, p2));
    }

    public static double dist2(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    public static Line points2Line(Point p1, Point p2) {
        if(p1.equals(p2)) {
            return null;
        }
        if(Math.abs(p1.x - p2.x) <= eps) {
            return new Line(1, 0, -p1.x);
        }
        if(Math.abs(p1.y - p2.y) <= eps) {
            return new Line(0, 1, -p1.y);
        }
        return new Line(p1.y - p2.y, p2.x - p1.x, p1.x * p2.y - p1.y * p2.x);

    }

}
