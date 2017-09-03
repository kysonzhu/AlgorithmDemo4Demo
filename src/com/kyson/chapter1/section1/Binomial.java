package com.kyson.chapter1.section1;


public class Binomial {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		binomial(2,1,0.5,0,0);
	}
	
	public static double binomial(int N,int k, double p,int times1,int times2) {
		times1++;
		times2++;
		System.out.println("==times:"+times1+" times2:"+times2);
        if(N == 0 && k == 0)
            return 1.0;
        if(N < 0 || k < 0)
            return 0.0;
        
        return (1.0 - p) * binomial(N-1, k, p,times1,times2) + p * binomial(N-1, k-1, p,times1,times2);
    }


}
