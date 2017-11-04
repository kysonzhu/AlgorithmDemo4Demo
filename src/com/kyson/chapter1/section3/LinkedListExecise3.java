package com.kyson.chapter1.section3;

/****
 * 
 * 1.3.21
 * 编写一个方法find()，接受一条链表和一个字符串key作为参数。如果链表中的某个结点的item域的值为key，则方法返回true，否则返回false。
 * 
 * 1.3.21 Write a method find() that takes a linked list and a string key as
 * arguments and returns true if some node in the list has key as its item
 * field, false otherwise.
 * 
 * 
 * 
 */
public class LinkedListExecise3 {

	private static class Node {
		Node next;
		String item;
	}

	public boolean find(Node first, String key) {
		if (first == null)
			return false;
		Node current = first;
		while (current != null) {
			if (current.item.equals(key)) {
				return true;
			}
			current = current.next;
		}

		return false;
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
		first.item = "我的";
		first.next = second;
		second.item = "名字";
		second.next = third;
		third.item = "叫";
		third.next = forth;
		forth.item = "顶级程序员不穿女装";
		forth.next = fifth;
		fifth.item = "微博:https://m.weibo.cn/p/1005056186766482";
		fifth.next = null;

		String targetString = "微博:https://m.weibo.cn/p/1005056186766482";
		LinkedListExecise3 linkedListExecise3 = new LinkedListExecise3();
		boolean find = linkedListExecise3.find(first, targetString);
		System.out.println("查找字符串" + targetString + ":" + find);

	}

}
