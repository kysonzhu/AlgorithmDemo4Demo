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
public class ResizingArrayDeque2<Item> implements Iterable<Item> {

	private Item[] a;

	private int head = 1;
	private int tail = 1;

	public boolean isEmpty() {
		return head == tail;
	}

	public ResizingArrayDeque2(int cap) {
		a = (Item[]) (new Object[cap]);
	}

	public int size() {
		return tail - head;
	}

	public void pushLeft(Item item) {
		if (head == 0) {
			resize(3 * size());
		}
		a[--head] = item;
	}

	private void resize(int max) {
		if (max < 3) {
			max = 3;
		}
		Item tmp[] = (Item[]) new Object[max];
		int j = max / 3;

		for (int i = head; i < tail; i++) {
			tmp[j++] = a[i];
		}
		a = tmp;
		head = max / 3;
		tail = j;
	}

	public void pushRight(Item item) {
		if (tail == a.length) {
			resize(3 * size());
		}
		a[tail++] = item;
	}

	public Item popLeft() {
		if (isEmpty()) {
			return null;
		}
		if (size() * 6 < a.length) {
			resize(size() * 3);
		}
		return a[head++];
	}

	public Item popRight() {
		if (isEmpty()) {
			return null;
		}
		if (size() * 6 < a.length) {
			resize(size() * 3);
		}
		return a[--tail];
	}

	public Iterator<Item> iterator() {
		return new DequeIterator();
	}

	private class DequeIterator implements Iterator<Item> {

		private int index = head;

		public boolean hasNext() {
			return index < tail;
		}

		public Item next() {
			Item x = a[index++];
			return x;
		}

		public void remove() {

		}

	}

	public static void main(String[] args) {
		ResizingArrayDeque2<String> deque = new ResizingArrayDeque2<String>(10);
		deque.pushRight("我");
		deque.pushRight("的");
		deque.pushRight("名字");
		deque.pushRight("叫顶级程序员不穿女装");
		deque.pushRight("微博:https://m.weibo.cn/p/1005056186766482");

		for (String string : deque) {
			System.out.println(string);
		}
		System.out.println("===========================");

		ResizingArrayDeque2<String> deque1 = new ResizingArrayDeque2<String>(10);
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
