package com.kyson.chapter1.section3;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.3.35 随机队列。随机队列能够存储一组元素并支持下表中的 API。 编写一个 RandomQueue 类来实现这份 API。编写一个用例，使用
 * RandomQueue 在桥牌中发牌。 1.3.35 Random queue. A random queue stores a collection
 * of items and supports the following API: Write a class RandomQueue that
 * implements this API. Hint : Use an array representation (with resizing). To
 * remove an item, swap one at a random position (indexed 0 through N-1) with
 * the one at the last position (index N-1). Then delete and return the last ob-
 * ject, as in ResizingArrayStack. Write a client that deals bridge hands (13
 * cards each) using RandomQueue<Card>.
 * 
 */
public class RandomQueue<Item> {

	private Item[] a;
	private int N;
	
	public RandomQueue(){
		a =(Item[])(new Object[1]);
		N = 0;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void enqueue(Item x) {
		if (N == a.length) {
			this.resize(N * 2);
		}
		a[N++] = x;
	}
	
	public Item dequeue(){
		if (this.isEmpty()) {
			return null;
		}
		StdRandom.shuffle(a);
		if (N == a.length / 4) {
			resize(N / 2);
		}
		Item x = a[--N];
		a[N] = null;
		return x;
	}

	
	public void resize(int max){
		Item[] temp = (Item[])new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public Item sample(){
		if (this.isEmpty()) {
			return null;
		}
		StdRandom.shuffle(a);
		return a[0];
	}
	
	public static void main(String[] args) {

	}

}
