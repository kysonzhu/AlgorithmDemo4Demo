package com.kyson.chapter1.section4;

import java.util.Arrays;

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

	private static class IndexPath {
		int row;
		int column;
	}
	
	private IndexPath miniMumIndexPathOfItem(int[][] matrix,IndexPath indexPath){
		IndexPath resultItem = new IndexPath();
		resultItem.column = indexPath.column;
		resultItem.row = indexPath.row;

		int currentItem = matrix[indexPath.row][indexPath.column];
		int left  = matrix[indexPath.row][(indexPath.column - 1) >= 0 ? (indexPath.column - 1) : indexPath.column  ];
		int right = matrix[indexPath.row][(indexPath.column + 1) <= matrix.length ? (indexPath.column + 1) : indexPath.column  ];
		int top    = matrix[(indexPath.row - 1 ) >= 0 ? (indexPath.row - 1 ) : indexPath.row][indexPath.column];
		int bottom = matrix[(indexPath.row + 1 ) <= matrix.length ? (indexPath.row + 1 ) : indexPath.row][indexPath.column];

		int[] rounder = {left,right,top,bottom,currentItem};
		Arrays.sort(rounder);
		if (rounder[0] == currentItem){
			System.out.print("row:"+resultItem.row + "column:" + resultItem.column);
			return resultItem;
		}else if (rounder[0] == left){
			resultItem.column = (indexPath.column - 1);
			miniMumIndexPathOfItem(matrix,resultItem);
		}else if (rounder[0] == right){
			resultItem.column = (indexPath.column + 1);
			miniMumIndexPathOfItem(matrix,resultItem);
		}else if (rounder[0] == top) {
			resultItem.row = (indexPath.row - 1);
			miniMumIndexPathOfItem(matrix,resultItem);
		}else if (rounder[0] == bottom) {
			resultItem.row = (indexPath.row + 1);
			miniMumIndexPathOfItem(matrix,resultItem);
		}else{

		}
		return resultItem;
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

	

	public static void main(String[] args) {
		int[][] matrix = { 
				{ 11,  2,  3,  4, 102 }, 
				{ 53,  6,  7, 18, 101 },
				{ 12, 11, 10, 89, 100 }, 
				{ 14,  1,  8,  5,   0 },
				{ 114,51, 58, 55,  99 }
				};
		int middleRow = matrix.length / 2;
		int[] row = matrix[middleRow];
		int index = miniumOfArray(row);
		MatrixLocalMinimum localMinimum = new MatrixLocalMinimum();
		IndexPath indexPath = new IndexPath();
		indexPath.row = middleRow;
		indexPath.column = index;
		IndexPath resultIndexPath = localMinimum.miniMumIndexPathOfItem(matrix,indexPath);
	}

}
