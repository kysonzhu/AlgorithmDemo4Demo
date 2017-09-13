package com.kyson.chapter1.section2;

import java.util.ArrayList;

/**
 * 
 * 1.2.1编写一个Point2D的用例，从命令行接受一个整数N。
 * 在单位正方形内生成N个随机点，然后计算两点之间的最近距离
 *
 * 1.2.1 Write a Point2D client that takes an integer 
 * value N from the command line, generates N random 
 * points in the unit square, and computes the distance 
 * separating the closest pair of points.
 */
public class Point2D {
	
	public double x;
	public double y;
	
	//初始化函数
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//计算两点之间的距离
	public double distTo(Point2D that){
		double xDistance = this.x - that.x;
		double yDistance = this.y - that.y;
		return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = 10;
		

		ArrayList<Point2D> points = new ArrayList<Point2D>();
		//创建N个元素的数组
		for (int i = 0; i < N; i++) {
			Point2D point2d = new Point2D(Math.random(), Math.random());
			points.add(point2d);
		}
		//计算第一个点到第二个点的距离
		double resultDistince = points.get(0).distTo(points.get(1));
		
		for (int i = 0; i < N; i++) {
			Point2D point2d = points.get(i);
			for (int j = i + 1; j < N; j++) {
				//计算第i个点和第j个点之间的距离
				double distince = point2d.distTo(points.get(j));
				//如果距离比resultDistince小，就赋值给resultDistince
				if (distince < resultDistince) {
					resultDistince = distince;
				}
				
			}
			
		}
		
		System.out.println("resultDistince:" + resultDistince);
		
		
		
	}

}
