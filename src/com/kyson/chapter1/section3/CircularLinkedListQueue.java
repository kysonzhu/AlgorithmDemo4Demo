package com.kyson.chapter1.section3;

/***
 * 
 * 1.3.29 用环形链表实现Queue。环形链表也是一条链表，只是没有任何结点链接为空，且只要链表非空则last.next的值就为first。
 * 只能使用一个Node类型的实例变量（last）。
 * 
 * 1.3.29 Write a Queue implementation that uses a circular linkedlist,which is
 * the same as a linked list except that no links are null and the value of
 * last.next is first when- ever the list is not empty. Keep only one Node
 * instance variable (last). *
 */
public class CircularLinkedListQueue<Item> {

	private class Node<Item> {
		Node before;
		Item item;
		Node next;
	}

	private Node last;
	private int N;

	public void enqueue(Item item) {
		if (last == null) {
			last = new Node<Item>();
			last.item = item;
			last.next = last;
			last.before = last;
		}

		Node first = last.next;
		Node current = last.next;

	}

	public Item dequeue() {
		return null;
	}

	public int size() {
		return N;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedListQueue queue = new CircularLinkedListQueue<String>();
		queue.enqueue("1");
		System.out.println(queue);
	}

}
