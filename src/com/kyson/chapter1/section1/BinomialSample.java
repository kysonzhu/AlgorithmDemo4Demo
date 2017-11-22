package com.kyson.chapter1.section1;

/***
 * 1.1.27 二项分布。估计用以下代码计算binomial(100, 50)将会产生的递归调用次数:
 * 将已经计算过的值保存在数组中并给出一个更好的实现。
 * 
 * 1.1.27 Binomial distribution. Estimate the number of recursive calls that
 * would be used by the code to compute binomial(100, 50). Develop a better
 * implementation that is based on saving computed values in an array.
 * 
 */
public class BinomialSample {
	/*
	 * 使用一个二维数组来存放各项二项分布的概率行代表重复N次试验，列代表发生k次，所以在下面循环条件中需要 j<=i
	 */
	public static double[][] binomial(int N, int k, double p) {
		double[][] array = new double[N + 1][k + 1];
		// 给二维数组初始化第一列，避免下面执行时出现数组下标越界
		array[0][0] = 1.0;
		for (int i = 1; i < N + 1; i++)
			array[i][0] = array[i - 1][0] * (1 - p);
		for (int i = 1; i < N + 1; i++)
			for (int j = 1; j <= i && j < k + 1; j++)
				array[i][j] = (1 - p) * array[i - 1][j] + p
						* array[i - 1][j - 1];
		return array;
	}

	public static void main(String[] args) {
		double[][] array = binomial(100, 50, 0.25);
		System.out.println(array[100][50]);
	}
}
