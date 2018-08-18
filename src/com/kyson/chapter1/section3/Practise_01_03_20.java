package com.kyson.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/*
*
* 1.3.20 编写一个方法delete()，接受一个int参数k，删除链表的第k个元素（如果它存在的话）。

1.3.20 Write a method delete() that takes an int argument k and deletes
the kth element in a linked list, if it exists.
*
* */
public class Practise_01_03_20 {

    public static class LinkedList<Item> {

        private static class Node<Item> {
            Node next;
            Item item;
        }

        public Node<Item> delete(int k, Node<Item> first) {
            if (k < 0 || first == null) return null;
            if (k == 0) {
                first = first.next;
                return first;
            }
            Node<Item> current = first;
            while (current != null && --k != 0) {
                current = current.next;
            }
            if (k!= 0 || current.next == null || current == null) {
                throw new NoSuchElementException("Queue underflow");
            }else {
                current.next = current.next.next;
            }

            return first;
        }


        public static void main(String[] args)
        {
            Node<String> first = new Node<>();
            first.item = "to";

            Node<String> second = new Node<>();
            second.item = "be";

            Node<String> third = new Node<>();
            third.item = "or";

            Node<String> forth = new Node<>();
            forth.item = "not";

            Node<String> fifth = new Node<>();
            fifth.item = "to";

            Node<String> sixth = new Node<>();
            sixth.item = "be";

            first.next  = second;
            second.next = third;
            third.next  = forth;
            forth.next  = fifth;
            fifth.next  = sixth;

            LinkedList<String> linkedList = new LinkedList<>();
            linkedList.delete(3,first);

            for (Node x = first; x != null;x = x.next)
            {
                StdOut.println(x.item);
            }

        }

    }


}
