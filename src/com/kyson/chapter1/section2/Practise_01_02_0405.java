package com.kyson.chapter1.section2;


import edu.princeton.cs.algs4.StdOut;

public class Practise_01_02_0405 {


    public static void main(String[] args){

        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);

        String a = new String();

        String s = "Hello World";
        s.toUpperCase();
        s.substring(6, 11);
        StdOut.println(s);

    }
}
