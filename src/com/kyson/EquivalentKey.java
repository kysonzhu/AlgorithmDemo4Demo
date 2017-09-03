package com.kyson;

import java.nio.file.SimpleFileVisitor;

/**
 * 等值键:http://www.jianshu.com/p/a1a9c6b0254c
 * 
 * 
 * 1.1.29 等值键。为 BinarySearch 类添加一个静态方法 rank()，它接受一个键和一个整型有序数
 * 组(可能存在重复键)作为参数并返回数组中小于该键的元素数量，以及一个类似的方法 count() 
 * 来 返回数组中等于该键的元素的数量。注意:如果 i 和 j 分别是 rank(key,a) 和 
 * count(key,a) 的返回值，那么 a[i..i+j-1] 就是数组中所有和 key 相等的元素。
 * 
 * 
 * */
public class EquivalentKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] N = {1,2,3,4,5,5,5,6,7,8,9,89,89,100};
		
		System.out.println(rank(5,N) + "");
		System.out.println(count(5,N) +"");
		
	}
	
	public static int binarySearch(int target ,int[] N) {
		int lo = 0;
		int hi = N.length - 1;
		
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2 ;

			if (target > N[mid]) {
				lo = mid + 1 ;
			} else if (target < N[mid]) {
				hi = mid - 1;
			} else {
				 return mid;
			}
		}
		
		return -1;
	}
	
	public static int rank(int key,int[] N){
	
		//先找到这个数
		int searchResult = binarySearch(key, N);
		
		System.out.println("searchResult: " + searchResult);
		
		int resultNum = 0;
		
		if (searchResult != -1) {
			for (int i = 0; i < N.length; i++) {
				if (N[i] == N[searchResult] ) {
					resultNum = i;
					break;
				}
			}			
		}
		
		return resultNum;
	}
	
	public static int count(int key,int[] N) {
		int searchResult = binarySearch(key, N);
		System.out.println("searchResult: " + searchResult);

		int resultNum = 0;

		if (searchResult != -1) {
			for (int i = 0; i < N.length; i++) {
				if (N[i] == N[searchResult] ) {
					resultNum++;
				}
			}			
		}
		
		return resultNum;
	}

}
