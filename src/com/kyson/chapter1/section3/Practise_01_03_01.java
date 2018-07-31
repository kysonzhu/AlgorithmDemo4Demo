package com.kyson.chapter1.section3;

/*
*1.3.1 为FixedCapacityStackOfStrings添加一个方法isFull()。

1.3.1 Add a method isFull() to FixedCapacityStackOfStrings.

 *  */
public class Practise_01_03_01 {

    public static class FixedCapacityStackOfStrings {
        private int N;
        private String[] a;

        public FixedCapacityStackOfStrings(int cap) {
            a = new String[cap];
        }

        public void push(String item) {
            a[N++] = item;
        }

        public int size() {
            return N;
        }

        public String pop() {
            return a[--N];
        }

        public boolean isEmpty() {
            return N ==0;
        }

        public boolean isFull() {
            return N == a.length;
        }
    }

    public static void main(String[] args) {

    }
}
