package com.github.guliash.string.utils;

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

}
