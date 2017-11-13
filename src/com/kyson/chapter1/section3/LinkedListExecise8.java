package com.kyson.chapter1.section3;

/**
 * 
 * 1.3.30 编写一个函数，接受一条链表的首结点作为参数，（破坏性地）将链表反转并返回结果链表的首结点。
 * 
 * 1.3.30 Write a function that takes the first Node in a linked list as
 * argument and (destructively) reverses the list, returning the first Node in
 * the result. Iterative solution : To accomplish this task, we maintain
 * references to three consecutive nodes in the linked list, reverse, first, and
 * second. At each iteration, we extract the node first from the original linked
 * list and insert it at the beginning of the reversed list. We maintain the
 * invariant that first is the first node of what’s left of the original list,
 * second is the second node of what’s left of the original list, and reverse is
 * the first node of the resulting reversed list.
 *
 */
public class LinkedListExecise8<Item> {

	private static class Node<Item> {
		Node next;
		Item item;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "item:" + item;
		}

	}
	
	
	public static Node reverseLinkedList(Node first){
		Node oldFirst = first;
		first = null;
		while(oldFirst != null){
	        Node second = oldFirst.next;  
	        oldFirst.next = first;  
	        first = oldFirst;  
	        oldFirst = second;  			
		}
		
		return first;
	}

	public static void main(String[] args) {
		/**
		 * 创建链表
		 */
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
		
		Node newFirst = reverseLinkedList(first);
		Node current = newFirst;
		while (current != null) {
			System.out.println(current.item);
			current = current.next;
		}
	}
}
