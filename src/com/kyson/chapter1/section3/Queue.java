package com.kyson.chapter1.section3;

import java.util.Iterator;

/***
 * 1.3.6 下面这段代码对队列q进行了什么操作？
 * 
 * 1.3.6 What does the following code fragment do to the queue q?
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
		Queue<String> stringQueue = new Queue<String>();
		stringQueue.enqueue("我");
		stringQueue.enqueue("的");
		stringQueue.enqueue("名字");
		stringQueue.enqueue("叫顶级程序员不穿女装");
		stringQueue.enqueue("微博:https://m.weibo.cn/p/1005056186766482");

		// System.out.println(stringQueue.dequeue());
		// System.out.println(stringQueue.dequeue());
		// System.out.println(stringQueue.dequeue());
		// System.out.println(stringQueue.dequeue());
		// System.out.println(stringQueue.dequeue());
		// System.out.println(stringQueue.dequeue());

		Stack<String> stack = new Stack<String>();
		while (!stringQueue.isEmpty())
			stack.push(stringQueue.dequeue());
		while (!stack.isEmpty())
			stringQueue.enqueue(stack.pop());

		System.out.println(stringQueue.dequeue());
		System.out.println(stringQueue.dequeue());
		System.out.println(stringQueue.dequeue());
		System.out.println(stringQueue.dequeue());
		System.out.println(stringQueue.dequeue());

	}

}
