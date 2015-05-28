package com.github.guliash.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gulash on 18.05.15.
 */
public class Functions {
    public static ArrayList<Integer> finDivisors(int a) {
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

    public static ArrayList<Integer> factorize(int a) {
        int cur = a;
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 2; i * i <= a; i++) {
            while(cur % i == 0) {
                primes.add(i);
                cur /= i;
            }
        }
        return primes;
    }

    public static int addMod(int a, int b, int mod) {
        return ((a + b) % mod + mod) % mod;
    }
}
