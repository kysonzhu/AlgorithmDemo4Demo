package com.kyson.chapter1.section3;

public class Queue<Item> {
	
	private int N;
	
	private class Node{
		Item item;
		Node next;
	}
	
	private Node first;
	private Node last;
	
	public Queue(){
		
	}
	
	public boolean isEmpty(){
		if(first == null) return true;
		return false;
	}
	
	public int size(){
		return N;
	}
	
	public void enqueue(Item item){
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (this.isEmpty()) {
			first = last;
		}else {
			oldLast.next = last;
		}
		N++;
	}
	
	
	public Item dequeue(){
		Item item = first.item;
		first = first.next;
		if (this.isEmpty()) {
			last = null;
		}
		N--;
		return item;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
