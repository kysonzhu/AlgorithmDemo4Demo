package com.kyson.chapter1.section3;

import java.util.NoSuchElementException;

/*
*
* 1.3.14 编写一个类ResizingArrayQueueOfStrings，使用定长数组实现队列的抽象，然后扩展实
* 现，使用调整数组的方法突破大小的限制。

1.3.14 Develop a class ResizingArrayQueueOfStrings that implements the queue
abstraction with a fixed-size array, and then extend your implementation to
use array resizing to remove the size restriction.
* */
public class Practise_01_03_13 {

    public static class Queue<Item> {

        private Item[] a;
        private int head;
        private int tail;

        public Queue(int cap)
        {
            a = (Item[]) new Object[cap];
            head = 0;
            tail = 0;
        }

        private void resize(int max)
        {
            Item[] temp = (Item[]) new Object[max];
            for (int i = 0; i < tail - head ; ++i)
            {
                temp[i] = a[head + i];
            }
            a = temp;
            tail = tail - head;
            head = 0;
        }

        public void enqueue(Item x)
        {
            if (tail - head == a.length) {
                resize((tail - head) * 2);
            }
            a[tail++] = x;
        }

        public boolean isEmpty(){
            return tail - head == 0;
        }


        public Item dequeue()
        {
            if(isEmpty())
                throw new NoSuchElementException("Queue underflow");
            if ((tail - head) == a.length / 4) {
                resize(a.length / 2);
            }
            Item hd = a[head];
            a[head++] = null;
            return hd;
        }

        public int size()
        {
            return tail - head;
        }

    }


    public static void main(String[] args)
    {
        Queue a = new Queue<Integer>(10);
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        a.enqueue(4);
        a.enqueue(5);
        a.enqueue(6);
        a.enqueue(7);
        a.enqueue(8);
        a.enqueue(9);
        a.enqueue(10);
        a.enqueue(11);
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();

    }

}
