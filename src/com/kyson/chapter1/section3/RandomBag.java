package com.kyson.chapter1.section3;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.3.34 随机背包。随机背包能够存储一组元素并支持下表中的 API： 编写一个 RandomBag 类来实现这份
 * API。请注意，除了形容词随机之外，这份 API 和 Bag 的 API 是相同的，这意味着迭代应该随机访问背包 中的所有元素(对于每次迭代，所有的 N!
 * 种排列出现的可能性均相同)。 1.3.34 Random bag. A random bag stores a collection of items
 * and supports the fol- lowing API:Write a class RandomBag that implements this
 * API. Note that this API is the same as for Bag, except for the adjective
 * random, which indicates that the iteration should provide the items in random
 * order (all N ! permutations equally likely, for each iterator). Hint : Put
 * the items in an array and randomize their order in the iterator’s
 * constructor.
 */

public class RandomBag<Item> implements Iterable<Item> {

	private Item[] a = (Item[]) new Object[1];
	private int N = 0;

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void add(Item x) {
		if (N == a.length)
			resize(2 * a.length);
		a[N++] = x;
	}

	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new RandomBagIterator();
	}

	private class RandomBagIterator implements Iterator<Item> {
		private int[] seq = new int[N];
		private int index = 0;

		public RandomBagIterator() {
			for (int i = 0; i < seq.length; i++)
				seq[i] = i;
			StdRandom.shuffle(seq);
		}

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index < N;
		}

		public Item next() {
			// TODO Auto-generated method stub
			return a[seq[index++]];
		}

		public void remove() {
			// TODO Auto-generated method stub

		}
	}

	public static void main(String[] args) {
		RandomBag<String> randomBag = new RandomBag<String>();
		randomBag.add("我");
		randomBag.add("的");
		randomBag.add("名字");
		randomBag.add("叫");
		randomBag.add("顶级程序员不穿女装");
		randomBag.add("微博:https://m.weibo.cn/p/1005056186766482");

		for (String string : randomBag) {
			System.out.println(string);
		}
	}
}
