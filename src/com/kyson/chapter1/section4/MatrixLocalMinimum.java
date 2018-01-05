package com.kyson.chapter1.section4;

/**
 * 
 * 1.4.19 矩阵的局部最小元素。给定一个含有 N^2 个不同整数的 N×N 数组 a[]。设计一个运送时间和 N
 * 成正比的算法来找出一个局部最小元素：满足 a[i][j] < a[i+1][j]、a[i][j] < a[i][j+1]、a[i][j] <
 * a[i-1][j] 以及 a[i][j] < a[i][j-1] 的索引 i 和 j。程序运行时间在最坏情况下应该和 N 成正比。
 * 
 * 1.4.19 Local minimum of a matrix. Given an N-by-N array a[] of N 2 distinct
 * integers, design an algorithm that runs in time proportional to N to find a
 * local minimum: a pair of indices i and j such that a[i][j] < a[i+1][j],
 * a[i][j] < a[i][j+1], a[i][j] < a[i-1][j], and a[i][j] < a[i][j-1]. The
 * running time of your program should be proportional to N in the worst case.
 */
public class MatrixLocalMinimum {

	private class IndexPath {
		int row;
		int column;
	}

	/**
	 * 找出数组中的最小值的index
	 */
	private static int miniumOfArray(int[] x) {
		int indexOfMinium = 0;
		int itemOfMinium = Integer.MAX_VALUE;
		for (int i = 0; i < x.length; i++) {
			if (x[i] < itemOfMinium) {
				itemOfMinium = x[i];
				indexOfMinium = i;
			}
		}
		return indexOfMinium;
	}

	private IndexPath miniumOfMatrix(int[][] matrix, int row, int index) {
		int middleRow = matrix.length / 2;

		MatrixLocalMinimum.IndexPath path = new MatrixLocalMinimum.IndexPath();
		// 判断上面是否小
		boolean isMinimum = true;
		if (middleRow - 1 >= 0) {
			if (matrix[middleRow][index] < matrix[middleRow - 1][index]) {
				isMinimum = true;
			} else {
				isMinimum = false;
			}
		} else {
			isMinimum = true;
		}
		// 判断下面是否更小
		boolean isMinimum2 = true;
		if (middleRow + 1 <= matrix.length) {
			if (matrix[middleRow][index] < matrix[middleRow + 1][index]) {
				isMinimum2 = true;
			} else {
				isMinimum2 = false;
			}
		} else {
			isMinimum2 = true;
		}

		path.column = index;
		path.row = middleRow;
		// 分三种情况
		if (isMinimum && isMinimum2) {
			return path;
		} else if (isMinimum && !isMinimum2) {
			miniumOfMatrix2(matrix, middleRow - 1, path);
		} else {
			miniumOfMatrix2(matrix, middleRow - 1, path);
		}
		return path;
	}

	private IndexPath miniumOfMatrix2(int[][] matrix,int row,IndexPath indexPath) {
		MatrixLocalMinimum.IndexPath path = new MatrixLocalMinimum.IndexPath();		
		int[] row2 = matrix[row];
		boolean isMinimum = true;
		if (indexPath.column + 1 <= matrix.length) {
			if (row2[indexPath.column] < row2[indexPath.column + 1]) {
				isMinimum = true;
			}else{
				isMinimum = false;
			}
		}else{
			isMinimum = true;
		}
		
		boolean isMinimum2 = true;
		if (indexPath.column - 1 >= 0) {
			if (row2[indexPath.column] < row2[indexPath.column - 1]) {
				isMinimum2 = true;
			}else{
				isMinimum2 = false;
			}
		}else{
			isMinimum2 = true;
		}
		
		if (isMinimum && isMinimum2) {
			return indexPath;
		}else if (isMinimum2 && !isMinimum2) {
			miniumOfMatrix2(matrix,0,indexPath);
		}else {
			miniumOfMatrix2(matrix,0,indexPath);
		}
		
		return path;
	}

	public static void main(String[] args) {
		int[][] matrix = { 
				{ 11, 2, 3, 4, 102 }, 
				{ 53, 6, 7, 18, 101 },
				{ 12, 11, 10, 9, 100 }, 
				{ 14, 1, 8, 5, 0 },
				{ 114, 51, 58, 55, 99 }
				};
		int middleRow = matrix.length / 2;
		int[] row = matrix[middleRow];
		int index = miniumOfArray(row);
		MatrixLocalMinimum localMinimum = new MatrixLocalMinimum();
		localMinimum.miniumOfMatrix(matrix, row, index);
	}

}
