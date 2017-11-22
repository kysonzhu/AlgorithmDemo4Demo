package com.kyson.chapter1.section3;

import java.util.Iterator;

import com.kyson.chapter1.section3.RandomQueue.RandomQueueIterator;

import edu.princeton.cs.algs4.StdRandom;

/***
 * 1.3.38 删除第 k 个元素。 实现一个类并支持下表的 API:
 * 首先用数组实现该数据类型，然后用链表实现该数据类型。 1.3.38 Delete
 * kth element. Implement a class that supports the following API: First,
 * develop an implementation that uses an array implementation, and then develop
 * one that uses a linked-list implementation. Note: the algorithms and data
 * structures that we introduce in Chapter 3 make it possible to develop an
 * implementation that can guarantee that both insert() and delete() take time
 * prortional to the logarithm of the number of items in the queue—see Exercise
 * 3.5.27.
 *
 */
public class GeneralizedQueue<Item> implements Iterable<Item> {

	private Item[] a;
	private int N;
	
	public GeneralizedQueue(){
		N = 0;
		a = (Item[]) new Object[1];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public void insert(Item x){
		if (N == a.length) {
			resize(N * 2);
		}
		a[N++] = x;
	}
	
	public Item delete(int k){
		if (k > N || k < 0) {
			return null;
		}
		
		if (N == a.length / 4) {
			resize(a.length / 2);
		}
		Item target = a[k];
		Item[] temp = (Item[])(new Object[N]);
		for (int i = 0; i < N; i++) {
			if (i < k) {
				temp[i] = a[i];
			}else {
				temp[i] = a[ i+ 1];
			}
			
		}
		a = temp;
		a[--N] = null;
		return target;
	}
	
	private void resize(int max){
		Item[] temp = (Item[])(new Object[max]);
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new GeneralizedQueueIterator();
	}
	
	
	public class GeneralizedQueueIterator implements Iterator<Item>{

		private Item[] temp;
		private int index ;
		
		public GeneralizedQueueIterator(){
			temp = (Item[])new Object[N];
			for (int i = 0; i < N; i++)
                temp[i] = a[i];
			
			index = 0;
		}
		
		public boolean hasNext() {
			return index < N;
		}

		public Item next() {
			// TODO Auto-generated method stub
			return temp[index++];
		}

		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		GeneralizedQueue<String> queue = new GeneralizedQueue<String>();
		queue.insert("我");
		queue.insert("的");
		queue.insert("名字");
		queue.insert("叫顶级程序员不穿女装");
		queue.insert("微博:https://m.weibo.cn/p/1005056186766482");
		
		queue.delete(0);
		queue.delete(2);

		for (String string : queue) {
			System.out.println(string);
		}
		
	}

}
