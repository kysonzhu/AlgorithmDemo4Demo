package com.kyson.chapter1.section3;

/*
**1.3.47 可连接的队列、栈或 steque。为队列、栈或 steque（见练习 1.3.32）添加一个能够
* （破坏性地）链接两个同类对象的额外操作 catenation。**
----
**1.3.47 Catenable queues, stacks, or steques. Add an extra operation
* catenation that (destructively) concatenates two queues, stacks, or
* steques (see Exercise 1.3.32). Hint : Use a circular linked list,
* maintaining a pointer to the last item.**
* */
public class Practise_01_03_47_LinkedQueue {

    public static class LinkedQueue<Item> {
        private int N;
        private Node head;
        private Node tail;

        public LinkedQueue() {

        }

        private class Node {
            Item item;
            Node next;
        }

        public boolean isEmpty() {
            if (head == null)
                return true;
            return false;
        }

        public int size() {
            return N;
        }

        public void enqueue(Item item) {
            Node oldLast = tail;
            tail = new Node();
            tail.item = item;
            tail.next = null;
            if (this.isEmpty()) {
                head = tail;
            } else {
                oldLast.next = tail;
            }
            N++;
        }

        public Item dequeue() {
            Item item = head.item;
            head = head.next;
            if (this.isEmpty()) {
                tail = null;
            }
            N--;
            return item;
        }

        public void catenation(LinkedQueue<Item> q) {
            if (isEmpty()) {
                head = q.head;
                tail = q.tail;
                N = q.size();
            }
            else if (!q.isEmpty()) {
                tail.next = q.head;
                tail = q.tail;
                N += q.size();
            }
        }

        public static void main(String[] args) {
            LinkedQueue queue = new LinkedQueue();
            queue.enqueue("I");
            queue.enqueue("am");
            queue.enqueue("Kyson");

            LinkedQueue queue2 = new LinkedQueue();
            queue2.enqueue("You");
            queue2.enqueue("are");
            queue2.enqueue("weiwei");

            queue.catenation(queue2);

            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());

        }
    }

}
