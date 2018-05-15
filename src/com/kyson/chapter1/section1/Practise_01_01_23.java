package com.kyson.chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
*1.1.23 为 BinarySearch 的测试用例添加一个参数:+ 打印出标准输入中不在白名单上的值; -，则打
 印出标准输入中在名单上的值。
 1.1.23 Add to the BinarySearch test client the ability to respond to a second
 argument: + to print numbers from standard input that are not in the whitelist,
 - to print numbers that are in the whitelist.
**/

public class Practise_01_01_23 {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        //这里参数symbol本来是要传进来的，这里写死，是为了Demo方便
        char symbol = '-';
        int[] whitelist = {1,2,3,4,5,6,7,11,222};
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int found = rank(key, whitelist);
            if ('+' == symbol && found == -1)
                StdOut.println(key);
            if ('-' == symbol && found != -1)
                StdOut.println(key);
        }
    }

}
