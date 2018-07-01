package com.kyson.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/*
*
* 1.1.35 模拟掷骰子。以下代码能够计算每种两个骰子之和的准确概率分布：

int SIDES = 6;
double[] dist = new double[2 * SIDES + 1];
for(int i = 1; i <= SIDES; i++)
    for(int j = 1; j <= SIDES; j++)
        dist[i+j] += 1.0;
for (int k = 2; k <= 2*SIDES; k++)
    dist[k] /= 36.0;
dist[i] 的值就是两个骰子之和为i 的概率。用实验模拟N 次掷骰子，并在计算两个1 到 6
之间的随机整数之和时记录每个值的出现频率以验证它们的概率。N 要多大才能够保证你的经验数据和准确数据的吻合程度达到小数点后三位？
* */
public class Practise_01_01_35 {

    // 色子有六面，数值分别是1、2、3、4、5、6
    private static int sides = 6;


    /**
     * 根据统计数据计算概率值
     *
     * @param dist 统计数据数组
     * @return 概率数组
     */
    private static double[] computeProbability(double[] dist, int testTimes) {
        for (int i = 2; i <= 2 * sides; ++i)
            dist[i] /= (1.0 * testTimes);
        return dist;
    }

    /**
     * 两个色子之和的理论概率值
     *
     * @return 理论概率值
     */
    private static double[] theoreticalValue() {
        double[] dist = new double[2 * sides + 1];
        // 统计值出现的理论次数
        for (int i = 1; i <= sides; ++i)
            for (int j = 1; j <= sides; ++j)
                dist[i + j] += 1.0;
        // 计算理论概率
        dist = computeProbability(dist, 36);
        return dist;
    }

    /**
     * 试验概率值能否与理论概率值至少匹配到小数点后三位数
     *
     * @param dist0 理论概率值
     * @param dist1 试验概率值
     * @return 能匹配到小数点后三位数则返回true，否则返回false
     */
    private static boolean isMatch(double[] dist0, double[] dist1) {
        for (int i = 2; i <= 2 * sides; ++i)
            if (Math.abs(dist0[i] - dist1[i]) >= 0.0001)
                return false;
        return true;
    }

    /**
     * 用随机数模拟掷色子并统计求出试验概率
     *
     * @param N 抛掷次数
     * @return 试验概率
     */
    private static double[] simulate(int N) {
        double[] dist = new double[2 * sides + 1];
        // 做N次随机试验模拟抛色子,并统计数据
        for (int i = 0; i < N; ++i) {
            int a = StdRandom.uniform(1, 6 + 1);
            int b = StdRandom.uniform(1, 6 + 1);
            dist[a + b] += 1.0;
        }
        // 计算试验概率值
        dist = computeProbability(dist, N);
        return dist;
    }


    /**
     * 测试得到符合要求的试验次数N
     *
     * @param initTimes 试验初始次数值
     * @param dist0     理论概率
     * @return 符合要求的试验次数
     */
    private static int testGetN(int initTimes, double[] dist0) {
        int N = initTimes;
        boolean match = false;
        while (!match) {
            double[] dist1 = simulate(N);
            match = isMatch(dist0, dist1);
            if (match)
                System.out.println(dist1);
            // 当前N不合要求，则将N扩大10倍
            N *= 10;
        }
        return N;
    }


    public static void main(String[] args) {
        double[] dist0 = theoreticalValue();
        System.out.println(dist0);
        int initTimes = 1000000;
        int N = testGetN(initTimes, dist0);
        StdOut.println("至少试验次数的数量级： o(" + N + ")");
    }
}
