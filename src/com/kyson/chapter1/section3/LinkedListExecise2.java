package com.kyson.chapter1.section3;

/***
 * 1.3.20 编写一个方法delete()，接受一个int参数k，删除链表的第k个元素（如果它存在的话）。
 * 
 * 1.3.20 Write a method delete() that takes an int argument k and deletes the
 * kth element in a linked list, if it exists.
 * 
 */
public class LinkedListExecise2<Item> {

	private static class Node<Item> {
		Node next;
		Item item;
	}

	/**
	 * 
	 * @param k 第K个元素
	 * @param first 链表的首节点
	 * @return 新的链表
	 * @throws Exception 
	 */
//	public Node<Item> delete(int k, Node<Item> first) throws Exception {
//	    if (k <= 0 || first == null) return null; 
//	    
//		Node<Item> current1 = first;
//		int count = 0;
//		//先计算链表总长度
//		while (current1.next != null) {
//			current1 = current1.next;
//			count++;
//		}
//		//如果K的大小大于总长度 ，抛出异常
//		if (k >= count) {
//			throw new Exception();
//		}
//
//		Node<Item> current2 = first;
//		if (k == 0) {
//			first = first.next;
//			return first;
//		}
//		
//		int index = 0;
//		while (current2.next != null) {
//			if (index == k - 1) {
//				current2.next = current2.next.next;
//			}
//			current2 = current2.next;
//			index++;
//		}
//		return first;
//	}
	
	
	public Node<Item> delete(int k, Node<Item> first) throws Exception{
	    if (k < 0 || first == null) return null; 
	    if (k == 0) {
	    	first = first.next;
			return first;
		}
	    Node<Item> current = first;
	    while (current != null && --k != 0) {
			current = current.next;
		}
	    if (k!= 0 || current.next == null || current == null) {
	    	throw new Exception();
		}else {
		    current.next = current.next.next;
		}
	    
		return first;
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

		// 删除尾节点之前
		System.out.println("原链表：\n-------");
		Node current1 = first;
		while (current1.next != null) {
			System.out.println(current1.item);
			current1 = current1.next;
		}
		System.out.println(current1.item);
		System.out.println("-------");

		LinkedListExecise2<String> linkedListExercise2 = new LinkedListExecise2<String>();
		// 删除第一个元素
		int k = 4;
		System.out.println("正在删除链表第" + k + "个节点...");
		Node<String> resultNode = null;
		try {
			resultNode = linkedListExercise2.delete(k,first);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("删除成功");

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
