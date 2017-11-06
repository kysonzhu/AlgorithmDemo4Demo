package com.kyson.chapter1.section3;

/***
 * 1.3.27 编写一个方法max()，接受一个链表的首结点作为参数，返回链表中键最大的节点的值。假设所有键均为正整数，如果链表为空则返回0。
 * 
 * 1.3.27 Write a method max() that takes a reference to the first node in a
 * linkedlist as argument and returns the value of the maximum key in the list.
 * Assume that all keys are positive integers, and return 0 if the list is
 * empty.
 * 
 */
public class LinkedListExecise7 {

	private static class Node {
		Node next;
		Integer item;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "item:" + item;
		}

	}

	public Integer max(Node first) {
		if (null == first) {
			return 0;
		}

		if (first.next == null) {
			return first.item;
		}

		Node current = first;
		Integer max = current.item;
		while (current != null) {
			if (current.item > max) {
				max = current.item;
			}
			current = current.next;
		}

		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 创建链表
		 * */
		Node first = new Node();
		Node second = new Node();
		Node third = new Node();
		Node forth = new Node();
		Node fifth = new Node();
		first.item = 1;
		second.item = 3;
		third.item = 999;
		forth.item = 33;
		fifth.item = 21;

		first.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = null;

		System.out.println("原链表：\n-------");
		Node current1 = first;
		while (current1.next != null) {
			System.out.println(current1.item);
			current1 = current1.next;
		}
		System.out.println(current1.item);
		System.out.println("-------");

		System.out.println("正在求最大值...");
		LinkedListExecise7 linkedListExercise7 = new LinkedListExecise7();
		Integer result = linkedListExercise7.max(first);
		System.out.println("result:" + result);
	}
}
