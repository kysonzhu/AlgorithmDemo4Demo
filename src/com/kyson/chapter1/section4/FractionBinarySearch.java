package com.kyson.chapter1.section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 1.4.23 分数的二分查找。设计一个算法，使用对数级别的比较次数找出有理数 p/q，其中 0<p<q<N，
 * 比较形式为给定的数是否小于
 * x?提示：两个分母均小于N的有理数之差不小于1/N2。
 * <p>
 * 1.4.23 Binary search for a fraction. Devise a method that uses a
 * logarithmic number of queries of the form Is the number less than x? to
 * find a rational number p/q such that 0 < p < q < N. Hint : Two fractions
 * with denominators less than N cannot differ by more than 1/N2.
 */
public class FractionBinarySearch {


    public static int rank(double key, double[] a) { // 数组必须是有序的
        int lo =0;
        int hi = a.length - 1;
        double threshold = 1.0 / (a.length * a.length);

        while (lo <= hi){ // 被查找的键要么不存在，要么必然存在于a[lo..hi]之中
            int mid = lo + (hi - lo) / 2;
            if(Math.abs(a[mid] - key) <= threshold)
                return mid;
            else if(key > a[mid])
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }


    public static void main(String[] args){
        double[] fractions = {1.0/2.0,2.0/3.0,3.0/4.0,4.0/5.0,5.0/6.0};
        Arrays.sort(fractions);
        int index = rank(4.0/5.0,fractions);

        System.out.print("4.0/5.0 在第" + index + "个");
    }
}
