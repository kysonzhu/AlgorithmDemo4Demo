package com.kyson.chapter1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/***
 * 1.3.1 为FixedCapacityStackOfStrings添加一个方法isFull()。
 * 1.3.1 Add a method isFull() to FixedCapacityStackOfStrings.
 */
public class FixedCapacityStackOfStrings {


    private int N;
    private String[] a;

    public FixedCapacityStackOfStrings(int cap) {
        String[] temp = new String[cap];
        a = temp;
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
        return N == 0;
    }

    public boolean isFull() {
        return N == a.length;
    }


//    public static void main(String[] argv){
//        FixedCapacityStackOfStrings strs = new FixedCapacityStackOfStrings(100);
//
//        strs.push("My");
//        strs.push("name");
//        strs.push("is");
//        strs.push("顶级程序员不穿女装");
//
//    }

    public static void main(String[] args) {
//      String testString = "it was - the best - of times - - - it was - the - -";
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + "");
            }
        }
    }


}
