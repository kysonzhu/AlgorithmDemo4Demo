package com.kyson.chapter1.section3;

/*

1.3.49 栈与队列。用三个栈实现一个队列，保证每个队列操作（在最坏情况下）都只需要常数次的栈操作。

1.3.49 Queue with three stacks. Implement a queue with three stacks so that
each queue operation takes a constant (worst-case) number of stack operations.
Warning : high degree of difficulty.

* */
import java.util.Iterator;

public class Practise_01_03_50 {
    public static class Stack<Item> implements Iterable<Item>
    {
        private int N;
        private Node first;
        private int pushPopCount;

        private class Node {
            Item item;
            Node next;
        }

        public Stack() {
        }

        public Stack(Stack s)
        {
            Node right=new Node();
            Node oldright;
            for(Object i:s) {
                oldright=right;
                right=new Node();
                right.item=(Item) i;
                right.next=null;
                if(isEmpty()) {
                    first=right;
                } else {
                    oldright.next=right;
                }
                N++;
            }
        }

        public boolean isEmpty() {
            return N==0;
        }

        public int size() {
            return N;
        }

        public void push(Item item) {
            Node oldfirst=first;
            first=new Node();
            first.item=item;
            first.next=oldfirst;
            N++;
            pushPopCount++;
        }

        public Item pop() {
            Item item=first.item;
            first=first.next;
            N--;
            pushPopCount++;
            return item;
        }


        public Item peek() {
            Item item=first.item;
            return item;
        }

        public void catenation(Stack s) {
            while(!s.isEmpty()) {
                this.push((Item)s.pop());
            }
        }

        public Iterator<Item> iterator() {
            return new ListIterator();
        }

        private class ListIterator implements Iterator<Item> {
            private Node current=first;
            private int originatedPushPopCount;
            public ListIterator() {
                originatedPushPopCount=pushPopCount;
            }
            public boolean hasNext() {
                return current!=null;
            }
            public void remove(){}
            public Item next()
            {
                if(originatedPushPopCount!=pushPopCount)
                    throw new java.util.ConcurrentModificationException();
                Item item=current.item;
                current=current.next;
                return item;
            }
        }
    }

    public static void main(String[] args) {
        Stack<String> s1=new Stack<String>();
        s1.push("I");
        s1.push("am");
        s1.push("kyson");
        s1.push("who");
        s1.push("are");
        s1.push("you");

        for(String item:s1) {
            System.out.println(item+" ");
            s1.push("push a element");
        }
    }

}
