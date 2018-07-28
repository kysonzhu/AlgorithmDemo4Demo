package com.kyson.chapter1.section2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

/*
*
* */
public class Practise_01_02_15 {


    public static int[] readInts(String name)
    {
        In in = new In(name);
        String input = in.readAll();
        String[] words = input.split("\\s+");
        int[] ints = new int[words.length];
        for (int i = 0; i < words.length; i++)
        ints[i] = Integer.parseInt(words[i]);
        return ints;
    }


    public static void main(String[] args) {
        int[] ints = readInts("/Users/kyson/ints.txt");

    }
}
