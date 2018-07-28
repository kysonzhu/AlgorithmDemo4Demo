package com.kyson.chapter1.section2;

import java.util.Scanner;
/*
*
*
* */
public class Practise_01_02_12 {
    public static class SmartDate {
        private final int year;
        private final int month;
        private final int day;
        private static final int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        private static final int[] days = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        private static final int[] daysLeap = {0, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
        private static final String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday"};

        public SmartDate(int m,int d,int y) {
            if (!validate(m, d, y))
                throw new IllegalArgumentException("Argument illegal " + m + "/" + d + "/" + y);
            this.day 	= d;
            this.year 	= y;
            this.month 	= m;
        }

        public int month() {
            return month;
        }

        public int day() {
            return day;
        }

        public int year() {
            return year;
        }

        public String dayOfTheWeek()
        {
            // based on 1/1/2000
            int totalDays;
            if (isLeapYear()) {
                totalDays = daysLeap[month] + day;
            }
            else {
                totalDays = days[month] + day;
            }

            for (int i = 2000; i < year; i++) {
                if (isLeapYear(i))
                    totalDays += 366;
                else
                    totalDays += 365;
            }

            // 1/1/2000 is Saturday
            return weekdays[((totalDays - 1) % 7 + 6) % 7];
        }

        private boolean validate(int m, int d, int y) {
            if (y == 0 || y < -1000 || y > 10000)
                return false;
            if (m < 1 || m > 12)
                return false;
            if (d < 1 || d > 31)
                return false;
            if (d > months[m])
                return false;
            if (!isLeapYear() && d > 28)
                return false;
            return true;
        }

        private boolean isLeapYear(int y) {
            if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
                return true;
            }
            else {
                return false;
            }
        }

        private boolean isLeapYear()
        {
            return isLeapYear(year);
        }

        public boolean equals(Object x)
        {
            if (this == x) return true;
            if (x == null) return false;
            if (this.getClass() != x.getClass()) return false;
            SmartDate that = (SmartDate)x;
            if (this.day != that.day) return false;
            if (this.month != that.month) return false;
            if (this.year != that.year) return false;
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 17;
            hash = hash * 31 + month;
            hash = hash * 31 + day;
            hash = hash * 31 + year;
            return hash;
        }

        public String toString() {
            return month + "/" + day + "/" + year;
        }
    }

    public static void main(String[] args){
        System.out.println("请输入年月日");
        Scanner scanner1 = new Scanner(System.in);
        String y = scanner1.next();
        Scanner scanner2 = new Scanner(System.in);
        String m = scanner2.next();
        Scanner scanner3 = new Scanner(System.in);
        String d = scanner3.next();

        SmartDate smartDate = new SmartDate(Integer.valueOf(m),Integer.valueOf(d),Integer.valueOf(y));
        System.out.println(smartDate);
        System.out.println(smartDate.dayOfTheWeek());
    }
}
