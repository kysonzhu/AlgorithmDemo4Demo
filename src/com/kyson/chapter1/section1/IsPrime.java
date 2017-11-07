package com.kyson.chapter1.section1;

/**
 * 
 * 算法面试题(1):判断一个数是否为素数 *
 */
public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/***
	 * 方法1
	 */
	public static boolean isPrime1(int N) {
		if (N < 2)
			return false;

		for (int i = 2; i < N; i++)
			if (N % i == 0)
				return false;
		return true;
	}

	/***
	 * 方法2
	 */
	public static boolean isPrime2(int N) {
		if (N < 2)
			return false;
		for (int i = 2; i < N / 2; i++)
			if (N % i == 0)
				return false;
		return true;
	}

	/***
	 * 方法3
	 */
	public static boolean isPrime3(int N) {
		if (N < 2)
			return false;

		for (int i = 2; i * i < N; i++)
			if (N % i == 0)
				return false;
		return true;
	}
	
	

}
