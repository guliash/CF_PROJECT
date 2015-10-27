package com.github.guliash.string;

import java.util.ArrayList;

/**
 * Created by gulash on 28.05.15.
 */
public class Utils {

    public static int[] prefixFunction(String s) {
        int n = s.length();
        int[] pref = new int[n];
        int cur = 0;
        for(int i = 1; i < n; i++) {
            while(cur != 0 && s.charAt(cur) != s.charAt(i)) {
                cur = pref[cur - 1];
            }
            if(s.charAt(cur) == s.charAt(i)) {
                ++cur;
            }
            pref[i] = cur;
        }
        return pref;
    }

    public static ArrayList<Integer> kmp(String s, String p) {
        int n, m;
        n = s.length();
        m = p.length();
        int[] pref = prefixFunction(p);
        ArrayList<Integer> res = new ArrayList<>();
        int cur = 0;
        for(int i = 0; i < n; i++) {
            while(cur != 0 && s.charAt(i) != p.charAt(cur)) {
                cur = pref[cur - 1];
            }
            if(p.charAt(cur) == s.charAt(i)) {
                ++cur;
            }
            if(cur == m) {
                res.add(i - m + 1);
                cur = pref[cur - 1];
            }
        }
        return res;
    }

    public static int[] z(String p) {
        int n = p.length();
        int[] res = new int[n];
        int l, r;
        l = 0; r = 0;
        for(int i = 1; i < n; i++) {
            if(i <= r) {
                res[i] = Math.min(res[i - l], r - i + 1);
            }
            while(i + res[i] < n && p.charAt(res[i]) == p.charAt(i + res[i])) {
                ++res[i];
            }
            if(i + res[i] - 1 > r) {
                l = i; r = i + res[i] - 1;
            }
        }
        return res;
    }

}
