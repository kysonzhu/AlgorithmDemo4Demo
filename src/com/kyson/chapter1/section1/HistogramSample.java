package com.kyson.chapter1.section1;

/***
 * 1.1.15 编写一个静态方法 histogram()，接受一个整型数组 a[] 和一个整数 M 为参数并返回一个大小为 M 的数组，其中第 i
 * 个元素的值为整数 i 在参数数组中出现的次数。如果 a[] 中的值均在 0 到 M-1之间，返回数组中所有元素之和应该和 a.length 相等。
 * 
 * 1.1.15 Write a static method histogram() that takes an array a[] of int
 * values and an integer M as arguments and returns an array of length M whose i
 * th entry is the number of times the integer i appeared in the argument array.
 * If the values in a[] are all between 0 and M–1, the sum of the values in the
 * returned array should be equal to a.length.
 *
 */
public class HistogramSample {

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

	public static int[] histogram2(int[] a, int M) {
		int[] h = new int[M];
		int N = a.length;
		for (int i = 0; i < N; i++)
			if (a[i] < M)
				h[a[i]]++;
		return h;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11, 11, 12 };
		int M = 13;
		int b[] = histogram2(a, M);
		System.out.println("调用函数后获取的数组：");
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}		
	}

}


