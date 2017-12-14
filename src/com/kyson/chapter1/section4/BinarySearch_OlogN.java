package com.kyson.chapter1.section4;

import java.util.Arrays;

public class BinarySearch_OlogN {

	public int rank(int[] a, int key) {
		int hi = a.length;
		int lo = 0;
		int mid = 0;
		while(lo < hi){
			mid = (hi + lo) / 2;
			if (a[mid] < key) {
	            lo = mid + 1;
			}else if (a[mid] > key) {
	            hi = mid;
			}else if (mid > 0 && a[mid-1] == key) {
	            hi = mid;
			}else {
				return mid;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int[] b = { 1, 2, 3, 5, 4, 5, 6, 77, 7, 8, 8, 9, 1, 11, 22, 234, 90,234,345 };
//		int[] b = { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1 };
		Arrays.sort(b);
		BinarySearch_OlogN search = new BinarySearch_OlogN();
		
		int targetKey = 345;
		int index = search.rank(b,targetKey);
		System.out.println(targetKey + "在第"+index+"个");
	}

}
