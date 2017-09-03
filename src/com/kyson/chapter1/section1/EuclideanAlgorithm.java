package com.kyson.chapter1.section1;

public class EuclideanAlgorithm {

	public static void main (String[] args) {
		
		int a =gcd(105 ,  24);
		System.out.println(a + "");

	}
	
	public static int gcd(int m,int n) {
		int rem = 0;
		int M = m;
		int N = n;
		if (m < n) {
			M = n ;
			N = m ;
		}
		rem = M % N ;
		if (0 == rem)
			return N;
		System.out.println("m:"+ N + ";n:" + rem);
		return gcd(N, rem);
	}
	
}
