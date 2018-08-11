package com.kyson.chapter1.section3;

import java.util.Iterator;

/*
* 1.3.12 编写一个可迭代的Stack用例，它含有一个静态的copy()方法，接受一个字符串的栈作为参数并返回该栈的一个副本。
* 注意：这种能力是迭代器价值的一个重要体现，因为有了它我们无需改变基本 API 就能实现这种功能。

1.3.12 Write an iterable Stack client that has a static method copy() that takes a stack of
strings as argument and returns a copy of the stack. Note: This ability is a prime example
of the value of having an iterator, because it allows development of such func- tionality
 without changing the basic API.


*
* */
public class Practise_01_03_12 {

    public static class Stack<Item> implements Iterable {

        private Item[] a;
        private int N;

        public Stack(int cap) {
            a =(Item[]) new Object[cap];
        }

        public void push(Item item) {
            if (a.length ==  N) {
                resize(2 * N);
            }
            a[N++] = item;
        }

        public void resize(int max)
        {
            Item[] temp = (Item[]) new Object[max];
            for (int i = 0 ; i < N ; ++i) {
                temp[i] = a[i];
            }
            a = temp;
        }

        public Item pop() {
            Item item = a[--N];
            a[N] = null;
            if (N > 0 && a.length == N / 4) {
                resize(a.length / 2);
            }
            return item;
        }


        @Override
        public Iterator iterator() {
            return null;
        }
    }


    public static void main(String[] args)
    {
        Stack<String> a = new Stack<>(10);
        a.push("1");
        a.push("2");
        a.push("3");
        a.push("4");
        a.push("5");
        a.push("6");
        a.pop();
        a.pop();
    }

}
