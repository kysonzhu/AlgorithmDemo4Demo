package com.kyson.chapter1.section4;

import java.util.Arrays;


/***


 * 1.4.17 最遥远的一对（一维）。编写一个程序，给定一个含有 N 个 double 值的数组
 * a[]，在其中找到一对最遥远的值：两者之差（绝对值）最大的两个数。程序在最坏情况下所需的运行时间应该是线性级别的。
 * 
 * 1.4.17 Farthest pair (in one dimension). Write a program that, given an array
 * a[] of N double values, finds a farthest pair : two values whose difference
 * is no smaller than the the difference of any other pair (in absolute value).
 * The running time of your program should be linear in the worst case.
 * 
 *
 */

public class FastestPair {
	public static void fastestPair(double[] x)
	{
		System.out.println("最遥远的两个数为:"+x[0]);
		System.out.println("和:"+x[x.length- 1]);
	}
	
	public static void main(String[] args){
		double[] a = {1,2,3,4,5,888,76,45};
		Arrays.sort(a);
		fastestPair(a);
	}
}
