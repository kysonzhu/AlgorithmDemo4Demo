package com.kyson.chapter1.section4;

/**
 * 
 * 1.4.15 快速 3-sum。作为热身，使用一个线性级别的算法（而非基于二分查找的线性对数级别的算法）实现 TwoSumFaster
 * 来计算已排序的数组中和为 0 的整数对的数量。用相同的思想为 3-sum 问题给出一个平方级别的算法。 1.4.15 Faster 3-sum. As a
 * warmup, develop an implementation TwoSumFaster that uses a linear algorithm
 * to count the pairs that sum to zero after the array is sorted (in- stead of
 * the binary-search-based linearithmic algorithm). Then apply a similar idea to
 * develop a quadratic algorithm for the 3-sum problem. *
 */

public class TwoSumFaster {

	public int twoSumFaster(int[] a) {
		int cnt = 0;
		int len = a.length;
		for (int j = 0, k = len - 1; j < k;) {
			if (a[j] + a[k] < 0) {
				j++;
			} else if (a[j] + a[k] > 0) {
				k--;
			} else {
				j++;
				k--;
				++cnt;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {

	}

}
