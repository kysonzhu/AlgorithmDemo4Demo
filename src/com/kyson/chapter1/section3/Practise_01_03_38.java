package com.kyson.chapter1.section3;


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

        public void insert(Item item)
        {
            if (tail == a.length - 1) {
                resize( a.length * 2);
            }
            GeneralizedItem realItem = new GeneralizedItem();
            realItem.item = item;
            a[tail++] = realItem;
        }

        public void delete(int k) {

            int realSize = 0;
            int realIndex = 0;

            for (int i = 0; i < a.length; i++)
            {
                GeneralizedItem<Item> tempItem = a[i];
                if (tempItem != null )
                {
                    if (tempItem.hasDeleted == false)
                    {
                        if (k == realSize) {
                            realIndex = i;
                        }
                        realSize++;
                    }
                }
            }

            if (realSize == a.length / 4)
            {
                resize( a.length / 2);
                GeneralizedItem<Item> realItem = a[k];
                realItem.hasDeleted = true;
            } else {
                GeneralizedItem<Item> realItem = a[realIndex];
                realItem.hasDeleted = true;
            }


        }

        private void resize(int size) {
            int realSize = 0;
            GeneralizedItem<Item> temp[] = new GeneralizedItem[size];

            for (int i = 0; i < a.length; i++) {
                GeneralizedItem<Item> realItem = a[i];
                if (realItem != null && realItem.hasDeleted == false) {
                    temp[realSize++] = realItem;
                }
            }
            a = temp;
            tail = realSize;
            head = 0;
        }


        public static void main(String[] args) {
            GeneralizedQueue queue = new GeneralizedQueue(2);
            queue.insert("To");
            queue.insert("Be");
            queue.insert("Or");
            queue.insert("Not");

            queue.delete(0);
            queue.delete(0);
            queue.delete(0);
        }
    }

}
