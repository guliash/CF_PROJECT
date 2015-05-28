package com.github.guliash.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gulash on 18.05.15.
 */
public class Functions {
    public static List<Integer> finDivisors(int a) {
        int iter = 1;
        ArrayList<Integer> res = new ArrayList<>();
        for(; iter * iter < a; iter++) {
            if(a % iter == 0) {
                res.add(iter);
                res.add(a / iter);
            }
        }
        if(iter * iter == a) {
            res.add(iter);
        }
        return res;
    }

    public static int addMod(int a, int b, int mod) {
        return ((a + b) % mod + mod) % mod;
    }
}
