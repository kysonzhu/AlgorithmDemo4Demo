package com.kyson;

public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	public static boolean  isPrime(int N){
		for(int i = 2 ; i * i < N ; i++)
			if (N % i ==0) return false;
		return true;
	}

}
