package com.kyson.chapter1.section1;


/**
 *
 * 1.1.16 给出 exR1(6) 的返回值:
 *
 * 1.1.16 Give the value of exR1(6):
 *
 * public static String exR1(int n)
 * {
 *    if (n <= 0) return "";
 *    return exR1(n-3) + n + exR1(n-2) + n;
 * }
 */

public class Practise_01_01_16 {


    public static String exR1(int n)
    {
        if (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }


    public static void main(String[] args) {

        for(int i = 0 ; i < 10 ; ++i) {
            System.out.println("exr1(" + i + ")的值为"  + exR1(i) );
        }

    }
}
