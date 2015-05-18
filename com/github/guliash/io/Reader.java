package com.github.guliash.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by gulash on 16.05.15.
 */
public class Reader {
    private BufferedReader in;
    private StringTokenizer st = new StringTokenizer("");
    private String delim = " ";

    public Reader(InputStream in) {
        this.in = new BufferedReader(new InputStreamReader(in));
    }

    public String next() {
        if (!st.hasMoreTokens()) {
            st = new StringTokenizer(rl());
        }
        return st.nextToken(delim);
    }

    public String rl() {
        try {
            return in.readLine();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int ni() {
        return Integer.parseInt(next());
    }

    public long nl() {
        return Long.parseLong(next());
    }

    public double nd() {
        return Double.parseDouble(next());
    }

}