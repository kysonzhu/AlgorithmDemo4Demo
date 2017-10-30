package com.kyson.chapter1.section3;

import java.util.Iterator;

/***
 * 
 * @author kyson
 *
 * @param <Item>
 */
public class Queue<Item> implements Iterable<Item> {

	private int N;

	private class Node {
		Item item;
		Node next;
	}

	private Node first;
	private Node last;

	public Queue() {

	}

	public boolean isEmpty() {
		if (first == null)
			return true;
		return false;
	}

	public int size() {
		return N;
	}

	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (this.isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		N++;
	}

	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if (this.isEmpty()) {
			last = null;
		}
		N--;
		return item;
	}

	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item> {

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		public Item next() {
			// TODO Auto-generated method stub
			return null;
		}

		public void remove() {
			// TODO Auto-generated method stub
			
		}		

	}

	public static void main(String[] args) {

	}

}
