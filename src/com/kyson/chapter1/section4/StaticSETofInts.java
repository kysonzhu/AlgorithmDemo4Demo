package com.kyson.chapter1.section4;

import java.util.Arrays;

/***
 * 
 * 1.4.11 为 StaticSETofInts （请见表 1.2.15） 添加一个实例方法 howMany()，
 * 找出给定键的出现次数且在最坏情况下所需的运行时间应该和 log(N) 成正比。
 * 
 * 1.4.11 Add an instance method howMany() to StaticSETofInts(page99) that finds
 * the number of occurrences of a given key in time proportional to log N in the
 * worst case. *
 */
public class StaticSETofInts {

	private int[] a;

	public StaticSETofInts(int[] keys) {
		a = new int[keys.length];
		for (int i = 0; i < keys.length; i++)
			a[i] = keys[i]; // defensive copy
		Arrays.sort(a);
	}

	public boolean contains(int key) {
		return rank(key) != -1;
	}

	public int howMany(int key) {
		int index = rank(key);
		// 如果等于-1 ，那就说明个数为0
		if (-1 == index) {
			return 0;
		}
		int cnt = 0;
		// 再向右边查找，注意避免越界
		while (a[index++] == key) {
			cnt++;
			if (index >= a.length - 1) {
				break;
			}
		}

		return cnt;
	}

	public int rank(int key) {
		int hi = a.length;
		int lo = 0;
		int mid = 0;
		while(lo < hi){
			mid = (hi + lo) / 2;
			if (a[mid] < key) {
	            lo = mid + 1;
			}else if (a[mid] > key) {
	            hi = mid;
			}else if (mid > 0 && a[mid-1] == key) {
	            hi = mid;
			}else {
				return mid;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int[] b = { 1, 2, 3, 5, 4, 5, 6, 77, 7, 8, 8, 9, 1, 11, 22, 234, 90 };
		StaticSETofInts ints = new StaticSETofInts(b);
		// 没有这个元素
		int targetKey1 = 111;
		int cnt1 = ints.howMany(targetKey1);
		System.out.println("有" + cnt1 + "个" + targetKey1);

		// 头元素
		int targetKey2 = 1;
		int cnt2 = ints.howMany(targetKey2);
		System.out.println("有" + cnt2 + "个" + targetKey2);
		// 尾元素
		int targetKey3 = 234;
		int cnt3 = ints.howMany(targetKey3);
		System.out.println("有" + cnt3 + "个" + targetKey3);
	}
}