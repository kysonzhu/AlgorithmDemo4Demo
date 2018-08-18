package com.kyson.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

/*
* 1.3.19 给出一段代码，删除链表的尾结点，其中链表的首结点为first。
1.3.19 Give a code fragment that removes the last node in a linked list whose
first node is first.
*
* */
public class Practise_01_03_19 {


    public static class LinkedList<Item> {

        private static class Node<Item> {
            Node<Item> next;
            Item item;
        }

        public Node<Item> deleteLastNode(Node<Item> first) {
            if (first == null) {
                return null;
            }

            Node<Item> current = first;
            if (current.next == null) {
                first = null;
                return first;
            }

            Node<Item> secondLast = first;
            while (current.next != null) {
                secondLast = current;
                current = current.next;
            }
            secondLast.next = null;
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
            linkedList.deleteLastNode(first);

            for (Node x = first; x != null;x = x.next)
            {
                StdOut.println(x.item);
            }

        }
    }




}
