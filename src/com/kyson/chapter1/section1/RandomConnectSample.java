package com.kyson.chapter1.section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.1.31 随机连接。编写一段程序，从命令行接受一个整数 N 和 double 值 p(0 到 1 之间)作为参数， 在一个圆上画出大小为 0.05
 * 且间距相等的 N 个点，然后将每对点按照概率 p 用灰线连接。
 * 
 * 1.1.31 Random connections. Write a program that takes as command-line
 * arguments an integer N and a double value p (between 0 and 1), plots N
 * equally spaced dots of size .05 on the circumference of a circle, and then,
 * with probability p for each pair of points, draws a gray line connecting
 * them.
 */
public class RandomConnectSample {
	
	static class Point {
		double x;
		double y;

		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	

	public static void main(String[] args) {
		int N = 10;
		double p =  StdRandom.uniform();

		//算出角度
		double angle = 360.0 / N;
		StdDraw.circle(0.5, 0.5, 0.5);
		
		Point[] points = new Point[N];		
		for (int i = 0; i < N; i++)
		{
			points[i] = new Point(0.5 + 0.5 * Math.cos(angle * i * Math.PI / 180),
					0.5 + 0.5 * Math.sin(angle * i * Math.PI / 180));
			StdDraw.point(points[i].x, points[i].y);
		}
		
		StdDraw.setPenColor(StdDraw.GRAY);

		for (int i = 0; i < N - 1; i++) 
		{
			for (int j = i + 1; j < N; j++)
			{
				if (StdRandom.bernoulli(p))
				{
					StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
				}
			}
		}
		
	}

}
