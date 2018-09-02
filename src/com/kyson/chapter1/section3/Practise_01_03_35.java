package com.kyson.chapter1.section3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/*
*
* 1.3.35 随机队列。随机队列能够存储一组元素并支持下表中的 API。
* 编写一个 RandomQueue 类来实现这份 API。编写一个用例，使用 RandomQueue 在桥牌中发牌。
1.3.35 Random queue. A random queue stores a collection of items and supports
the following API: Write a class RandomQueue that implements this API.
Hint : Use an array representation (with resizing). To remove an item,
swap one at a random position (indexed 0 through N-1) with the one at the
last position (index N-1). Then delete and return the last ob- ject, as in
ResizingArrayStack. Write a client that deals bridge hands (13 cards each)
using RandomQueue.
 */
public class Practise_01_03_35 {

    public static class RandomQueue<Item> implements Iterable<Item> {
        private Item[] a;
        private int N;

        public RandomQueue() {
            a = (Item[]) (new Object[1]);
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
                this.resize(a.length * 2);
            }
            a[N++] = x;
        }

        public Item dequeue() {
            if (this.isEmpty()) {
                return null;
            }
            if (N == a.length / 4) {
                resize(a.length / 2);
            }
            int index = StdRandom.uniform(N);
            Item x = a[index];
            a[index] = a[--N];
            a[N] = null;
            return x;
        }

        public void resize(int max) {
            Item[] temp = (Item[]) new Object[max];
            for (int i = 0; i < N; i++) {
                temp[i] = a[i];
            }
            a = temp;
        }

        public Item sample() {
            if (this.isEmpty()) {
                return null;
            }
            int index = StdRandom.uniform(N);
            return a[index];
        }

        public Iterator<Item> iterator() {
            return new RandomQueueIterator();
        }


        public class RandomQueueIterator implements Iterator<Item> {

            private Item[] temp;
            private int index;

            public RandomQueueIterator() {
                temp = (Item[]) new Object[N];
                for (int i = 0; i < N; i++)
                    temp[i] = a[i];

                StdRandom.shuffle(temp);
                index = 0;
            }

            public boolean hasNext() {
                return index < N;
            }

            public Item next() {
                return temp[index++];
            }

            public void remove() {

            }

        }

        public static void main(String[] args) {
            RandomQueue<Integer> queue = new RandomQueue<Integer>();
            for (int i = 1; i <= 52; i++)
                queue.enqueue(i);

            for (Object object : queue) {
                System.out.println(object);
            }
        }
    }
}
