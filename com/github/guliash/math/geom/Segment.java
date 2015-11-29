package com.github.guliash.math.geom;

/**
 * Created by gulash on 29.11.15.
 */
public class Segment {

    Point p1, p2;

    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return p1 + " " + p2;
    }
}
