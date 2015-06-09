package com.github.guliash.math.geom;

/**
 * Created by gulash on 07.06.15.
 */
public class Line {

    public double a, b, c;
    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String toString() {
        return this.a + " " + this.b + " " + this.c;
    }


}
