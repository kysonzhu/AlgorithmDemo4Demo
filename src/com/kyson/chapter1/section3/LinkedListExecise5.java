package com.kyson.chapter1.section3;

/***
 * 1.3.25
 * 编写一个方法insertAfter()，接受两个链表结点作为参数，将第二结点插入链表并使之成为第一个结点的后续结点（如果两个参数为空则什么也不做）。
 * 
 * 1.3.25 1.3.25 Write a method insertAfter() that takes two linked-list Node
 * arguments and inserts the second after the first on its list (and does
 * nothing if either argument is null). *
 */
public class LinkedListExecise5<Item> {

	private static class Node<Item> {
		Node next;
		Item item;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "item:" + item;
		}
	}

	public Node<Item> insertAfter(Node<Item> targetNode, Node<Item> node,
			Node<Item> first) {
		if (targetNode == null || node == null) {
			return first;
		}
		Node<Item> current = first;
		while (current != null) {
			if (current.item.equals(targetNode.item)) {
				Node<Item> t = current.next;
				current.next = node;
				node.next = t;
				return first;
			}
			current = current.next;
		}

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 创建链表
		 * */
		Node<String> first = new Node<String>();
		Node<String> second = new Node<String>();
		Node<String> third = new Node<String>();
		Node<String> forth = new Node<String>();
		Node<String> fifth = new Node<String>();
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

		LinkedListExecise5<String> linkedListExercise5 = new LinkedListExecise5<String>();
		Node targetNode = second;
		System.out.println("即将移除节点:" + targetNode + "之后的节点");
		Node<String> insertedNode = new Node<String>();
		insertedNode.item = "天天开心笑哈哈";
		Node resultNode = linkedListExercise5.insertAfter(targetNode,
				insertedNode, first);

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
