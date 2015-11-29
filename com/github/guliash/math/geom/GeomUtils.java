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

    public static Point sub(Point p1, Point p0) {
        return new Point(p1.x - p0.x, p1.y - p0.y);
    }

    public static double cross(Point p1, Point p2) {
        return p1.x * p2.y - p2.x * p1.y;
    }

    public static double direction(Point p1, Point p2, Point p3) {
        return cross(sub(p3, p1), sub(p2, p1));
    }

    public static boolean onSegment(Point p1, Point p2, Point p3) {
        return Math.min(p1.x, p2.x) <= p3.x && p3.x <= Math.max(p1.x, p2.x) &&
                Math.min(p1.y, p2.y) <= p3.y && p3.y <= Math.max(p1.y, p2.y);
    }

    public static boolean segmentsIntersect(Segment s1, Segment s2) {
        double d1 = direction(s2.p1, s2.p2, s1.p1);
        double d2 = direction(s2.p1, s2.p2, s1.p2);
        double d3 = direction(s1.p1, s1.p2, s2.p1);
        double d4 = direction(s1.p1, s1.p2, s2.p2);
        if(Math.abs(d1) < eps && onSegment(s2.p1, s2.p2, s1.p1)) {
            return true;
        } else if(Math.abs(d2) < eps && onSegment(s2.p1, s2.p2, s1.p2)) {
            return true;
        } else if(Math.abs(d3) < eps && onSegment(s1.p1, s1.p2, s2.p1)) {
            return true;
        } else if(Math.abs(d4) < eps && onSegment(s1.p1, s1.p2, s2.p2)) {
            return true;
        } else if((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0) || (d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0)) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean segmentsHaveSamePoint(Segment s1, Segment s2) {
        return s1.p1.equals(s2.p1) || s1.p1.equals(s2.p2) || s1.p2.equals(s2.p1) || s1.p2.equals(s2.p2);
    }

    public static Line points2Line(Point p1, Point p2) {
        if(p1.equals(p2)) {
            return null;
        }
        if(Math.abs(p1.x - p2.x) <= GeomUtils.eps) {
            return new Line(1, 0, -p1.x);
        }
        if(Math.abs(p1.y - p2.y) <= GeomUtils.eps) {
            return new Line(0, 1, -p1.y);
        }
        return new Line(p1.y - p2.y, p2.x - p1.x, p1.x * p2.y - p1.y * p2.x);
    }

}
