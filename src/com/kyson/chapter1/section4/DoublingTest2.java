package com.kyson.chapter1.section4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.4.3 修改DoublingTest,使用StdDraw产生类似于正文中的标准图像和对数图形,根据需要调整比例使图
 * 像总能够充满窗口的大部分区域
 * 1.4.3 Modify DoublingTest to use StdDraw to produce plots like the standard and
 * log-log plots in the text, rescaling as necessary so that the plot always fills
 * a substantial portion of the window.
 */
public class DoublingTest2 {

    public static double timeTrial(int N) {  // Time ThreeSum2.count() for N random 6-digit ints.
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {  // Print table of running times.
        StdDraw.setXscale(0,3000);
        StdDraw.setYscale(0,0.5);
        StdDraw.setPenRadius(.01);
        for (int N = 3; true; N = N+ 1) {  // Print time for problem size N.
            double time = timeTrial(N);


            StdDraw.point(N,time);

            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }
}
