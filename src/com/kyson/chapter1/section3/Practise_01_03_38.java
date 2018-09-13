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
        int N;

        public GeneralizedQueue(int size) {
            a = new Object[size];
        }

        public void enqueue(Item item)
        {
            GeneralizedItem realItem = new GeneralizedItem();
            realItem.item = item;

            a[N++] = realItem;
        }

        public Item dequeue() {
            GeneralizedItem realItem = a[--N];
            a[N] = null;

            return realItem.item;
        }


        public static void main(String[] args) {
            GeneralizedQueue queue = new GeneralizedQueue(6);
            queue.equals("To");
            queue.equals("Be");
            queue.equals("Or");
            queue.equals("Not");

            StdOut.print(queue.dequeue());

        }

    }

}
