package com.kyson.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

/*
*
*
*
* */
public class Practise_01_03_38 {


    public static class GeneralizedQueue<Item> {

        private static class GeneralizedItem<Item> {
            Item item;
            boolean hasDeleted;
        }

        private GeneralizedItem[] a ;
        private int head = 0;
        private int tail = 0;

        public GeneralizedQueue(int capacity) {
            a = new GeneralizedItem[capacity];
        }

        public void enqueue(Item item)
        {
            GeneralizedItem realItem = new GeneralizedItem();
            realItem.item = item;
            a[tail++] = realItem;
        }

        public Item dequeue() {
            if (a[head].hasDeleted == true) {
                head++;
                dequeue();
            }

            GeneralizedItem<Item> realItem = a[head++];
            return realItem.item;
        }

        public void delete(int k) {
            GeneralizedItem<Item> realItem = a[k];
            realItem.hasDeleted = true;
        }


        public static void main(String[] args) {
            GeneralizedQueue queue = new GeneralizedQueue(6);
            queue.enqueue("To");
            queue.enqueue("Be");
            queue.enqueue("Or");
            queue.enqueue("Not");

            StdOut.print(queue.dequeue());
            queue.delete(0);
            StdOut.print(queue.dequeue());
        }

    }

}
