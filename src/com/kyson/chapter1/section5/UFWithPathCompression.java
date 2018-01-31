package com.kyson.chapter1.section5;


/**
 * 1.5.12 使用路径压缩的 quick-union 算法。根据路径压缩修改 quick-union 算法
 * （请见 1.5.2.3 节），在 find
 * () 方法中添加一个循环来将从 p 到根节点的路径上的每个触点都连接到根节点。给出一列输入，
 * 使该方法能够产生一条长度为 4
 * 的路径。注意：该算法的所有操作的均摊成本已知为对数级别。这种改变会对性能产生怎样的影响？
 * <p>
 * 1.5.12 Quick-union with path compression. Modify quick-union (page 224) to
 * include path compression, by adding a loop to union() that links every
 * site on the paths from p and q to the roots of their trees to the root of
 * the new tree. Give a sequence of input pairs that causes this method to
 * produce a path of length 4. Note : The amortized cost per operation for
 * this algorithm is known to be logarithmic.
 */

public class UFWithPathCompression {

    private int[] id;
    private int[] sz;
    private int count;

    public UFWithPathCompression(int N){
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++ ){
            id[i] = i;
        }

        for (int j = 0; j < N; j++){
            sz[j] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p,int q){
        int i = find(p);
        int j = find(q);
        return i == j;
    }

    public int find(int p){
        while (p != id[p]){
            p = id[p];
        }
        return p;
    }

    public void union(int p,int q){
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]){
            id[p] = q;
            sz[j] += sz[i];
        }else {
            id[q] = p;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args){

    }
}