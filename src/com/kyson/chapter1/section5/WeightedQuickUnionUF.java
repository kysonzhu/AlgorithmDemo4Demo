package com.kyson.chapter1.section5;

/**
 * 1.5.3 使用加权 quick-union 算法（请见算法 1.5）完成练习 1.5.1 。
 * <p>
 * 1.5.3 Do Exercise 1.5.1, but use weighted quick-union (page 228).
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;

    // parent link (site indexed)
    // size of component for roots (site indexed)
    // number of components
    public WeightedQuickUnionUF(int N) {
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
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
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
    }
}
