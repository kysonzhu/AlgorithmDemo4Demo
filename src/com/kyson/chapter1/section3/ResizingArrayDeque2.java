package com.kyson.chapter1.section3;

import java.util.Iterator;

/***
 * 
 * 1.3.33 Deque。一个双向队列(或者称为deque)和栈或队列类似，但它同时支持在两端添加或删除元素。Deque能够存储一组元素并支持如下API。
 * 
 * public class Deque<Item> implements Iterable<Item>
 * ---------------------------------------------------
 * 
 * 编写一个使用双向链表实现这份API的Deque类。以及一个使用动态数据组调整实现这份API的temprrayDeque类。 1.3.33 Deque. A
 * double-ended queue or deque (pronounced “deck”) is like a stack or a queue
 * but supports adding and removing a at both ends. A deque stores a collec-
 * tion of a and supports the following API: Write a class Deque that uses a
 * doubly-linked list to implement this API and a class temprrayDeque that uses
 * a resizing array.
 * 
 */

public class ResizingArrayDeque2<Item> implements Iterable<Item>{

	private int head;
	private int tail;
	private Item[] a;
	
	public ResizingArrayDeque2(){
		a = (Item[])(new Object[2]);
		head = 0;
		tail = 0;
	}
	
	public boolean isEmpty(){
		return head == tail;
	}
	
	public int size(){
		return tail - head;
	}
	
	public void pushLeft(Item x){
		
	}
	
	public void pushRight(Item x){
		
	}
	
	public Item popLeft(){
		return null;
	}
	
	public Item popRight(){
		return null;
	}
	
	private void resize(int max){
		
	}

	public ResizingArrayDequeIterator iterator(){
		return new ResizingArrayDequeIterator();
	}
	
	private class ResizingArrayDequeIterator implements Iterator<Item>
	{

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		public Item next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


