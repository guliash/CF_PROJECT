package com.github.guliash.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by gulash on 07.07.15.
 */
public class TestGenerator {

    public static void main(String[] args) throws FileNotFoundException{
        String filename = "input.txt";
        PrintWriter pw = new PrintWriter(filename);
        for(int i = 0; i < 100; i++) {
            pw.println(i);
        }
        pw.close();
    }

}
