package com.kyson.chapter1.section3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Practise_01_03_16 {

    public static class Date {

        private int month;
        private int day;
        private int year;

        public Date(String date)
        {
            String[] fields = date.split("/");
            month = Integer.parseInt(fields[0]);
            day = Integer.parseInt(fields[1]);
            year = Integer.parseInt(fields[2]);
        }

        public String toString() {
            return "" + month + "/" + day + "/" + year;
        }

        public static Date[] readDates(String name) {
            In in = new In(name);
            Queue<Date> q = new Queue<Date>();
            while (!in.isEmpty()) {
                String a = in.readString();
                Date date = new Date(a);
                q.enqueue(date);
            }
            int N = q.size();
            Date[] a = new Date[N];
            for (int i = 0; i < N; i++)
                a[i] = q.dequeue();
            return a;
        }

        public static void main(String[] args)
        {
            String a = "这里填入路径+文件名";
            Date[] dates = readDates(a);
            StdOut.print(Arrays.toString(dates));

        }
    }

}
