package com.kyson.chapter1.section3;

import java.util.Iterator;

/***
 * 
 * 1.3.32 Steque。一个以栈为目标的队列（或称steque），是一种支持push、pop和enqueue操作的数据类型。
 * 为这种抽象数据类型定义一份API并给出一份基于链表的实现。
 * 
 * 1.3.32 Steque. A stack-ended queue or steque is a data type that supports
 * push, pop, and enqueue. Articulate an API for this ADT. Develop a
 * linked-list-based implementation. *
 */
public class Steque<Item> implements Iterable<Item>{

	private class Node {
		Node next;
		Item item;
	}

	private Node first;
	private Node last;
	
	public void push(Item x){
		Node node = new Node();
		node.item = x;
		if (this.isEmpty()) {
			first = node;
			last = node;
		}else{
			node.next = first;
			first = node;
		}
	}
	
	public Item pop(){
		if (this.isEmpty()) {
			return null;
		}
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	public void enqueue(Item x){
		Node node = new Node();
		node.item = x;
		if (this.isEmpty()) {
			first = node;
			last = node;
		}else{
			last.next = node;
			last = node;
		}
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	
	public Iterator<Item> iterator()  
    {  
        return new StequeIterator();  
    }  
      
    private class StequeIterator implements Iterator<Item>  
    {  
        private Node current = first;  
        
        public boolean hasNext()  
        {  
            return current != null;  
        }  
          
        public Item next()  
        {  
            Item x = current.item;  
            current = current.next;  
            return x;  
        }

		public void remove() {
			// TODO Auto-generated method stub
			
		}  
    } 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Steque<String> stringSteque1 = new Steque<String>();
		stringSteque1.enqueue("我");
		stringSteque1.enqueue("的");
		stringSteque1.enqueue("名字");
		stringSteque1.enqueue("叫顶级程序员不穿女装");
		stringSteque1.enqueue("微博:https://m.weibo.cn/p/1005056186766482");
		
		for (String string : stringSteque1) {
			System.out.println(string);
		}
		
		Steque<String> stringSteque2 = new Steque<String>();
		stringSteque2.push("我");
		stringSteque2.push("的");
		stringSteque2.push("名字");
		stringSteque2.push("叫顶级程序员不穿女装");
		stringSteque2.push("微博:https://m.weibo.cn/p/1005056186766482");
		
		for (String string : stringSteque2) {
			System.out.println(string);
		}
		
	}

}
