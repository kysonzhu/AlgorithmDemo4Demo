package com.kyson.chapter1.section5;

public class WeightedQuickUnionUFAccessTimes {
    private int[] id;
    private int[] sz;
    private int count;
    //数组访问次数
    int eachDoUnionArrayAccessTimes = 0;

    // parent link (site indexed)
    // size of component for roots (site indexed)
    // number of components
    public WeightedQuickUnionUFAccessTimes(int N) {
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
            eachDoUnionArrayAccessTimes++;
        }
        eachDoUnionArrayAccessTimes++;
        return p;
    }

    public void union(int p, int q) {
        boolean printDetail = true;
        if (printDetail) {
            eachDoUnionArrayAccessTimes = 0;
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
        }
        System.out.println("数组访问的次数:"+eachDoUnionArrayAccessTimes);
    }

    public static void main(String[] args) {
        WeightedQuickUnionUFAccessTimes quickUnionUF = new WeightedQuickUnionUFAccessTimes(10);
        quickUnionUF.union(9,0);
        quickUnionUF.union(3,4);
        quickUnionUF.union(5,8);
        quickUnionUF.union(7,2);
        quickUnionUF.union(2,1);
        quickUnionUF.union(5,7);
        quickUnionUF.union(0,3);
        quickUnionUF.union(4,2);
    }
}
