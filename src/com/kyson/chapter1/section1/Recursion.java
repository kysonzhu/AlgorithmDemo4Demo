package com.kyson.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/***
 * 
 * 1.1.15 编写一个静态方法 histogram()，接受一个整型数组 a[] 和一个整数 M 为参数并返回一个大小为 M 的数组，其中第 i
 * 个元素的值为整数 i 在参数数组中出现的次数。如果 a[] 中的值均在 0 到 M-1之间，返回数组中所有元素之和应该和 a.length 相等。
 * 
 */
public class Recursion {

	/**
	 * 
	 * 1.1.15 编写一个静态方法 histogram()，接受一个整型数组 a[] 和一个整数 M 为参数并返回一个大小为 M 的数组，其中第 i
	 * 个元素的值为整数 i 在参数数组中出现的次数。如果 a[] 中的值均在 0 到 M-1之间，返回数组中所有元素之和应该和 a.length 相等。
	 */
	public static int[] histogram(int[] a, int M) {
		int[] b = new int[M];
		int n = 0;
		int m = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < a.length; j++) {
				if (i == a[j]) {
					n++;
				}
				b[i] = n;
			}
			n = 0;
		}

		for (int i = 0; i < M; i++) {
			m = m + b[i];
		}

		return b;
	}

	/**
	 * 1.1.16 给出 exR1(6) 的返回值:
	 */
	public static String exR1(int n) {
		if (n <= 0)
			return "";
		return exR1(n - 3) + n + exR1(n - 2) + n;
	}

	/***
	 * 1.1.18 请看以下递归函数: mystery(2, 25) 和 mystery(3, 11) 的返回值是多少?给定正整数 a 和
	 * b，mystery(a,b)计算的结果是什么?将代码中的 + 替换为 * 并将 return 0 改为 return 1，然后回答相同 的问题。
	 */
	public static int mystery(int a, int b) {
		if (b == 0)
			return 0;
		if (b % 2 == 0)
			return mystery(a + a, b / 2);
		return mystery(a + a, b / 2) + a;
	}

	public static int mystery1(int a, int b) {
		if (b == 0)
			return 1;
		if (b % 2 == 0)
			return mystery1(a * a, b / 2);
		return mystery1(a * a, b / 2) * a;
	}
	
	
	

	public static void main(String[] args) {

		/***
		 * 1.1.15
		 */
		System.out.println("1.1.15 的输出:");
		int a[] = { 1, 2, 3, 4, 4, 5, 6, 8, 8 };
		int[] result = histogram(a, 10);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

		/***
		 * 1.1.16
		 */
		System.out.println("1.1.16:");
		System.out.println("exR1(6)的输出：" + exR1(6));

		/***
		 * 1.1.18
		 */
		System.out.println("1.1.18:");
		System.out.println("mystery(2, 25):" + mystery(2, 25)); // 输出50
		System.out.println("mystery(3, 11):" + mystery(3, 11)); // 输出33
		System.out.println("mystery1(2, 25):" + mystery1(2, 25)); // 输出33554432
		System.out.println("mystery1(3, 11):" + mystery1(3, 11)); // 输出177147

		/***
		 * 1.1.19
		 */
		System.out.println("1.1.19");
		for (int N = 0; N < 100; N++)
			StdOut.println(N + " " + Fibonacci.F1(N));
	}

}
