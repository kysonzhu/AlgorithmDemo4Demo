package com.kyson.chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
*
* 1.1.36 乱序检查。通过实验检查表1.1.10 中的乱序代码是否能够产生预期的效果。编写一个程序ShuffleTest，接受命令行参数M 和N，将大小为M 的
* 数组打乱N 次且在每次打乱之前都将数组重新初始化为a[i] = i。打印一个M×M 的表格，对于所有的列j，行i 表示的是i 在打乱后落到j 的位置的次数。
* 数组中的所有元素的值都应该接近于N/M。

1.1.36 Empirical shuffle check. Run computational experiments to check that our shuffling code on page 32 works as
advertised. Write a program ShuffleTest that takes command-line arguments M and N, does N shuffles of an array of size
 M that is initialized with a[i] = i before each shuffle, and prints an M-by-M table such that row i gives the number
  of times i wound up in position j for all j. All entries in the array should be close to N/M.
* */
public class Practise_01_01_36 {

    public static class RandomArray {
        private int M = 0;
        private int[] a = null;

        public int[] getA() {
            return a;
        }

        public void setA(int[] a) {
            this.a = a;
        }

        public RandomArray(int M) {
            this.M = M;
            this.a = new int[M];
            for (int i = 0; i < M; i++) {
                a[i] = i;
            }
        }
    }

    public static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + StdRandom.uniform(N-i);     // between 0 and N-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static class RandomChecker {
        private double[][] matrix = null;
        public double[][] getMatrix() {
            return matrix;
        }

        private int M = 0;
        private int N = 0;

        public RandomChecker(int M, int N) {
            this.M = M;
            this.N = N;
            matrix = new double[M][];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = new double[M];
            }
        }

        public void execute() {
            for (int n = 0; n < this.N; n++) {
                RandomArray c = new RandomArray(M);
                int[] a = c.getA();
                StdRandom.shuffle(a);
                for (int k = 0; k < a.length; k++) {
                    int i = a[k];
                    int j = k;
                    matrix[i][j] += 1;
                }
            }
        }

        public void print() {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    StdOut.print(matrix[i][j] + "\t");
                }
                StdOut.print("\n");
            }
        }
    }


    public static void main(String[] args) {
        StdOut.println("Please input M: ");
        int M = StdIn.readInt();
        StdOut.println("Please input N: ");
        int N = StdIn.readInt();
        StdOut.println("Random Check: ");
        RandomChecker rc = new RandomChecker(M, N);
        rc.execute();
        rc.print();
    }
}


