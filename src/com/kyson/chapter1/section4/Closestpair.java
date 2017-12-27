package com.kyson.chapter1.section4;

import java.util.Arrays;

/**
 * 1.4.16 最接近一对（一维）。编写一个程序，给定一个含有 N 个 double 值的数组
 * a[]，在其中找到一对最接近的值：两者之差（绝对值）最小的两个数。程序在最坏情况下所需的运行时间应该是线性对数级别的。
 * 
 * 1.4.16 Closest pair (in one dimension). Write a program that, given an array
 * a[] of N double values, finds a closest pair : two values whose difference is
 * no greater than the the difference of any other pair (in absolute value). The
 * running time of your program should be linearithmic in the worst case.
 *
 */
public class Closestpair {

	public static void closestPair(double[] a){
		double smallestValues = Double.MAX_VALUE;
		int smallestIndexI = 0;
		int smallestIndexj = 0;
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = i+ 1; j < a.length; j++) 
			{
				double value = Math.abs(a[i]- a[j]);
				if (value < smallestValues) 
				{
					smallestValues = value;
					smallestIndexI = i;
					smallestIndexj = j;
				}
			}
		}
		System.out.println("最接近的两个数为:"+a[smallestIndexI]);
		System.out.println("和:"+a[smallestIndexj]);
	}
	
	public static void main(String[] args) {
		double[] b = {1.0,26,36,74,599,60,7,8};
		Arrays.sort(b);
		closestPair(b);
	}
}
