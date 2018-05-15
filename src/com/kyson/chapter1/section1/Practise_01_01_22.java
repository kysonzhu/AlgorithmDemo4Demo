package com.kyson.chapter1.section1;

/*
*
* 1.1.22 使用1.1.6.4 中的 rank()递归方法重新实现 BinarySearch 并跟踪该方法的调用。每当该方
* 法被调用时，打印出它的参数 lo 和 hi 并按照递归的深度缩进。提示 :为递归方法加一个参数来保存递归
* 的深度。

1.1.22 Write a version of Binary Search that uses the recursive rank() given
on page 25 and traces the method calls. Each time the recursive method is
called, print the argument values lo and hi, indented by the depth of the
recursion. Hint: Add an argument to the recursive method that keeps track
of the depth.
* */
public class Practise_01_01_22 {

    public static int rank (int key,int[] a) {
        return rank(key,a,0,16,1);
    }

    public static int rank (int key,int[] a,int lo,int hi,int deep) {
        if (hi < lo) return -1;
        int mid = lo + (hi - lo) / 2;
        for(int i = 0 ; i < deep ; i++)
            System.out.print(" ");
        System.out.println("lo: "+lo+" hi: "+hi);
        if (key < a[mid])
            return rank (key,a,lo,mid - 1,deep + 1);
        else if (key > a[mid])
            return rank (key,a,mid + 1,hi,deep + 1);
        else
            return mid;
    }

    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        rank(10,array);
    }

}
