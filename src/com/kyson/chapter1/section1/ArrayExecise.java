package com.kyson.chapter1.section1;

import java.util.Arrays;

/**
 * 
 * @author zhujinhui
 * 
 * 
 * 1.1.30 数组练习。编写一段程序，创建一个 N×N 的布尔数组 a[][]。
 * 其中当 i 和 j 互质时(没有相同 因子)，a[i][j] 为 true，否则为 false。
 *
 */

public class ArrayExecise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean[][] resultArray = boolArray(9);
		System.out.println(Arrays.toString(resultArray));
	}
	
	
	/***
	 * 求最大公约数
	 * @param m
	 * @param n
	 * @return
	 */
	public static int gcd(int m,int n) {
		if (n == 0) 
			return m;
		
		while (m % n != 0) {
			int temp = m % n;   
            m = n;
            n = temp;
		}
		
		return n;
	}
	
	/**
	 * 两数是否互质
	 * @param m
	 * @param n
	 * @return
	 */
	public static boolean isCoprime(int m,int n) {
		if (1 == gcd(m, n) ) {
			return true;
		}
		return false;
	}
	
	
	/***
	 * 
	 * @param N
	 * @return
	 */
	public static boolean[][] boolArray(int N) {
		boolean[][] resultAry = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {				
				resultAry[i][j] = isCoprime(i,j) ? true : false;
			}
		}
		return resultAry;
	}
	

}
