package com.kyson.chapter1.section3;


/*
*1.3.38 删除第 k 个元素。实现一个类并支持下表的 API：

函数	描述
GeneralizeQueue()	创建一条空队列。
bool isEmpty()	队列是否为空。
void Insert(Item x)	添加一个元素。
Item delete(int k)	删除并返回最早插入的第 k 个元素。
首先用数组实现该数据类型，然后用链表实现该数据类型。
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
