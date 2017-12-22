package com.kyson.chapter1.section4;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

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

	public int twoSumFaster(long[] a) {
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

	public int twoSumFaster2(long[] a) {
		int cnt = 0;
		int len = a.length;
		for (int j = 0; j < len; j++) {
			if (a[j]< 0 &&  rank(-a[j], a) != -1)
				cnt++;
		}
		return cnt;
	}

	public static int rank(long key, long[] a) { // 数组必须是有序的
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) { // 被查找的键要么不存在，要么必然存在于a[lo..hi]之中
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
		String filePathString = System.getProperty("user.dir");
		String intFileString = filePathString
				+ "/src/com/kyson/chapter1/section4/" + "1Kints.txt";

		In in = new In(intFileString);
		long[] a = in.readAllLongs();
		Arrays.sort(a);
		TwoSumFaster sum = new TwoSumFaster();
		StdOut.println(sum.twoSumFaster(a) + "对");

	}

}
