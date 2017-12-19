package com.kyson.chapter1.section4;

/****
 * 1.4.14 4-sum。为 4-sum 设计一个算法。
 * 1.4.14 4-sum. Develop an algorithm for the 4-sum problem.
 */
public class FourSum {

	public int fourSum(int[] a) {
		int len = a.length;
		int cnt = 0;
		for (int l = 0; l < len - 3; l++) {
			for (int i = l + 1; i < len - 2; i++) {
				for (int j = i + 1, k = len - 1; j < k;) {
					if (a[l] + a[i] + a[j] + a[k] < 0) {
						j++;
					} else if (a[l] + a[i] + a[j] + a[k] > 0) {
						k--;
					} else {
						cnt++;
						j++;
						k--;
					}
				}
			}
		}
		return cnt;
	}
}
