package com.kyson.chapter1.section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.4.2 修改TreeSum,正确处理两个较大的int值相加可能溢出的情况
 * <p>
 * 1.4.2 Modify ThreeSum2 to work properly even when the int values are so large
 * that adding two of them might cause overflow.
 */
public class ThreeSum2 {
    public static int count(long[] a) { // Count triples that sum to 0.
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        String filePathString = System.getProperty("user.dir");
        String intFileString = filePathString
                + "/src/com/kyson/chapter1/section4/" + "1Kints.txt";

        In in = new In(intFileString);
        long[] a = in.readAllLongs();
        StdOut.println(count(a));
    }
}
