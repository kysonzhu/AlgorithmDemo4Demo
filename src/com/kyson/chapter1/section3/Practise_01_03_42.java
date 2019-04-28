package com.kyson.chapter1.section3;

import java.util.Iterator;

/*
*
* 1.3.42 复制栈。为基于链表实现的栈编写一个新的构造函数，使以下代码

Stack<Item> t = new Stack<Item>(s);
得到的 t 指向栈 s 的一个新的独立的副本。

1.3.42 Copy a stack. Create a new constructor for the linked-list implementation of Stack so that

Stack<Item> t = new Stack<Item>(s);
makes t a reference to a new and independent copy of the stack s.
*
*
* */
public class Practise_01_03_42 {

    public static class  Stack<Item> implements Iterable<Item> {

        private Item[] a;
        private int N;

        public Stack(int cap) {
            a =(Item[]) new Object[cap];
        }

        public Stack(Stack<Item> s) {

            Stack<Item> xx = new Stack<Item>(1);

            a =(Item[]) new Object[1];

            Stack<Item>.StackIterator xit = s.iterator();

            while (xit.hasNext()){
                xx.push(xit.next());
            }

            Stack<Item>.StackIterator xxit = xx.iterator();
            while (xxit.hasNext()) {
                this.push(xxit.next());
            }


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

        public boolean isEmpty() {
            return N == 0;
        }

        public Item pop() {
            Item item = a[--N];
            a[N] = null;
            if (N > 0 && a.length == N / 4) {
                resize(a.length / 2);
            }
            return item;
        }

        public StackIterator iterator()
        {
            return new StackIterator();
        }

        private class StackIterator implements Iterator<Item>
        {
            private int i = N;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Item next() {
                return a[--i];
            }
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

        Stack<String> b= new Stack<>(a);

    }

}
