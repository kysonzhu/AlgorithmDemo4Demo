package com.kyson.chapter1.section3;

/***
 * 
 * 1.3.33 Deque。一个双向队列(或者称为deque)和栈或队列类似，但它同时支持在两端添加或删除元素。Deque能够存储一组元素并支持如下API。
 * 
 *       public class Deque<Item> implements Iterable<Item>
 *       ---------------------------------------------------
 *       
 * 编写一个使用双向链表实现这份API的Deque类。以及一个使用动态数据组调整实现这份API的ResizingArrayDeque类。 1.3.33
 * Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or a
 * queue but supports adding and removing items at both ends. A deque stores a
 * collec- tion of items and supports the following API: Write a class Deque
 * that uses a doubly-linked list to implement this API and a class
 * ResizingArrayDeque that uses a resizing array.
 *
 */
public class Deque<Item> {

	
	
	public boolean isEmpty(){
		return false;
	}

	public int size(){
		return 0;
	}
	
	public void pushLeft(Item item){
		
	}
	
	public void pushRight(Item item){
		
	}
	
	public Item popLeft(){
		return null;
	}
	
	
	public Item popRight(){
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
