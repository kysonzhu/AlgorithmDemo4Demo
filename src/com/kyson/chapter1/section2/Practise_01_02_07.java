package com.kyson.chapter1.section2;

/*
*以下递归函数的返回值是什么？
 * */
public class Practise_01_02_07 {


    /*
    * 倒序字符串
    * */
    public static String mystery(String s)
    {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }

    /*
    * 字符串倒序
    * */
    public static String reverse(String s){
        char[] ch  = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = ch.length - 1; i >= 0; i--) {
            sb.append(ch[i]);
        }
        return sb.toString();
    }

    /*
    * 打印出倒序的字符串
    * */
    public static void printReverse(String s){
        int length = s.length();
        for (int i = length - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }
    }


    public static void main(String[] args){
        String resultString = mystery("12345678");
        System.out.println(resultString);


    }
}
