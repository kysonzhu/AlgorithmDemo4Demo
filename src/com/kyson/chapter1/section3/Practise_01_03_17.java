package com.kyson.chapter1.section3;

import edu.princeton.cs.algs4.In;

public class Practise_01_03_17 {

    public static class Transaction
    {

        private Date1 when;
        private String who;
        private double amount;

        public Transaction(String date) {
            String[] fields = date.split("-");
            when = new Date1(fields[0]);
            who = fields[1];
            amount = Integer.parseInt(fields[2]);
        }

        public String toString() {
            return "" + this.who + " at " + this.when + " transaction "
                    + this.amount;
        }

        public static Transaction[] readTransactions(String name) {
            In in = new In(name);
            Queue<Transaction> q = new Queue<Transaction>();
            while (!in.isEmpty()) {
                String x = in.readString();
                Transaction t = new Transaction(x);
                q.enqueue(t);
            }
            int N = q.size();
            Transaction[] a = new Transaction[N];
            for (int i = 0; i < N; i++)
                a[i] = q.dequeue();
            return a;
        }
    }
}
