package com.kyson.chapter1.section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Date;

/*
*
* 1.1.38 二分查找与暴力查找。根据1.1.10.4 节给出的暴力查找法编写一个程序bruteForceSearch，
* 在你的计算机上比较它和BinarySearch 处理largeW.txt 和largeT.txt 所需的时间。

1.1.38 Binary search versus brute-force search. Write a program BruteForceSearch
that uses the brute-force search method given on page 48 and compare its running
time on your computer with that of BinarySearch for largeW.txt and largeT.txt.
*
*
* */
public class Practise_01_01_38 {

    public static int rank(int[] a,int key) {

        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi )/2;
            if (key < a[mid] ){
                hi = mid - 1;
            }else if(key > a[mid]) {
                lo = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 暴力查找
     * @param key
     * @param arr
     * @return  在数组arr中找到key则返回true，否则返回false
     */
    public static boolean bruteForceSearch(int key, int[] arr) {
        for(int i = 0; i < arr.length; ++i)
            if(key == arr[i])
                return true;
        return false;
    }

    public static void main(String[] args) {
        int[] whiteList = new In(args[0]).readAllInts();
        long time0 = new Date().getTime();
        int key = 0;
        // 暴力破解无需排序
        if(!StdIn.isEmpty()) {
            key = StdIn.readInt();
            boolean find = bruteForceSearch(key, whiteList);
            if(!find)
                StdOut.println(key);
        }
        long time1 = new Date().getTime();
        long elapsedTime = time1 - time0;
        StdOut.println("暴力查找用时： " + elapsedTime + " ms");

        Arrays.sort(whiteList);
        long time2 = new Date().getTime();
        rank(whiteList,key);
        long time3 = new Date().getTime();
        long elapsedTime2 = time3 - time2;
        StdOut.println("二分法查找用时： " + elapsedTime2 + " ms");
    }

}
