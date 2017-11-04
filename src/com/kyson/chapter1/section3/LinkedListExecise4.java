package com.kyson.chapter1.section3;

/**
 * 1.3.24 编写一个方法removeAfter()，接受一个链表结点作为参数并删除该结点的后续结点（如果参数结点或参数结点的后续结点为空则什么也不做）。
 * 
 * 1.3.24 Write a method removeAfter() that takes a linked-list Node as argument
 * and removes the node following the given one (and does nothing if the
 * argument or the next field in the argument node is null).
 * 
 */
public class LinkedListExecise4<Item> {

	private static class Node<Item> {
		Node next;
		Item item;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "item:"+item;
		}
	}

	public Node<Item> removeAfter(Node node, Node first) {
		if (first == null) {
			return null;
		}

		Node current = first;
		while (current != null) {
			if (current.item.equals(node.item)) 
			{
				if (current.next != null) 
				{
					current.next = current.next.next;
					return first;
				} else {
					return first;
				}
			}
			current = current.next;
		}

		return null;
	}

	/**
	 */
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

		LinkedListExecise4<String> linkedListExercise4 = new LinkedListExecise4<String>();
		Node targetNode = first;
		System.out.println("即将移除节点:"+targetNode+"之后的节点");
		Node resultNode = linkedListExercise4.removeAfter(targetNode, first);

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
