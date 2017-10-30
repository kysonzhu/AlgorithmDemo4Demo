package com.kyson.chapter1.section3;

/***
 * 
 * 1.3.14 编写一个类ResizingArrayQueueOfStrings，使用定长数组实现队列的抽象，然后扩展实现，使用调整数组的方法突破大小的限制。
 * 
 * 1.3.14 Develop a class ResizingArrayQueueOfStrings that implements the queue
 * abstraction with a fixed-size array, and then extend your implementation to
 * use array resizing to remove the size restriction.
 *
 */
public class ResizingArrayQueueOfStrings {

	private int N;
	private String[] items;

	public class Node {
		String item;
		Node next;
	}

	public ResizingArrayQueueOfStrings(int cap) {
		items = new String[cap];
	}

	public void enqueue(String item) {
		if (N == items.length) {
			resize(items.length * 2);
		}
		items[N++] = item;
	}

	public String dequeue() {
		// 拷贝所有的老数组元素到新的数组，并命名为oldItems
		String[] oldItems = new String[N];
		for (int i = 0; i < N; i++) {
			oldItems[i] = items[i];
		}

		// 重新设置Stack的大小
		items[--N] = null;
		if (N == items.length / 4) {
			resize(items.length / 2);
		}
		// 获取新数组
		for (int i = 0; i < N; i++) {
			items[i] = oldItems[i + 1];
		}
		return oldItems[0];
	}

	public boolean isEmpty() {
		return true;
	}

	public int size() {
		return N;
	}

	private void resize(int max) {
		String[] tempItems = new String[max];
		for (int i = 0; i < N; i++) {
			tempItems[i] = items[i];
		}
		items = tempItems;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ResizingArrayQueueOfStrings strings = new ResizingArrayQueueOfStrings(2);
		strings.enqueue("我");
		strings.enqueue("的");
		strings.enqueue("名字");
		strings.enqueue("叫顶级程序员不穿女装");
		strings.enqueue("微博:https://m.weibo.cn/p/1005056186766482");
		
		System.out.println(strings.dequeue());
		System.out.println(strings.dequeue());
		System.out.println(strings.dequeue());
		System.out.println(strings.dequeue());
		System.out.println(strings.dequeue());
//		System.out.println(strings.dequeue());
	}

}
