package com.kyson.chapter1.section4;

/***
 * 
 * 1.4.18 数组的局部最小元素。编写一个程序，给定一个含有 N 个不同整数的数组，找到一个局部最小元素：满足 a[i] < a[i-1]，且 a[i]
 * < a[i+1] 的索引 i。程序在最坏情况下所需的比较次数为 ~ 2lgN。
 * 
 * 1.4.18 Local minimum of an array. Write a program that, given an array a[] of
 * N distinct integers, finds a local minimum:an index i such that a[i-1] < a[i]
 * < a[i+1]. Your program should use ~2lg N compares in the worst case.. Answer:
 * Examine the middle value a[N/2] and its two neighbors a[N/2 - 1] and
 * a[N/2+1].If a[N/2] is a local minimum, stop; otherwise search in the half
 * with the smaller neighbor.
 */
public class LocalMinimum {
	
	public static int localMinimum(int[] x){
		if (x == null || x.length == 0) {
			return -1;
		}
		if (x.length == 1 || x[0] < x[1]) {
			return 0;
		}
		if (x[x.length - 1] < x[x.length - 2]) {
			return x.length - 1;
		}
		
		int mid = 0;
		int left = 1;
		int right = x.length - 2;
		while (left < right) {
			mid = (left + right) / 2;
			if (x[mid - 1] < x[mid]) 
			{
				right = mid - 1;
			}else if (x[mid + 1] < x[mid] )
			{
				left = mid + 1;
			}else {
				return mid;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		int[] a = {2,1,3,4,5,6,11,14,8,25};
		int index = localMinimum(a);
		System.out.println("局部最小元素，"+"a["+index+"]值为"+ a[index]);
	}

	
}
