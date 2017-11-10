package com.kyson.chapter1.section1;

/**
 * 
 * 1.1.9编写一段代码，将一个正整数 N 用二进制表示并转换为一个 String 类型的值 s。 解答:Java 有一个内置方法
 * Integer.toBinaryString(N) 专门完成这个任务，但该题的目的就是给出这个方法的其他实现方法。下面就是一个特别简洁的答案:
 * 
 * String s = ""; for (int n = N; n > 0; n /= 2) s = (n % 2) + s;
 * 
 */
public class ToBinaryStringExecise {

	public static String binaryToDecimal(int n) {
		String resultString = "";
		for (int i = 31; i >= 0; i--)
			resultString = resultString + (n >>> i & 1);
		return resultString;
	}

	public static void binaryToDecimal2(int n) {
		for (int i = 31; i >= 0; i--)
			System.out.print(n >>> i & 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resultString = binaryToDecimal(4);
		System.out.println(resultString);
	}

}

