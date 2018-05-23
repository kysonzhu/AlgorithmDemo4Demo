package com.kyson.chapter1.section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Practise_01_01_32 {

    public static void main(String[] args) {

        double[] a = {1.12, 1.22, 5.666, 9.0908, 8.902, 3.892, 10.782, 10.9,
                10.19, 10.29, 20.1};
        int N = 10;
        double l = 1.09;
        double r = 20.29;

        // 组距
        double classInterval = (r - l) / N;
        // 对应到直方图中的组距
        double intervalReact = 1 * 1.0 / N;

        for (int i = 0; i < N; i++) {
            // 每组数据的左值和右值
            double tempLeft = l + classInterval * i;
            double tempRight = l + classInterval * (i + 1);
            // 每组数据的左值对应到直方图中的左值
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
            // 将频数转换为频率
            double height = tempNum * 1.0 / (N * 2);
            // 画图
            StdDraw.filledRectangle(tempLeftReact, height, intervalReact,
                    height);
        }

    }
}
