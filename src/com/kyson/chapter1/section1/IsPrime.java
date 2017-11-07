package com.kyson.chapter1.section1;

/**
 * 
 * 算法面试题(1):判断一个数是否为素数 *
 */
public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean is = isPrime4(5);
		System.out.println(is +"-----");
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

	public static boolean isPrime4(int num) {
		// 两个较小数另外处理
		if (num == 2 || num == 3)
			return true;
		// 不在6的倍数两侧的一定不是质数
		if (num % 6 != 1 && num % 6 != 5)
			return false;
		int tmp = (int) Math.sqrt(num);
		// 在6的倍数两侧的也可能不是质数
		for (int i = 5; i <= tmp; i += 6)
			if (num % i == 0 || num % (i + 2) == 0)
				return false;
		// 排除所有，剩余的是质数
		return true;
	}

}

