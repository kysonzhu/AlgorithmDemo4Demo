package com.kyson.chapter1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Practise_01_03_02 {

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

    public static void main(String[] args){
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")){
                s.push(item);
            }else if(!s.isEmpty()){
                StdOut.print(s.pop() + "");
            }
        }
    }
}
