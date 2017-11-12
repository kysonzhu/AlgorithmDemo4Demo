package com.kyson.chapter1.section3;

import java.util.Iterator;

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
public class CircularLinkedListQueue<Item> implements Iterable<Item>{
	
	private class Node<Item> {
		Item item;
		Node<Item> next;
	}

	private Node<Item> last;
	private int N = 0;

	public void enqueue(Item item) {
		Node<Item> node = new Node<Item>();
		node.item = item;
		if (this.isEmpty()) {
			node.next = node;
			last = node;
			N++;
		}else {
			node.next = last.next;
			last.next = node;
			last = node;
			N++;
		}
	}

	public Item dequeue() {
		if (this.isEmpty()) {
			return null;
		}
		Node<Item> first = last.next;
		last.next = last.next.next;
		N--;
		return first.item;
	}

	public boolean isEmpty(){
		return last == null;
	}
	
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item>
	{
		Node<Item> current = last;
		int index = 0;
		
		public boolean hasNext() {
			if (last == null) {
				return false;
			}
			if (index < N) {
				return true;
			}
			return false;
		}

		public Item next() {
			current = current.next;
			index++;
			return current.item;
		}

		public void remove() {
			
		}
		
	}
	
	public static void main(String[] args) {
		CircularLinkedListQueue<String> queue = new CircularLinkedListQueue<String>();
		queue.enqueue("我的");
		queue.enqueue("名字");
		queue.enqueue("叫");
		queue.enqueue("顶级程序员不穿女装");
		queue.enqueue("微博:https://m.weibo.cn/p/1005056186766482");
		queue.dequeue();
		queue.dequeue();
		
		for (String string : queue) {
			System.out.println(string);
		}
		System.out.println(queue);		
	}	

}
