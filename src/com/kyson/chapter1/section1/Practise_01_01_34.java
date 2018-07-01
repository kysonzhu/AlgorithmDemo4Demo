package com.kyson.chapter1.section1;

/*
*
* 1.1.34 过滤。以下哪些任务需要（在数组中，比如）保存标准输入中的所有值？哪些可以被实现为一个过滤器且仅使用固定数量的变量和固定大小的数组（和N无关）？在每个问题中，输入都来自于标准输入且含有N个0到1的实数。

打印出最大和最小的数
打印出所有数的中位数
打印出第k小的数，k小于100
打印出所有数的平方和
打印出N个数的平均值
打印出大于平均值的数的百分比
将N个数按照升序打印
将N个数按照随机顺序打印
1.1.34 Filtering. Which of the following require saving all the values from standard input (in an array, say), and which could be implemented as a filter using only a fixed number of variables and arrays of fixed size (not dependent on N)? For each, the input comes from standard input and consists of N real numbers between 0 and 1.

Print the maximum and minimum numbers.
Print the median of the numbers.
Print the k th smallest value, for k less than 100.
Print the sum of the squares of the numbers.
Print the average of the N numbers.
Print the percentage of numbers greater than the average.
Print the N numbers in increasing order.
Print the N numbers in random order.
*
*
* */
public class Practise_01_01_34 {

    public static double maximun(double[] a){
        if (a.length < 1) {
            return Double.parseDouble(null);
        }

        double m = a[0];

        for (int i = 0 ; i < a.length ; ++i) {
            if (a[i] > m ){
                m = a[i];
            }
        }

        return m;
    }

    public static double minimum(double[] a){
        if (a.length < 1) {
            return Double.parseDouble(null);
        }

        double m = a[0];

        for (int i = 0 ; i < a.length ; ++i) {
            if (a[i] < m ){
                m = a[i];
            }
        }

        return m;
    }



    public static double middle(double[] a){
        if (a.length < 1) {
            return Double.parseDouble(null);
        }

        return a[a.length / 2];
    }


    public static void main(String[] args){
        double a[] = {0.1,0.3,0.4,0.5,0.9,0.001,0.7};
        System.out.println(maximun(a));
        System.out.println(minimum(a));
    }

}
