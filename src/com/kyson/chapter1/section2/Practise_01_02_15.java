package com.kyson.chapter1.section2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/*
*
* 1.2.15文件输入。基于String的split()方法实现In中的静态方法readInts()。我们会在1.3节中学习
* 另一个不同的实现。

1.2.15 File input. Develop a possible implementation of the static readInts()
method from In (which we use for various test clients, such as binary search on
 page 47) that is based on the split() method in String.

We will consider a different implementation in Section 1.3 (see page 126).


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
        //若要此方法有效，请先保证"/Users/kyson/"目录下有"ints.txt"文件
        int[] ints = readInts("/Users/kyson/ints.txt");
        System.out.println(Arrays.toString(ints));
    }
}
