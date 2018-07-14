package com.kyson.chapter1.section1;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/*
*
* 1.1.39 随机匹配。编写一个使用BinarySearch 的程序，它从命令行接受一个整型参数T，并会分别针对
* N=10^3、10^4、10^5 和10^6 将以下实验运行 T 遍：生成两个大小为N 的随机6 位正整数数组并找出
* 同时存在于两个数组中的整数的数量。打印一个表格，对于每个N，给出T 次实验中该数量的平均值。

1.1.39 Random matches. Write a BinarySearch client that takes an int value T as
command-line argument and runs T trials of the following experiment for N = 103,
104, 105, and 106: generate two arrays of N randomly generated positive six-digit
int values, and find the number of values that appear in both arrays. Print a
table giving the average value of this quantity over the T trials for each value
of N.
*
* */
public class Practise_01_01_39 {

    public static int rank(int key,int[] a){
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if (key < a[mid]){
                hi = mid - 1;
            } else if (key > a[mid]){
                lo = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }

    public static int[] ramdomArrayA(){
        int length = (int)Math.pow(10,3);
        int[] a = new int[length];
        for (int i = 0; i < Math.pow(10,3);++i){
            a[i] = StdRandom.uniform(999999);
        }
        return a;
    }

    public static int[] ramdomArrayB(){
        int length = (int)Math.pow(10,3);
        int[] a = new int[length];
        for (int i = 0; i < Math.pow(10,3);++i){
            a[i] = StdRandom.uniform(999999);
        }
        return a;
    }

    public static void main(String[] args){
        int[] a = ramdomArrayA();
        Arrays.sort(a);
        int[] b = ramdomArrayB();
        Arrays.sort(b);
        int result = 0;
        int j = 0;
        for (int i = 0 ; i < b.length; ++i){
            if (rank(b[i],a) != -1) {
                result++;
            }
        }
    }

}
