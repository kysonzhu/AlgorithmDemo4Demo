package com.kyson.chapter1.section3;

/**
 * 
 * 1.3.19 给出一段代码，删除链表的尾结点，其中链表的首结点为first。
 * 
 * 1.3.19 Give a code fragment that removes the last node in a linked list whose
 * first node is first.
 *
 */
public class LinkedListExercise1<Item> {

	// 节点
	private static class Node<Item> {
		Node<Item> next;
		Item item;
	}

	public void deleteLastNode(Node<Item> first) {
		if (first == null) {
			return;
		}
		//current是当前遍历到的节点
		Node<Item> current = first;
		if (current.next == null) {
			first = null;
		}
		//secondLast 倒数第二个节点
		Node<Item> secondLast = first;
		while (current.next != null) {
			//这里是引用，操作secondLast就是操作链表本身
			secondLast = current;
			current = current.next;
		}
		//这里是引用，操作secondLast就是操作链表本身
		secondLast.next = null;
	}

	public static void main(String[] args) {

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
		
		//删除尾节点之前
		System.out.println("原链表：\n-------");
		Node current1 = first;
		while (current1.next != null) {
			System.out.println(current1.item);
			current1 = current1.next;
		}
		System.out.println(current1.item);
		System.out.println("-------");

		LinkedListExercise1<String> linkedListExercise1 = new LinkedListExercise1<String>();
		//删除最后一个元素
		System.out.println("正在删除链表最后一个节点...");
		linkedListExercise1.deleteLastNode(first);
		System.out.println("删除成功");
		
		System.out.println("新链表：\n-------");
		Node current2 = first;
		while (current2.next != null) {
			System.out.println(current2.item);
			current2 = current2.next;
		}
		System.out.println(current2.item);
		System.out.println("-------");
	}

}
