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
public class ClosestPairFaster {
	public static void closestPairFaster(double[] x)
	{
		double minNum = Double.MAX_VALUE;
		int minI = 0;
		for(int i = 0;i < x.length - 1;++i)
		{
			if (x[i+1]- x[i] < minNum) 
			{
				minI = i;
				minNum = x[i+1]- x[i] ;
			}
		}
		System.out.println("最接近的两个数为:"+x[minI]);
		System.out.println("和:"+x[minI+ 1]);
	}
	
	public static void main(String[] args){
		double[] a = {1,2,3,4,5,888,76,45};
		Arrays.sort(a);
		closestPairFaster(a);
	}
}
