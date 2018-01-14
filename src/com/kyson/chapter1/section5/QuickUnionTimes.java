package com.kyson.chapter1.section5;

public class QuickUnionTimes {
    private int[] id;     // access to component id (site indexed)
    private int count;    // number of components
    //数组访问次数
    int eachDoUnionArrayAccessTimes = 0;

    public QuickUnionTimes(int N){
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int find(int p)
    {
        // Find component name.
        while (p != id[p]) {
            p = id[p];
            eachDoUnionArrayAccessTimes += 2;
        }
        eachDoUnionArrayAccessTimes++;
        return p;
    }

    public void union(int p, int q)
    {  // Give p and q the same root.
        boolean printDetail = true;
        if (printDetail) {
            eachDoUnionArrayAccessTimes = 0;
            System.out.println("开始联通分量"+p+"和"+q);
        }
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        id[pRoot] = qRoot;
        eachDoUnionArrayAccessTimes++;
        count--;

        /************************/
        if (printDetail) {
            /***
             * 以下代码输出数组元素
             */
            System.out.print("id:{");
            for (int i = 0; i < id.length; i++) {
                if (i == id.length - 1) {
                    System.out.print(id[i]);
                } else {
                    System.out.print(id[i] + ",");
                }
            }
            System.out.print("}");
            System.out.println("");
        }
        System.out.println("数组访问的次数:"+eachDoUnionArrayAccessTimes);
    }

    public static void main(String[] args){
        QuickUnionTimes find = new QuickUnionTimes(10);
        find.union(9,0);
        find.union(3,4);
        find.union(5,8);
        find.union(7,2);
        find.union(2,1);
        find.union(5,7);
        find.union(0,3);
        find.union(4,2);
    }
}
