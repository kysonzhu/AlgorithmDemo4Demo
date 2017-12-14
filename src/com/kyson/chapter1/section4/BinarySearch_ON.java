package com.kyson.chapter1.section4;

import java.util.Arrays;

/**
 * 1.4.10 修改二分查找算法，使之总是返回和被查找的键匹配的索引最小的元素。（且仍能够保证对数级别的运行时间）
 * 
 * 1.4.10 Modify binary search so that it always returns the element with the
 * smallest index that matches the search element (and still guarantees
 * logarithmic running time).
 *
 */
public class BinarySearch_ON {

	public int rank(int key, int[] a) { // 数组必须是有序的
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) { // 被查找的键要么不存在，要么必然存在于a[lo..hi]之中
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else {
				// 先向左边查找，但要注意避免越界
				int minIndex = mid;
				while (a[minIndex] == key) {
					--minIndex;
					if (minIndex < 0) {
						break;
					}
				}
				return minIndex + 1;
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		int[] b = { 1, 2, 3, 5, 4, 5, 6, 77, 7, 8, 8, 9, 1, 11, 22, 234, 90 };
		// int[] b = {
		// 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
		// };
		Arrays.sort(b);
		BinarySearch_ON search = new BinarySearch_ON();

		int targetKey = 234;
		int index = search.rank(targetKey, b);
		System.out.println(targetKey + "在第" + index + "个");
	}

}
