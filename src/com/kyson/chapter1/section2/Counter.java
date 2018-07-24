package com.kyson.chapter1.section2;

public class Counter {

	
	private int count;

	private final String name;
	
	public Counter(String id) {
		name = id;
	}
	
	public void increment() {
		count++;
	}
	
	public int tally() {
		return count;
	}

	
	
}
