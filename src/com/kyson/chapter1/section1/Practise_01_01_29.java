package com.kyson.chapter1.section1;

/*
*
* 1.1.29 等值键。为 BinarySearch 类添加一个静态方法 rank()，它接受一个键和一个整型有序数
* 组(可能存在重复键)作为参数并返回数组中小于该键的元素数量，以及一个类似的方法 count() 来
* 返回数组中等于该键的元素的数量。注意:如果 i 和 j 分别是 rank(key,a) 和 count(key,a)
* 的返回值，那么 a[i..i+j-1] 就是数组中所有和 key 相等的元素。

1.1.29 Equal keys. Add to BinarySearch a static method rank() that takes a
key and a sorted array of int values (some of which may be equal) as arguments
and returns the number of elements that are smaller than the key and a similar
method count() that returns the number of elements equal to the key. Note : If
i and j are the values returned by rank(key, a) and count(key, a) respectively ,
then a[i..i+j-1] are the values in the array that are equal to key.
* */
public class Practise_01_01_29 {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (key < a[mid]) {
                hi = mid;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else if (mid > 0 && a[mid - 1] == key) {
                hi = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static int count(int key, int[] a) {
        int lowers = rank(key, a);
        int index = lowers;

        if (index == a.length || key != a[index]) {
            return 0;
        }

        int cnt = 1;
        while ((index < a.length - 1) && (a[index] == a[index + 1])) {   //
            // 注意判断条件的先后顺序
            ++cnt;
            ++index;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 4, 4, 5, 8, 9, 10};
        int i = rank(4, a);
        int j = count(4, a);
        System.out.println(i);
        System.out.println(j);
    }
}
