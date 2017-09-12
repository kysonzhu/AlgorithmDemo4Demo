package com.kyson.chapter1.section1;

import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 * 1.1.32 直方图。假设标准输入流中含有一系列 double 值。
 * 编写一段程序，从命令行接受一个整数 N 和 两个 double 值 l 和 r。
 * 将 (l，r) 分为 N 段并使用 StdDraw 画出输入流中的值落入每段的数量的直方图。
 * 1.1.32 Histogram. Suppose that the standard input stream is a sequence of double values.
 * Write a program that takes an integer N and two double values l and r
 * from the command line and uses StdDraw to plot a histogram of 
 * the count of the numbers in the standard input stream that fall in each 
 * of the N intervals defined by dividing (l , r) into N equal-sized intervals.
 *
 */

public class Histogram {

	public static void main(String[] args) {

		double[] a = {1.12,1.22,5.666,9.0908,8.902,3.892,10.782,10.9,10.19,10.29,20.1};
		int N = 10;
		double l = 1.09;
		double r = 20.29;
		
		//组距
		double classInterval = (r - l ) / N;
		//对应到直方图中的组距
		double intervalReact = 1 * 1.0 / N;
		
		for (int i = 0; i < N; i++) {
			//每组数据的左值和右值
			double tempLeft = l + classInterval * i;
			double tempRight = l + classInterval * (i + 1);
			//每组数据的左值对应到直方图中的左值
			double tempLeftReact = intervalReact * i;
			
			/**
			 * 以下代码块是用于输入流在计算该组数下的频数
			 */
			int tempNum = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[j] > tempLeft && a[j] < tempRight) {
					tempNum++;
				}
			}
			//将频数转换为频率
			double height = tempNum  * 1.0 / ( N * 2 ) ;
			//画图
			StdDraw.filledRectangle(tempLeftReact, height, intervalReact, height);
		}		
	
		
		/*
		 * demo 用于展示StdDraw.filledRectangle 的用法
		 */
		/*
		int N = 50;
		double[] a = new double[N];
		for (int i = 0; i < N; i++)
		   a[i] = StdRandom.random();
		
		Arrays.sort(a);
		for (int i = 0; i < N; i++)
		{
		   double x = 1.0*i/N;
		   double y = a[i]/2.0;
		   double rw = 0.5/N;
		   double rh = a[i]/2.0;
		   
		   System.out.println("x:"+x+"y:"+y+"rw:"+rw+"rh:"+rh);
		   StdDraw.filledRectangle(x, y, rw, rh);
		}
		*/
	}
	
	
	
	

}
