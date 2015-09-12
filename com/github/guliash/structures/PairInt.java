package com.github.guliash.structures;

/**
 * Created by gulash on 11.07.15.
 */
public class PairInt {
    public int x, y;
    public PairInt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return x + " " + y;
    }

    public PairInt clone() {
        return new PairInt(x, y);
    }
}
