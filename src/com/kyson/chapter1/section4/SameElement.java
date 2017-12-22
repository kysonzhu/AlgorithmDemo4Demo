package com.kyson.chapter1.section4;

import java.util.Arrays;

/***
 * 1.4.12 编写一个程序，有序打印给定的两个有序数组（含有 N 个 int 值） 中的所有公共元素，程序在最坏情况下所需的运行时间应该和 N 成正比。
 * 
 * 1.4.12 Write a program that, given two sorted arrays of N int values, prints
 * all elements that appear in both arrays, in sorted order. The running time of
 * your program should be proportional to N in the worst case.
 *
 */
public class SameElement {

	// x和y是已经被排序过的数组
	public static void sameElements(int[] x, int[] y) {
		for (int i = 0, j = 0; i < x.length && j < y.length;) {
			if (x[i] < y[j]) {
				i++;
			}else if (x[i] > y[j]) {
				j++;
			}else {
				System.out.println(""+ x[i]);
				i++;
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int[] b1 = { 1, 2, 3, 5, 4, 5, 6, 77, 7, 8, 8, 9, 1, 11, 22, 234, 90,
				234, 345 };
		int[] b2 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		Arrays.sort(b1);
		Arrays.sort(b2);
		sameElements(b1, b2);
	}

}
