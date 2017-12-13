package com.kyson.chapter1.section4;

import java.util.Arrays;

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
	
	public int howMany(int key)
	{
		int index = rank(key);
		//如果等于-1 ，那就说明个数为0
		if (-1 == index) {
		   return 0;
		}
		//先向左边查找，但要注意避免越界
		while (a[index] == key) {
			--index;
			if (index < 0) {
				break;
			}
		}
		int cnt = 0;
		//再向右边查找，注意避免越界
		while (a[++index] == key) {
			cnt++;
			if (index >= a.length - 1) {
				break;
			}
		}
		
		return cnt;
	}

	private int rank(int key) { // Binary search.
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) { // Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] b = {1,2,3,5,4,5,6,77,7,8,8,9,1,11,22,234,90};
		StaticSETofInts ints = new StaticSETofInts(b);
		//没有这个元素
		int targetKey1 = 111;
		int cnt1 = ints.howMany(targetKey1);
		System.out.println("有"+cnt1+"个"+targetKey1);
		
		//头元素
		int targetKey2 = 1;
		int cnt2 = ints.howMany(targetKey2);
		System.out.println("有"+cnt2+"个"+targetKey2);
		//尾元素
		int targetKey3 = 234;
		int cnt3 = ints.howMany(targetKey3);
		System.out.println("有"+cnt3+"个"+targetKey3);
	}
}