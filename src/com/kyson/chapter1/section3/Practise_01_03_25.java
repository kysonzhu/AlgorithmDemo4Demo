package com.kyson.chapter1.section3;

/*
*
* 1.3.25 编写一个方法insertAfter()，接受两个链表结点作为参数，将第二结点插入链表并使之成为第一
* 个结点的后续结点（如果两个参数为空则什么也不做）。

1.3.25 Write a method insertAfter() that takes two linked-list Node arguments
and inserts the second after the first on its list (and does nothing if either
argument is null).
*
* */
public class Practise_01_03_25 {

    public static class LinkedList {

        private static class Node<Item> {
            Item item;
            Node next;
        }

        public void insertAfter(Node pos, Node node)
        {
            if (node == null || pos == node)
                return;
            node.next = pos.next;
            pos.next = node;
        }

        public static void main(String[] args) {

        }
    }
}
