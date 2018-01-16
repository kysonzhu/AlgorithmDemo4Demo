package com.kyson.chapter1.section5;

/**
 *1.5.4 在正文的加权 quick-union 算法示例中，对于输入的每一对整数（包括对照输入和最坏情况下的输入），给出 id[] 和 sz[] 数组
 * 的内容以及访问数组的次数。

 1.5.4 Show the contents of the sz[] and id[] arrays and the number of array accesses for each input
 pair corresponding to the weighted quick-union examples in the text (both the reference input and the
 worst-case input).
 */
public class WeightedQuickUnionUFSample {
    private int[] id;
    private int[] sz;
    private int count;
    //数组访问次数
    private int eachDoUnionArrayAccessTimes = 0;
    private int eachDoSZArrayAccessTimes = 0;

    // parent link (site indexed)
    // size of component for roots (site indexed)
    // number of components
    public WeightedQuickUnionUFSample(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {  // Follow links to find a root.
        while (p != id[p]) {
            p = id[p];
            eachDoUnionArrayAccessTimes += 2;
        }
        eachDoUnionArrayAccessTimes++;
        return p;
    }

    public void union(int p, int q) {
        boolean printDetail = true;
        if (printDetail) {
            eachDoUnionArrayAccessTimes = 0;
            eachDoSZArrayAccessTimes = 0;
            System.out.println("开始联通分量"+p+"和"+q);
        }
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        // Make smaller root point to larger one.
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
        eachDoUnionArrayAccessTimes++;
        eachDoSZArrayAccessTimes += 4;

        /************************/
        if (printDetail) {
            /***
             * 以下代码输出数组元素
             */
            System.out.print("id:{");
            for (int index = 0; index < id.length; index++) {
                if (index == id.length - 1) {
                    System.out.print(id[index]);
                } else {
                    System.out.print(id[index] + ",");
                }
            }
            System.out.print("}");
            System.out.println("");

            /**
             * 输出sz
             */
            System.out.print("sz:{");
            for (int index = 0; index < sz.length; index++) {
                if (index == sz.length - 1) {
                    System.out.print(sz[index]);
                } else {
                    System.out.print(sz[index] + ",");
                }
            }
            System.out.print("}");
            System.out.println("");
        }
        System.out.println("数组id访问的次数:"+ eachDoUnionArrayAccessTimes);
        System.out.println("数组sz访问的次数:"+ eachDoSZArrayAccessTimes);
    }


    public static void main(String[] args){
        WeightedQuickUnionUFSample sample = new WeightedQuickUnionUFSample(10);
        sample.union(4,3);
        sample.union(3,8);
        sample.union(6,5);
        sample.union(9,4);
        sample.union(2,1);
        sample.union(5,0);
        sample.union(7,2);
        sample.union(6,1);
    }
}
