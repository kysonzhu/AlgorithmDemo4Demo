package com.kyson.chapter1.section1;

/*
*
* 1.1.24 给出使用欧几里得算法计算 105 和 24 的最大公约数的过程中得到的一系列 p 和 q 的值。
* 扩展该算法中的代码得到一个程序Euclid，从命令行接受两个参数，计算它们的最大公约数并打印出每
* 次调用递归方法时的两个参数。使用你的程序计算 1 111 111 和 1 234 567 的最大公约数。

1.1.24 Give the sequence of values of p and q that are computed when Euclid’s
algorithm is used to compute the greatest common divisor of 105 and 24. Extend
the code given on page 4 to develop a program Euclid that takes two integers
from the command line and computes their greatest common divisor, printing out
the two arguments for each call on the recursive method. Use your program to
compute the greatest common divisor or 1111111 and 1234567.
* */

public class Practise_01_01_24 {

    public static int gcd(int a, int b) {
        if(a < 0 || b < 0)
            return -1;
        if(a == b || a == 0)
            return b;
        if(b == 0)
            return a;
        System.out.println("a:"+ a + ";b:" + b);
        if(a < b)
            return gcd(a, b % a);
        else
            return gcd(b, a % b);
    }


    public static void main (String[] args) {
        int a =gcd(1111111 ,  1234567);
        System.out.println(a + "");
    }

}
