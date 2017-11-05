package com.kyson.chapter1.section3;

/***
 * 1.3.26 编写一个方法remove()，接受一个链表和一个字符串key作为参数，删除链表中所有item域为key的结点。
 * 
 * 1.3.26 Write a method remove() that takes a linkedlist and a string key as
 * arguments and removes all of the nodes in the list that have key as its item
 * field.
 * 
 * 
 * 
 */
public class LinkedListExecise6 {

	private static class Node {
		Node next;
		String item;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "item:" + item;
		}
	}

	public Node remove(Node first, String key) {
		// 判断链表是否为空
		if (first == null) {
			return null;
		}
		// 判断链表是否只有一个元素
		if (first.next == null && first.item.equals(key)) {
			return null;
		}

		Node current = first;
		// 找到符合条件的链表并删除它
		while (current.next != null) {
			if (current.next.item.equals(key)) {
				current.next = current.next.next;
			}
			current = current.next;
		}

		return first;
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

		LinkedListExecise6 linkedListExercise6 = new LinkedListExecise6();
		Node resultNode = linkedListExercise6.remove(first, "叫");

		System.out.println("新链表：\n-------");
		Node current2 = resultNode;
		while (current2.next != null) {
			System.out.println(current2.item);
			current2 = current2.next;
		}
		System.out.println(current2.item);
		System.out.println("-------");

	}

}
