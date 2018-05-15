package com.kyson.chapter1.section1;

public class GCD {

	/**
	 * 使用2300多年前的欧几里得算法求解两数的最大公约数
	 * @param p 数一
	 * @param q 数二
	 * @return  最大公约数
	 */
	private static int gcd(int p, int q) {
	    if(q == 0) return p;
	    int r = p % q;
	    return gcd(q, r);
	}


	public static void main(String[] args)
	{
		int gcd = gcd(6,12);
		System.out.println(""+gcd);
	}

}
