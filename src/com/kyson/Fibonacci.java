package com.kyson;

public class Fibonacci {
    
    
    public static long F1(int N) {
    	if (N == 0) return 0;
        if (N == 1) return 1;
    	long f = 0;
    	long g = 1;
    	for (int i = 0; i < N ; i++) {
    		f = f + g;
    		g = f - g;
    	}
    	return f;
    }
    
    public static void main(String[] args) { 
        for (int N = 0; N < 100; N++)
        	System.out.println(N + " " + F1(N));
    }
}