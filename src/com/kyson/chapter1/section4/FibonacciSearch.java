package com.kyson.chapter1.section4;
import java.util.Arrays;

public class FibonacciSearch {

    public static boolean fibonacciSearch(int[] a, int key) {
        Arrays.sort(a);
        int F1 = 1, F2 = 1;
        while (F2 <= a.length) {
            int temp = F2;
            F2 = F1 + F2;
            F1 = temp;
        }
        int lo = 0, hi = a.length - 1; // lo = i, hi = Fk
        while (lo <= hi) {
            int mid = lo + F2 - F1 - 1; // mid = i + Fk-2 , (Fk最小为1， 只能[0,1]
            // 所以减去1)
            if (a[mid] == key) return true;
            else if (a[mid] > key) { // [i, i+Fk-2]
                hi = lo + F2 - F1;
                F2 = F2 - F1;   //Fk = Fk-2
                F1 = F1 - F2;
            } else if (a[mid] < key) { // [i, i+Fk-2+Fk-1]
                hi = Math.min(hi, lo + F2);
                lo = lo + F2 - F1;

                int temp = F1;  //Fk = Fk-1
                F1 = F2 - F1;
                F2 = temp;

            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,55,66,777,8888,8889,9000,10000};

        boolean find = fibonacciSearch(array,6);
        if (find){
            System.out.print("找到了");
        }else {
            System.out.print("找不到");
        }
    }

}
