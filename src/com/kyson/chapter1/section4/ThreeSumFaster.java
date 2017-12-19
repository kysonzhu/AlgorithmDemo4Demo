package com.kyson.chapter1.section4;

public class ThreeSumFaster {

	
	public int threeSumFaster(long[] a) {
		int cnt = 0;
		int len = a.length;
		for (int j = 0; j < len - 2 ; j ++) {
			for(int k = j + 1,h = len -1;k < h;){
				if (a[j] + a[k] < 0) {
					j++;
				} else if (a[j] + a[k] > 0) {
					k--;
				} else {
					j++;
					k--;
					++cnt;
				}
			}
			
		}
		return cnt;
	}
	
	
	public static void main(String[] args) {

	}

}
