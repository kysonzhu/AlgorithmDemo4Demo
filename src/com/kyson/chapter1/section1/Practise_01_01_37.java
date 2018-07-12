package com.kyson.chapter1.section1;

/*
* 1.1.37 糟糕的打乱。假设在我们的乱序代码中你选择的是一个0 到N-1 而非i 到N-1 之间的随机整数。
* 证明得到的结果并非均匀地分布在N! 种可能性之间。用上一题中的测试检验这个版本。
1.1.37 Bad shuffling. Suppose that you choose a random integer between 0 and N-1
 in our shuffling code instead of one between i and N-1. Show that the resulting
  order is not equally likely to be one of the N! possibilities. Run the test of
  the previous exercise for this version.
*
*
* */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Practise_01_01_37 {

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


    /*
     * 糟糕的打乱
     * */
    public static class BadRandomChecker {
        private double[][] matrix = null;

        public double[][] getMatrix() {
            return matrix;
        }

        private int M = 0;
        private int N = 0;

        public BadRandomChecker(int M, int N) {
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
                shuffle(a);
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

        public static void shuffle(int[] a) {
            int N = a.length;
            for (int i = 0; i < N; i++) {
                int r = StdRandom.uniform(0,N - 1);     // between 0 and N-1
                int temp = a[i];
                a[i] = a[r];
                a[r] = temp;
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

        StdOut.println("Bad Random: ");
        BadRandomChecker br = new BadRandomChecker(M, N);
        br.execute();
        br.print();
    }
}
