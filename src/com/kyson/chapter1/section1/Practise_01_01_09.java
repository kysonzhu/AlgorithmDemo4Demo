package com.kyson.chapter1.section1;

public class Practise_01_01_09 {

    public static String decimalToBinary(int n) {
        String resultString = "";
        for (int i = 31; i >= 0; i--)
            resultString = resultString + (n >>> i & 1);
        return resultString;
    }

    public static void main(String[] args) {
        int N = 100;
        String s = "";
        for (int n = N; n > 0; n /= 2)
            s = (n % 2) + s;

        System.out.println(s);

        System.out.println(decimalToBinary(N));

    }


}