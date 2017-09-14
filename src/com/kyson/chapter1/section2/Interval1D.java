package com.kyson.chapter1.section2;

public class Interval1D {
	
	private double lo;
	private double hi;
	
	public Interval1D (double lo, double hi) {
		this.hi = hi;
		this.lo = lo;
	}
	
	public double length(){
		return Math.abs(lo - hi);
	}
	
	public boolean contains(double x){
		if (lo > hi) {
			double tempDouble = lo;
			lo = hi;
			hi = tempDouble;
		}
		
		return (x > lo) && (x < hi);

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}

}
