package com.github.guliash.io;

/**
 * Created by gulash on 18.05.15.
 */
public class Helper {

    public static void fillIntArray(Reader in, int[] a) {
        for(int i = 0; i < a.length; i++) {
            a[i] = in.ni();
        }
    }

    public static void fillLongArray(Reader in, long[] a) {
        for(int i = 0; i < a.length; i++) {
            a[i] = in.nl();
        }
    }

    public static void fillOneRowIntArrays(Reader in, int[]...arrays) {
        int n = arrays[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < arrays.length; j++) {
                arrays[j][i] = in.ni();
            }
        }
    }
}
