package com.github.guliash.string.utils;

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

}
