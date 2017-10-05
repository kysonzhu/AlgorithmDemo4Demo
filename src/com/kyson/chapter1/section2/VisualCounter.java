package com.kyson.chapter1.section2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/***
 * 
 * 1.2.10 编写一个类 VisualCounter，支持加一和减一操作。它的构造函数接受两个参数 N 和 max，其中 N 指定了操作的最大次数，
 * max 指定了计数器的最大绝对值。作为副作用，用图像显示每次计数器变化后的值。 1.2.10 Develop a class VisualCounter
 * that allows both increment and decrement operations. Take two arguments N and
 * max in the constructor, where N specifies the maximum number of operations
 * and max specifies the maximum absolute value for the counter. As a side
 * effect, create a plot showing the value of the counter each time its tally
 * changes.
 */
public class VisualCounter {

//	 private final int n;
//	 private final int max;
//	 private int value;
//	 private int operationCount;
//	
//	 public VisualCounter(int n, int max) {
//	 this.n = n;
//	 this.max = max;
//	 this.value = 0;
//	 this.operationCount = 0;
//	 }
//	
//	 public void increment() {
//	 if (operationCount++ < n && value < max) {
//	 value++;
//	 }
//	 }
//	
//	 public void decrement() {
//	 if (operationCount++ < n && value > -max) {
//	 value--;
//	 }
//	 }
//	
//	 public void draw() {
//	 StdDraw.point(operationCount, value);
//	 }
//	
//	 public static void main(String[] args) {
//	 int max = 15;
//	 int count = 30;
//	
//	 StdDraw.setXscale(0, count + 1);
//	 StdDraw.setYscale(-max, max);
//	 StdDraw.line(0, 0, count + 1, 0);
//	
//	 StdDraw.setPenColor(StdDraw.RED);
//	 StdDraw.setPenRadius(0.005);
//	
//	 VisualCounter counter = new VisualCounter(count, max);
//	 counter.draw();
//	 for (int i = 0; i < count; i++) {
//	
//	 if (StdRandom.bernoulli()) {
//	 counter.increment();
//	 } else {
//	 counter.decrement();
//	 }
//	 counter.draw();
//	 }
//	
//	 }
/***************************************************************************/
	private long N;
	private double total;

	public VisualCounter(long trails, double max) {
		StdDraw.setXscale(0, trails);
		StdDraw.setYscale(-max, max);
		StdDraw.setPenRadius(.005f);
	}

	public void increment() {
		N++;
		total ++;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, total);
	}

	public void decrement() {
		N++;
		total --;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, total);
	}

	public static void main(String[] args) {
		VisualCounter counter = new VisualCounter(300, 150.0);
		for (int i = 0; i < 10000; i++)
			if (StdRandom.random() > 0.5) {
				counter.increment();;
			}else {
				counter.decrement();;
			}
		StdOut.println(counter);
	}

}
