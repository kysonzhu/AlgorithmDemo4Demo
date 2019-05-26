package com.kyson.chapter1.section3;

/*
*1.3.41 复制队列。编写一个新的构造函数，使以下函数

Queue<Item> r = new Queue<Item>(q);
得到的 r 指向队列 q 的一个新的独立的副本。可以对 q 或者 r 进行任意入列或出列操作但他们不会互相影响。提示：从 q 中取出所有元素再将它们插入 q 和 r 。

1.3.41 Copy a queue. Create a new constructor so that

Queue<Item> r = new Queue<Item>(q);
makes r a reference to a new and independent copy of the queue q. You should be able to push and pop from either q or r without influencing the other. Hint : Delete all of the elements from q and add these elements to both q and r.


*
*
* */
public class Practise_01_03_41 {

    public static class Queue<Item> {
        private int N;

        public Queue(Queue<Item> q) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                this.enqueue(q.dequeue());
            }
        }

        public Queue() {

        }

        private class Node {
            Item item;
            Node next;
        }

        private Node first;
        private Node last;

        public boolean isEmpty() {
            if (first == null)
                return true;
            return false;
        }

        public int size() {
            return N;
        }

        public void enqueue(Item item) {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if (this.isEmpty()) {
                first = last;
            } else {
                oldLast.next = last;
            }
            N++;
        }

        public Item dequeue() {
            Item item = first.item;
            first = first.next;
            if (this.isEmpty()) {
                last = null;
            }
            N--;
            return item;
        }

        public static void main(String[] args) {
            Queue queue = new Queue();
            queue.enqueue("I");
            queue.enqueue("am");
            queue.enqueue("Kyson");

            Queue queue1 = new Queue(queue);
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                System.out.println(queue1.dequeue());
            }
        }
    }

}
