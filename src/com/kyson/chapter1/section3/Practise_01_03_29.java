package com.kyson.chapter1.section3;

/*
*
*1.3.29 用环形链表实现Queue。环形链表也是一条链表，只是没有任何结点链接为空，且只要链表非空
* 则last.next的值就为first。只能使用一个Node类型的实例变量（last）。

1.3.29 Write a Queue implementation that uses a circular linkedlist,which is
the same as a linked list except that no links are null and the value of
last.next is first when- ever the list is not empty. Keep only one Node
instance variable (last).
* */
public class Practise_01_03_29 {

    public static class Queue<Item> {

        public static class Node<Item> {
            Node<Item> next;
            Item item;
        }

        private Node<Item> first;

        public void enqueue(Item x) {
            Node a = new Node();
            a.next = first.next;
            a.item = x;
            first.next = a;
        }

        public Item dequeue() {
            Node<Item> a = first;
            first.item = a.next.item;
            first.next = a.next;
            return a.item;
        }


        public static void main(String[] args) {

        }



    }


}
