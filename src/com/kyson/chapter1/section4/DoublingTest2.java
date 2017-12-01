package com.kyson.chapter1.section4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.text.DecimalFormat;

/**
 * 1.4.3 修改DoublingTest,使用StdDraw产生类似于正文中的标准图像和对数图形,根据需要调整比例使图 像总能够充满窗口的大部分区域
 * 1.4.3 Modify DoublingTest to use StdDraw to produce plots like the standard
 * and log-log plots in the text, rescaling as necessary so that the plot always
 * fills a substantial portion of the window.
 */
public class DoublingTest2 {

    public static double timeTrial(int N) { // Time ThreeSum2.count() for N
        // random 6-digit ints.
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    // 绘制标准图形
    public static void drawStandard(int[] n, double[] time) {
        StdDraw.setXscale(-0.5, 1.2 * n[n.length - 1] / 1000.0);
        StdDraw.setYscale(-0.5, time[n.length - 1] * 1.2);
        // 建立坐标系
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.001);
        StdDraw.line(0, 0, 1.1 * n[n.length - 1] / 1000, 0);
        StdDraw.line(0, 0, 0, 1.1 * time[n.length - 1]);
        for (int i = 1; i < 1.1 * n[n.length - 1] / 1000.0; i++)
            StdDraw.text(i, -0.2, i + "K");
        for (double t = 2; t < time[n.length - 1] * 1.1; t += 2)
            StdDraw.text(-0.2, t, t + "");
        // 绘制图像
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.setPenRadius(0.02);
        for (int i = 0; i < n.length; i++)
            StdDraw.point(n[i] / 1000.0, time[i]);
    }

    //绘制对数图形
    public static void drawLog(int[] arrN, double[] timeN) {
        //将时间转换为其对数
        double[] timelog = new double[timeN.length];
        for (int i = 0; i < timeN.length; i++)
            timelog[i] = Math.log(timeN[i]);
        StdDraw.setXscale(-0.5, 1.2 * arrN[arrN.length - 1] / 1000.0);
        StdDraw.setYscale(-0.5, timelog[arrN.length - 1] * 1.2);
        //建立坐标系
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.001);
        StdDraw.line(0, 0, 1.1 * arrN[arrN.length - 1] / 1000, 0);
        StdDraw.line(0, 0, 0, 1.1 * timelog[arrN.length - 1]);
        for (int i = 1; i < 1.1 * arrN[arrN.length - 1] / 1000.0; i++)
            StdDraw.text(i, -0.2, i + "K");
        for (double t = 0; t < timelog[arrN.length - 1] * 1.1; t += timelog[arrN.length - 1] / 5)
            StdDraw.text(-0.2, t, String.format("%.2f", t));
        //绘制图像
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.setPenRadius(0.02);
        for (int i = 0; i < arrN.length; i++)
            StdDraw.point(arrN[i] / 1000.0, timelog[i]);
    }

    public static void main(String[] args) {
        int MAX=4000;int i=0;
        int len=(int)(Math.log(MAX/250)/Math.log(2))+1;
        int[] arrN=new int[len];
        double[] timeN=new double[len];
        for(int N=250;N<=MAX;N+=N)
        {
            double time=timeTrial(N);
            StdOut.printf("%7d %5.1f\n",N,time);
            arrN[i]=N;
            timeN[i++]=time;
        }
//        drawStandard(arrN,timeN);
        drawLog(arrN,timeN);

    }
}
