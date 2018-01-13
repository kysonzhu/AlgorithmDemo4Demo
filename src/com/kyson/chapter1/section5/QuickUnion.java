package com.kyson.chapter1.section5;

/**
 * 使用 quick-union 算法（请见 1.5.2.3 节代码框）完成练习 1.5.1。另外，在处理完输入的每对整
 * 数之后画出 id[] 数组表示的森林。
 * <p>
 * 1.5.2 Do Exercise 1.5.1, but use quick-union(page224).In addition, draw the
 * forest of trees represented by the id[] array after each input pair is
 * processed.
 */
public class QuickUnion {
    private int[] id;     // access to component id (site indexed)
    private int count;    // number of components

    public QuickUnion(int N){
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int find(int p)
    {
        // Find component name.
        while (p != id[p]) p = id[p];
        return p;
    }


    public void union(int p, int q)
    {  // Give p and q the same root.
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args){
        QuickUnion find = new QuickUnion(10);
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
