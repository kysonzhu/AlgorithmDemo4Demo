package com.kyson.chapter1.section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
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

    public static int[] ramdomArrayA(int pow){
        int length = (int)Math.pow(10,pow);
        int[] a = new int[length];
        for (int i = 0; i < length;++i){
            a[i] = StdRandom.uniform(999999);
        }
        return a;
    }

    public static int[] ramdomArrayB(int pow){
        int length = (int)Math.pow(10,pow);
        int[] a = new int[length];
        for (int i = 0; i < length;++i){
            a[i] = StdRandom.uniform(999999);
        }
        return a;
    }

    public static int sameNum(int[] a,int[] b){
        int result = 0;
        for (int i = 0 ; i < b.length; ++i){
            if (rank(b[i],a) != -1) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println("请输入T:");
        int T = StdIn.readInt();
        System.out.println("请输入POW值:");
        int POW = StdIn.readInt();

        for (int i = 0 ; i < T ; i++){
            int[] sortedA = ramdomArrayA(POW);
            Arrays.sort(sortedA);
            int[] sortedB = ramdomArrayB(POW);
            Arrays.sort(sortedB);

            System.out.println("相同的数量为"+sameNum(sortedA,sortedB));
        }

    }


}
