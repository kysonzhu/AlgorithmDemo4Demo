package com.kyson.chapter1.section3;

import java.util.Iterator;

/*
*
* 1.3.33 Deque。一个双向队列(或者称为deque)和栈或队列类似，但它同时支持在两端添加或删除元素。Deque能够存储一组元素并支持如下API。
编写一个使用双向链表实现这份API的Deque类。以及一个使用动态数据组调整实现这份API的ResizingArrayDeque类。
1.3.33 Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or a queue but supports adding and
removing items at both ends. A deque stores a collec- tion of items and supports the following API: Write a class
Deque that uses a doubly-linked list to implement this API and a class ResizingArrayDeque that uses a resizing array.
 * */
public class Practise_01_03_33 {

    public static class Deque<Item> implements Iterable<Item> {

        private Item[] a;

        private int head = 1;
        private int tail = 1;

        public boolean isEmpty() {
            return head == tail;
        }

        public Deque() {
            a = (Item[]) (new Object[2]);
        }

        public int size() {
            return tail - head;
        }

        public void pushLeft(Item item) {
            if (head == 0) {
                resize(3 * size());
            }
            a[--head] = item;
        }

        private void resize(int max) {
            if (max < 3) {
                max = 3;
            }
            Item tmp[] = (Item[]) new Object[max];
            int j = max / 3;

            for (int i = head; i < tail; i++) {
                tmp[j++] = a[i];
            }
            a = tmp;
            head = max / 3;
            tail = j;
        }

        public void pushRight(Item item) {
            if (tail == a.length) {
                resize(3 * size());
            }
            a[tail++] = item;
        }

        public Item popLeft() {
            if (isEmpty()) {
                return null;
            }
            if (size() * 6 < a.length) {
                resize(size() * 3);
            }
            return a[head++];
        }

        public Item popRight() {
            if (isEmpty()) {
                return null;
            }
            if (size() * 6 < a.length) {
                resize(size() * 3);
            }
            return a[--tail];
        }

        public Iterator<Item> iterator() {
            return new DequeIterator();
        }

        private class DequeIterator implements Iterator<Item> {

            private int index = head;

            public boolean hasNext() {
                return index < tail;
            }

            public Item next() {
                Item x = a[index++];
                return x;
            }

            public void remove() {

            }
        }

        public static void main(String[] args) {
            Deque<String> deque = new Deque<String>();
            deque.pushRight("To");
            deque.pushRight("Be");
            deque.pushRight("or");
            deque.pushRight("Not");
            deque.pushRight("to");

            for (String string : deque) {
                System.out.println(string);
            }
            System.out.println("1===========================");

            deque.popLeft();

            for (String string : deque) {
                System.out.println(string);
            }

            System.out.println("2===========================");

            Deque<String> deque1 = new Deque<String>();
            deque1.pushLeft("To");
            deque1.pushLeft("Be");
            deque1.pushLeft("or");
            deque1.pushLeft("Not");
            deque1.pushLeft("to");

            for (String string1 : deque1) {
                System.out.println(string1);
            }

            System.out.println("3===========================");
            deque1.popRight();

            for (String string : deque1) {
                System.out.println(string);
            }

        }

    }

}
