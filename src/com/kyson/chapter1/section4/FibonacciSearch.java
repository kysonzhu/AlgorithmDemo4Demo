package com.kyson.chapter1.section4;

import java.util.Arrays;

/**
 *
 */
public class FibonacciSearch {

    private final int FI_SIZE = 20;

    public int fbSearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        } else {
            int length = array.length;
            // 制造一个长度为10的斐波数列
            int[] fb = makeFbArray(FI_SIZE);
            int k = 0;
            // 找出数组的长度在斐波数列（减1）中的位置，将决定如何拆分
            while (length > fb[k] - 1) {
                k++;
            }
            // 构造一个长度为fb[k] - 1的新数列
            int[] temp = Arrays.copyOf(array, fb[k] - 1);
            for (int i = length; i < temp.length; i++) {
                if (i >= length) {
                    temp[i] = array[length - 1];
                }
            }
            int low = 0;
            int high = array.length - 1;
            while (low <= high) {
                int middle = low + fb[k - 1] - 1;
                if (temp[middle] > target) {
                    high = middle - 1;
                    k = k - 1;
                } else if (temp[middle] < target) {
                    low = middle + 1;
                    k = k - 2;
                } else {
                    if (middle <= high) {
                        // 若相等则说明mid即为查找到的位置
                        return middle;
                    } else {
                        // middle的值已经大于hight,进入扩展数组的填充部分,
                        //即最后一个数就是要查找的数。
                        return high;
                    }
                }
            }
            return -1;
        }
    }


    public static int[] makeFbArray(int length) {
        int[] array = null;
        if (length > 2) {
            array = new int[length];
            array[0] = 1;
            array[1] = 1;
            for (int i = 2; i < length; i++) {
                array[i] = array[i - 1] + array[i - 2];
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 15, 22, 25, 31, 39, 42, 47, 49, 59, 68, 88, 88,
                88, 88, 88};
        FibonacciSearch search = new FibonacciSearch();
        System.out.println("result: " + search.fbSearch(array, 31));
    }
}
