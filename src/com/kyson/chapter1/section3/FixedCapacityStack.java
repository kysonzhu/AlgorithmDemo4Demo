package com.kyson.chapter1.section3;

/***
 * 1.3.1 为FixedCapacityStackOfStrings添加一个方法isFull()。
 * 1.3.1 Add a method isFull() to FixedCapacityStackOfStrings.
 */
public class FixedCapacityStack<Item> {


    private int N;
    private Item[] a;//stack entries
    public FixedCapacityStack(int cap)
    {   a = (Item[]) new Object[cap];   }
    public boolean isEmpty(){   return N == 0;   }
    public int size(){return N;}
    public void push(Item item)
    {    a[N++] = item;  }


    public Item pop()
    {   return a[--N];  }

}
