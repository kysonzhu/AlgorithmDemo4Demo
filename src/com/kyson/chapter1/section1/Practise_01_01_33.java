package com.kyson.chapter1.section1;

import java.util.Arrays;

/*
 *1.1.33矩阵库。编写一个Matrix库并实现以下API


 *
 * */
public class Practise_01_01_33 {


    public static double dot(double x[], double[] y) {

        return 0.1;
    }

    public static void main(String[] args) {

        double[][] a = {{1.f, 1.f}, {2.f, 2.f}};
        double[][] b = {{1.f, 1.f}, {2.f, 2.f}};
        int N = a.length;
        double[][] c = new double[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) { // Compute dot product of row i and
                // column j.
                for (int k = 0; k < N; k++)
                    c[i][j] += a[i][k] * b[k][j];
            }
            System.out.println(Arrays.toString(c[i]));
        }


    }
}
