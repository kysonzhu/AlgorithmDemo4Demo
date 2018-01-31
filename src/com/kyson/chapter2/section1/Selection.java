package com.kyson.chapter2.section1;

public class Selection {

    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a,int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++){
            if (less(a[i],a[i - 1]))
                return false;
        }
        return true;
    }

    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++){
            int min = i;
            for (int j = i +1; j < N; j++)
                if (less(a[j],a[min])) min = j;
            exch(a,i,min);
        }

    }

    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + "");
        }
        System.out.println();
    }

    public static void main(String[] args){
        String[] a = {"E","A","S","Y","Q","U","E","S","T","I","O","N"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
