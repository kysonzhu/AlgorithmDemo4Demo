package com.kyson.chapter1.section4;

import edu.princeton.cs.algs4.In;

public class ThreeSumFast {

    public static int count(long[] a) { // Count triples that sum to 0.
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                    if (rank(-(a[i] + a[j]),a) != -1)
                        cnt++;
        return cnt;
    }

    public static int rank(long key, long[] a) { // 数组必须是有序的
        int lo =0;
        int hi = a.length - 1;
        while (lo <= hi){ // 被查找的键要么不存在，要么必然存在于a[lo..hi]之中
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid])
                hi = mid - 1;
            else if(key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        String filePathString = System.getProperty("user.dir");
        String intFileString = filePathString
                + "/src/com/kyson/chapter1/section4/" + "5ints.txt";

        In in = new In(intFileString);
        long[] a = in.readAllLongs();
        StdOut.println(count(a));
    }
}
