package com.kyson.chapter1.section1;

//public class BinarySearch {
//
//	public static int rank (int key,int[] a) {
//		return rank(key,a,0,16,1);
//	}
//	
//
//	public static int rank (int key,int[] a,int lo,int hi,int deep) {
//		if (hi < lo) return - 1;
//		int mid = lo + (hi - lo) / 2;
//		for(int i = 0 ; i < deep ; i++)
//			System.out.print(" ");
//		System.out.println("lo: "+lo+"  hi: "+hi);
//		if (key < a[mid])
//			return rank (key,a,lo,mid - 1,deep + 1);
//		else if (key > a[mid])
//			return rank (key,a,mid + 1,hi,deep + 1);
//		else
//			return mid;
//	}
//	
//	
//	public static void main(String[] args) {
//		int[] array = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
//		rank(10,array);
//	}
//}


import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class BinarySearch {
	public static int rank(int key, int[] a) { // 数组必须是有序的
		int lo =0;
		int hi = a.length - 1;
		while (lo <= hi){ // 被查找的键要么不存在，要么必然存在于a[lo..hi]之中
			int mid = lo + (hi - lo) / 2;
			if(key < a[mid]) 
				hi = mid - 1;
			else if(key > a[mid]) 
				lo = mid + 1;
			else                   
				return mid;
			}
		return -1; 
	}
	
	
	public static void main(String[] args){
		int[] whitelist = In.readInts(args[0]); 
		Arrays.sort(whitelist);

		while (!StdIn.isEmpty()) { 
			// 读取键值，如果不存在于白名单中则将其打印
			int key = StdIn.readInt(); 
			if (rank(key, whitelist) < 0)
				StdOut.println("+" + key);
			else
				StdOut.println("-" + key);

		}
	} 
}
