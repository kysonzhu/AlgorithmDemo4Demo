package com.kyson.chapter1.section3;


/***
 * 1.3.1 为FixedCapacityStackOfStrings添加一个方法isFull()。
 * 1.3.1 Add a method isFull() to FixedCapacityStackOfStrings.
 */
public class FixedCapacityStackOfStrings {


    private int N;
    private String[] a;

    public FixedCapacityStackOfStrings(int cap){
        String[] temp = new String[cap];
        a = temp;
    }


    public void push(String item){
        a[N++] = item;
    }

    public int size(){
        return N;
    }

    public String pop(){
        return a[--N];
    }

    public boolean isEmpty(){
        return N ==0;
    }

    public boolean isFull(){
        return N == a.length;
    }



    public static void main(String[] argv){
        FixedCapacityStackOfStrings strs = new FixedCapacityStackOfStrings(100);

        strs.push("My");
        strs.push("name");
        strs.push("is");
        strs.push("顶级程序员不穿女装");

    }


}
