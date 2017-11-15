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
public class ResizingArrayDeque1<Item> implements Iterable<Item> {

	private Item[] a;
	private int N;

	public boolean isEmpty() {
		return N == 0;
	}

	public ResizingArrayDeque1(int cap) {
		a = (Item[]) (new Object[cap]);
	}

	public int size() {
		return N;
	}

	public void pushLeft(Item item) {
		Item[] temp = (Item[]) (new Object[N + 1]);
		temp[0] = item;
		for (int i = 0; i < N; i++) {
			temp[i + 1] = a[i];
		}

		a = temp;
		N++;
	}

	private void resize(int max) {
		Item[] temp = (Item[]) (new Object[max]);
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public void pushRight(Item item) {
		if (N == a.length) {
			resize(N * 2);
		}
		a[N++] = item;
	}

	public Item popLeft() {
		Item[] temp = (Item[]) (new Object[N + 1]);
		Item popedItem = a[0];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i + 1];
		}

		a = temp;
		N--;
		return popedItem;
	}

	public Item popRight() {
		Item popedItem = a[--N];
		a[N] = null;

		if (a.length == 4 * N) {
			resize(a.length / 2);
		}
		return popedItem;
	}

	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new DequeIterator();
	}

	private class DequeIterator implements Iterator<Item> {

		int index = 0;

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index != N;
		}

		public Item next() {
			// TODO Auto-generated method stub
			return a[index++];
		}

		public void remove() {
			// TODO Auto-generated method stub

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResizingArrayDeque1<String> deque = new ResizingArrayDeque1<String>(10);
		deque.pushRight("我");
		deque.pushRight("的");
		deque.pushRight("名字");
		deque.pushRight("叫顶级程序员不穿女装");
		deque.pushRight("微博:https://m.weibo.cn/p/1005056186766482");

		for (String string : deque) {
			System.out.println(string);
		}
		System.out.println("===========================");

		ResizingArrayDeque1<String> deque1 = new ResizingArrayDeque1<String>(10);
		deque1.pushLeft("我");
		deque1.pushLeft("的");
		deque1.pushLeft("名字");
		deque1.pushLeft("叫顶级程序员不穿女装");
		deque1.pushLeft("微博:https://m.weibo.cn/p/1005056186766482");

		for (String string : deque1) {
			System.out.println(string);
		}
		System.out.println("===========================");
		
		deque.popLeft();

		for (String string : deque) {
			System.out.println(string);
		}
		
		System.out.println("===========================");
		deque1.popRight();

		for (String string : deque1) {
			System.out.println(string);
		}

	}

}
