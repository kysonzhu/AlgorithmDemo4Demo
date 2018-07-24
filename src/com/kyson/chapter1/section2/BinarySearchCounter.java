package com.kyson.chapter1.section2;

/**
 * 1.2.9 修改 BinarySearch（请见 1.1.10.1 节中的二分查找代码），使用 Counter
 * 统计在有查找中被检查的键的总数并在查找全部结束后打印该值。 提示：在 main() 中创建一个 Counter 对象并将它作为参数传递给 rank()
 * 1.2.9 Instrument BinarySearch(page47) to use a Counter to count the total
 * number of keys examined during all searches and then print the total after
 * all searches are com- plete. Hint : Create a Counter in main() and pass it as
 * an argument to rank().
 */
public class BinarySearchCounter {

	public static void main(String[] args) {
		int[] numArray = { 1, 2, 3, 4, 67, 88, 89, 101, 222, 788, 999 };
		Counter counter = new Counter("BinarySearchCounter");
		int index = rank(222, numArray, counter);
		System.out.println("index: " + index + "\ncouter:" + counter.tally() );
	}

	public static int rank(int t, int[] array, Counter counter) {
		int lo = 0;
		int hi = array.length - 1;
		int mid = (lo + hi) / 2;
		while (t != array[mid]) {
			counter.increment();
			if (t < array[mid]) {
				if (hi == mid) {
					return -1;
				}
				hi = mid;
			} else if (t > array[mid]) {
				if (lo == mid) {
					return -1;
				}
				lo = mid;
			} else {
				return mid;
			}
			mid = (lo + hi) / 2;
		}

		return mid;
	}

}
