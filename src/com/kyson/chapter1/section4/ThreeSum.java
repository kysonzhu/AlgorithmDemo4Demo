package com.kyson.chapter1.section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSum {
	public static int count(long[] a) { // Count triples that sum to 0.
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++)
				for (int k = j + 1; k < N; k++)
					if (a[i] + a[j] + a[k] == 0)
						cnt++;
		return cnt;
	}

	public static void main(String[] args) {
		String filePathString = System.getProperty("user.dir");
		String intFileString = filePathString
				+ "/src/com/kyson/chapter1/section4/" + "5ints.txt";
		System.out.println("即将读取" + intFileString + "文件中得到的数组为：");

		In in = new In(intFileString);
		long[] a = in.readAllLongs();
		StdOut.println(count(a));
	}
}
