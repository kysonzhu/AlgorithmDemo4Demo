package com.kyson.chapter1.section4;

/**
 * 1.4.20 双调查找。如果一个数组中的所有元素是先递增后递减的，则称这个数组为双调的。编写一个程
 * 序，给定一个含有 N 个不同
 * int值的双调数组，判断它是否含有给定的整数。程序在最坏情况下所需的比较次数为 ~3lgN。
 * 1.4.20 Bitonic search. An array is bitonic if it is comprised of an
 * increasing sequence of integers followed immediately by a decreasing
 * sequence of integers. Write a program that, given a bitonic array of N
 * distinct int values, determines whether a given integer is in the array.
 * Your program should use ~3lg N compares in the worst case.
 */
public class BitonicSearch {

    public static int localMaximum(int[] x) {
        if (x == null || x.length == 0) {
            return -1;
        }
        if (x.length == 1 || x[0] > x[1]) {
            return 0;
        }
        if (x[x.length - 1] > x[x.length - 2]) {
            return x.length - 1;
        }

        int mid = 0;
        int left = 1;
        int right = x.length - 2;
        while (left < right) {
            mid = (left + right) / 2;
            if (x[mid - 1] < x[mid]) {
                left = mid + 1 ;
            } else if (x[mid + 1] < x[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right;
    }

    public static int bitonicSearch(int[] x, int t) throws Exception {
        if (x == null || x.length < 1) return -1;
        if (x.length < 4) {
            Exception exception = new Exception("该数组不是双调数组");
            throw exception;
        }
        //获取最大值
        int maximumIndex = localMaximum(x);

        if (x[maximumIndex] > t) {
            //往左边查找
            int left = 0;
            int right = maximumIndex;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (x[mid] < t) {
                    left = mid + 1;
                } else if (x[mid] > t) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }

            //往右边查找
            int left2 = maximumIndex;
            int right2 = x.length - 1;
            int mid2 = 0;
            while (left2 <= right2){
                mid2 = (left2 +right2) / 2;
                if (x[mid2] < t){
                    right2 = mid2 - 1;
                }else if (x[mid2] > t){
                    left2 = mid2 + 1;
                }else {
                    return mid2;
                }
            }

            return -1;

        } else if (x[maximumIndex] < t) {
            return -1;
        } else {
            return maximumIndex;
        }
    }

    public static void main(String[] args) {
        int[] bitonicArray = {1, 2, 3, 4, 5, 6, 100, 89, 9, 8, 7};

        try {
            int resultIndex = bitonicSearch(bitonicArray, 5);
            if (resultIndex == -1) {
                System.out.print("不包含给定整数");
            } else {
                System.out.print("包含给定整数,index值为"+resultIndex);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}