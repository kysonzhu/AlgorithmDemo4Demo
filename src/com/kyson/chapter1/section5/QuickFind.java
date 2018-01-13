package com.kyson.chapter1.section5;

/***
 * 1.5.1 使用 quick-find 算法处理序列 9-0 3-4 5-8 7-2 2-1 5-7 0-3 4-2 。对于输入的每一
 * 对整数，给出
 * id[] 数组的内容和访问数组的次数。

 1.5.1 Show the contents of the id[] array and the number of times the ar-
 ray is accessed for each input pair when you use quick-find for the sequence
 9-0 3-4 5-8 7-2 2-1 5-7 0-3 4-2.
 */


public class QuickFind {
    private int[] id;     // access to component id (site indexed)
    private int count;    // number of components

    public QuickFind(int N){
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {  // Put p and q into the same component.
        int pID = find(p);
        int qID = find(q);
        // Nothing to do if p and q are already in the same component.
        if (pID == qID) return;
        // Rename p’s component to q’s name.
        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }

    public static void main(String[] args){
        QuickFind find = new QuickFind(10);
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
