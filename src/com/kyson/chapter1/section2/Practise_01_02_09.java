package com.kyson.chapter1.section2;

/*
*1.2.9 修改 BinarySearch（请见 1.1.10.1 节中的二分查找代码），使用 Counter 统计在有查找中
* 被检查的键的总数并在查找全部结束后打印该值。 提示：在 main() 中创建一个 Counter 对象并将它作
* 为参数传递给 rank()

1.2.9 Instrument BinarySearch(page47) to use a Counter to count the total
number of keys examined during all searches and then print the total after
all searches are complete. Hint : Create a Counter in main() and pass it as
an argument to rank().
* */
public class Practise_01_02_09 {

    public static class Counter {
        private int count;
        private final String name;
        public Counter(String id) {
            name = id;
        }
        public void increment() {
            count++;
        }
        public int tally() {
            return count;
        }
    }

    public static int rank(int target,int[] a,Counter counter)
    {
        int hi = a.length - 1;
        int lo = 0;

        while (lo < hi){
            counter.increment();
            int mid = (hi + lo) / 2;
            if (target < a[mid]){
                hi = mid - 1;
            } else if (target > a[mid]){
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args){

        int[] numArray = { 1, 2, 3, 4, 67, 88, 89, 101, 222, 788, 999 };
        Counter counter = new Counter("tag");
        int index = rank(222, numArray, counter);
        System.out.println("index: " + index + "\ncouter:" + counter.tally());
    }



}
