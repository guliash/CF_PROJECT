package com.github.guliash.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gulash on 18.05.15.
 */
public class Utils {
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

    public static long addMod(long a, long b, long mod) {
        return ((a + b) % mod + mod) % mod;
    }

    public static long binpow(long a, long pow, long mod) {
        if(pow == 0) {
            return 1;
        }
        long res = binpow(a, pow / 2, mod);
        if(pow % 2 == 0) {
            return (res * res) % mod;
        } else {
            return (((res * res) % mod) * a) % mod;
        }
    }

    public static boolean nextPermutation(int[] a) {
        int temp, mid, n;
        n = a.length;
        for(int i = n - 1; i > 0; i--) {
            if(a[i] > a[i - 1]) {
                for(int j = n - 1; j >= i; j--) {
                    if(a[j] > a[i - 1]) {
                        temp = a[i - 1];
                        a[i - 1] = a[j];
                        a[j] = temp;
                        break;
                    }
                }
                mid = i + (n - i) / 2;
                for(int j = i, z = 0; j < mid; z++, j++) {
                    temp = a[j];
                    a[j] = a[n - z - 1];
                    a[n - z - 1] = temp;
                }
                return true;
            }
        }
        return false;
    }
}
