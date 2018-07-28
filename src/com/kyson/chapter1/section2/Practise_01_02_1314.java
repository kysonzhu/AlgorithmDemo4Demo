package com.kyson.chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

/*
*
* 1.2.13 用我们对Date的实现作为模板实现Transaction类型

1.2.13 Using our implementation of Date as a model(page91),develop an
 implementation of Transaction.

 1.2.14 用我们对Date的实现作为模板实现Transaction的euqal()函数

1.2.14 Using our implementation of equals() in Date as a model(page103),
develop implementations of equals() for Transaction.
* */
public class Practise_01_02_1314 {

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

        public SmartDate(String date)
        {
            String[] s = date.split("\\/");
            if (s.length != 3)
                throw new IllegalArgumentException("Argument illegal " + date);
            int m = Integer.parseInt(s[0]);
            int d = Integer.parseInt(s[1]);
            int y = Integer.parseInt(s[2]);

            if (!validate(m, d, y))
                throw new IllegalArgumentException("Argument illegal " + m + "/" + d + "/" + y);

            this.month = m;
            this.day = d;
            this.year = y;
        }

        public String toString() {
            return month + "/" + day + "/" + year;
        }
    }


    public static class Transaction implements Comparable<Transaction>
    {
        private final String name;
        private final SmartDate date;
        private final double amount;

        public Transaction(String who, SmartDate when, double amount)
        {
            this.name = who;
            this.date = when;
            this.amount = amount;
        }

        public Transaction(String transaction)
        {
            String[] s = transaction.split("\\s+");
            if (s.length != 3)
                throw new IllegalArgumentException("Argument illegal " + transaction);
            this.name = s[0];
            this.date = new SmartDate(s[1]);
            this.amount = Double.parseDouble(s[2]);
        }

        public String who()
        {
            return this.name;
        }

        public SmartDate when()
        {
            return this.date;
        }

        public double amount()
        {
            return this.amount;
        }

        public String toString()
        {
            return name + " " + date + " " + amount;
        }

        public boolean equals(Object that)
        {
            if (this == that) return true;
            if (that == null) return false;
            if (this.getClass() != that.getClass()) return false;
            Transaction t = (Transaction) that;
            if (!this.name.equals(t.name)) return false;
            if (!this.date.equals(t.date)) return false;
            if (this.amount != t.amount) return false;
            return true;
        }

        public int hashCode()
        {
            int hash = 1;
            hash = hash * 31 + this.name.hashCode();
            hash = hash * 31 + this.date.hashCode();
            hash = hash * 31 + ((Double) this.amount).hashCode();
            return hash;
        }


        @Override
        public int compareTo(Transaction o)
        {
            if (this.amount > o.amount) return 1;
            else if (this.amount < o.amount) return -1;
            else return 0;
        }
    }


    public static void main(String[] args) throws Exception {
        Date date=new Date(1996,12,5);
        Transaction tran = new Transaction("Turing 6/17/1990 644.08");
        StdOut.println(tran.toString());
    }


}
