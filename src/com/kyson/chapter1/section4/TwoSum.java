package com.kyson.chapter1.section4;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TwoSum {

	public static int count(long[] a)
    {
       int N = a.length;
       int cnt = 0;
       for (int i = 0; i < N; i++)
           for(int j = i + 1; j < N; j++)
               if(a[i] + a[j] == 0)
                   cnt++;
       return cnt; 
   }

	public static void main(String[] args) {
		String filePathString = System.getProperty("user.dir");
        String intFileString = filePathString
                + "/src/com/kyson/chapter1/section4/" + "1Kints.txt";

        In in = new In(intFileString);
        long[] a = in.readAllLongs();
        Arrays.sort(a);
        StdOut.println(count(a) + "对");
	}
}
