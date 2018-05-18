package com.kyson.chapter1.section1;

/*
*1.1.27 二项分布。估计用以下代码计算binomial(100, 50)将会产生的递归调用次数:
*
* 将已经计算过的值保存在数组中并给出一个更好的实现。
 * */
public class Practise_01_01_27 {


    /**
     * binomial 是二项分布的英文单词写法，带的参数中N是实验的次数，k是发生的次数，
     * p是发生一次的概率，因此假设发生一次的概率是0.5，那么题目就变成
     * binomial(100, 50,0.5)调用的次数。
     ***/
//    public static double binomial(int N, int k, double p)
//    {
//        //由于每次递归都是N-1，并且k-1，因此这种情况很难出现
//        System.out.println("====");
//        if (N == 0 && k == 0)
//            return 1.0;
//        //最终应该是会调用这个if
//        if (N < 0 || k < 0)
//            return 0.0;
//        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
//    }

    private static long COUNT = 0;
    private static double[][] M;

    private static double fasterBinomial(int N, int k, double p) {
        COUNT++;
        if (N == 0 && k == 0) {
            return 1.0;
        }
        if (N < 0 || k < 0) {
            return 0.0;
        }
        if (M[N][k] == -1) {  //将计算结果存起来，已经计算过的直接拿过来用，无需再递归计算
            M[N][k] = (1.0 - p) * fasterBinomial(N - 1, k, p) + p * fasterBinomial(N - 1, k - 1, p);
        }
        return M[N][k];
    }

    public static double binomial(int N, int k, double p) {
        M = new double[N + 1][k + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= k; j++) {
                M[i][j] = -1;
            }
        }
        return fasterBinomial(N, k, p);
    }

    public static void main(String[] args){
        double array=binomial(10,5,0.25);
        System.out.println(array);
    }

}
