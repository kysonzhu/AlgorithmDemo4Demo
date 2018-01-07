package com.kyson.chapter1.section4;

import java.util.Arrays;

/**
 * 1.4.22 仅用加减实现的二分查找（Mihai Patrascu）。编写一个程序，给定一个含有 N 个不同 int
 * 值的按照升序排列的数组，判断它是否含有给定的整数。只能使用加法和减法以及常数的额外内存空间。
 * 程序的运行时间在最坏情况下应该和 logN成正比。提示：用斐波那契数代替2的幂（二分法）进行查找。
 * 用两个变量保存Fk和Fk-1并在[i,i+Fk]之间查找。在每一步中，使用减法计算Fk-2，检查i+Fk-2处的
 * 元素，并根据结果将搜索范围变为[i,i+Fk-2]或是[i+Fk-2,i+Fk-2+Fk-1]。
 * <p>
 * 1.4.22 Binary search with only addition and subtraction. [Mihai Patrascu]
 * Write a program that, given an array of N distinct int values in ascending
 * order, determines whether a given integer is in the array. You may use
 * only additions and subtractions and a constant amount of extra memory. The
 * running time of your program should be proportional to log N in the worst
 * case.
 * Answer: Instead of searching based on powers of two (binary search), use
 * Fibonacci numbers (which also grow exponentially). Maintain the current
 * search range to be the interval [i, i + F k] and keep F k and F k–1 in two
 * variables. At each step compute Fk–2 via subtraction, check element i +
 * Fk–2 , and update the current range to either [i, i + Fk–2] or[i+Fk–2,
 * i+Fk–2 +Fk–1].
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
