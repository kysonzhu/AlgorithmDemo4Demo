package com.kyson.chapter1.section3;

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

	public boolean isEmpty() {
		return true;
	}

	public int size() {
		return 0;
	}

	public void enqueue(Item x) {

	}
	
	public Item dequeue(){
		
		return null;
	}

	
	public void resize(){
		
	}
	
	public Item sample(){
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
