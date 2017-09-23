package com.kyson.chapter1.section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/***
 * 
 * @author zhujinhui
 * 
 * 1.1.31 随机连接。编写一段程序，从命令行接受一个整数 N 和 double 值 p(0 到 1 之间)作为参数， 
 * 在一个圆上画出大小为 0.05 且间距相等的 N 个点，然后将每对点按照概率 p 用灰线连接。
 *
 */

public class DrawLine {

	
	/**
	 * 画圆
	 * @param x 圆心x坐标
	 * @param y 圆心y坐标
	 * @param r 半径r
	 */
	private static void drawCircle(double x, double y, double r) {
	    StdDraw.setXscale(0, 2 * x);
	    StdDraw.setYscale(0, 2 * y);
	    StdDraw.setPenRadius(0.003);
	    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
	    StdDraw.circle(x, y, r);
	}

	/**
	 * 在圆上描点
	 * @param x0 圆心x坐标
	 * @param y0 圆心y坐标
	 * @param r 半径r
	 * @param N N个点
	 */
	private static double[][] drawPoints(double x0, double y0, double r, int N) {
	    double[][] points = new double[N][2];
	    StdDraw.setPenRadius(0.005);
	    StdDraw.setPenColor(StdDraw.BOOK_RED);
	    for(int idx = 0; idx < N; ++idx) {
	        double x = x0 + r * Math.cos(2 * Math.PI * idx / N);
	        double y = y0 + r * Math.sin(2 * Math.PI * idx / N);
	        StdDraw.point(x, y);
	        points[idx][0] = x;
	        points[idx][1] = y;
	    }
	    return points;
	}

	/**
	 * 以概率p随机连接顶点集points中的点
	 * @param points    点集
	 * @param p 概率p
	 */
	private static void randomLinkPoints(double[][] points, double p) {
	    StdDraw.setPenRadius(0.002);
	    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
	    int length = points.length;
	    for(int i = 0; i < length; ++i)
	        for(int j = 0; j < length; ++j)
	            if(true == StdRandom.bernoulli(p))
	                StdDraw.line(points[i][0], points[i][1], points[j][0], points[j][1]); // 应该再建立一个包含x坐标和y坐标的数据结构
	}

	/**
	 * 在圆上画N个点然后每两点间以概率p连接
	 * @param N N个点
	 * @param p 概率p
	 */
	private static void randomLink(int N, double p) {
	    double x = 10.0;
	    double y = 10.0;
	    double r = 9.0;
	    drawCircle(x, y, r);
	    double[][] points = drawPoints(x, y, r, N);
	    randomLinkPoints(points, p);
	}

	public static void main(String[] args) {
//	    randomLink(20, 0.2);
//		
//		int N = 50;
//		double[] a = new double[N];
//		for (int i = 0; i < N; i++)
//		   a[i] = StdRandom.random();
//		for (int i = 0; i < N; i++)
//		{
//		   double x = 1.0*i/N;
//		   double y = a[i]/2.0;
//		   double rw = 0.5/N;
//		   double rh = a[i]/2.0;
//		   StdDraw.filledRectangle(x, y, rw, rh);
//		}
		
		StdDraw.filledRectangle(0, 0, 0.3, 0.5);

	}
	
	
}
