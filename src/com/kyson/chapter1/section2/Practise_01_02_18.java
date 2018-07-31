package com.kyson.chapter1.section2;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/*
*
* 1.2.18 累加器的方差。以下代码为Accumulator类添加var()和stddev()方法，
* 它们计算了addDataValue()方法的参数的方差和标准差，验证这段代码。
*
* */
public class Practise_01_02_18 {

    public static class Accumulator {
        private double m;
        private double s;
        private int N;

        public void addDataValue(double x) {
            N++;
            s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
            m = m + (x - m) / N;
        }

        public double mean() {
            return m;
        }

        public double var() {
            return s / (N - 1);
        }

        public double stddev() {
            return Math.sqrt(this.var());
        }
    }

//    public static class Accumalator {
//        private double total;
//        private int N;
//        public void addDataValue(double val) {
//            N++;
//            total += val;
//        }
//
//        public double mean() {
//            return total / N;
//        }
//
//        public String toString() {
//            return "Mean(" + N + " values):" +String.format("%7.5f",mean());
//        }
//    }


    public static class VisualAccumalator {
        private double total;
        private int N;

        public VisualAccumalator (int trials,double max){
            StdDraw.setXscale(0,trials);
            StdDraw.setYscale(0,max);
            StdDraw.setPenRadius(0.005);
        }

        public void addDataValue(double val) {
            N++;
            total += val;

            StdDraw.setPenColor(StdDraw.DARK_GRAY);
            StdDraw.point(N,val);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(N,total/N);
        }

        public double mean() {
            return total / N;
        }

        public String toString() {
            return "Mean(" + N + " values):" +String.format("%7.5f",mean());
        }
    }

    public static void main(String[] args) {

        VisualAccumalator accumalator = new VisualAccumalator(1000,1.0);
        for (int i = 0; i < 10000; i++) {
            accumalator.addDataValue(StdRandom.random());
        }
        System.out.println("result:" + accumalator);

    }
}
