package com.kyson.chapter1.section3;

/***
 * 
 * 1.3.31
 * 实现一个嵌套类DoubleNode用来构造双向链表，其中每个结点都含有一个指向前驱元素的引用和一个指向
 * 后续元素的引用（如果不存在则为null）。为以下任务实现若干静态方法：在头插入结点、在表尾插入结点、
 * 从表头删除结点、从表尾删除结点、在指定结点前插入新结点、在指定结点之后插入新结点、删除指定结点。
 * 
 * 1.3.31 Implement a nested class DoubleNode for building doubly-linked lists,
 * where each node contains a reference to the item preceding it and the item
 * following it in the list (null if there is no such item). Then implement
 * static methods for the following tasks: insert at the beginning, insert at
 * the end, remove from the beginning, remove from the end, insert before a
 * given node, insert after a given node, and remove a given node.
 *
 * 
 * 
 * 
 */
public class LinkedListExecise9<Item> {

	private class DoubleNode<Item> {
		DoubleNode<Item> pre;
		Item item;
		DoubleNode<Item> next;
	}
	
	private DoubleNode first;
	
	public void enqueue(){
		DoubleNode node = new DoubleNode();
		node.next = null;
		node.pre = first;
		first.next = node;
		
		first = node;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
