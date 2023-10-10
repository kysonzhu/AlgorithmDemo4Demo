package com.kyson.chapter1.section3;


import edu.princeton.cs.algs4.StdOut;
//import org.omg.CORBA.NO_IMPLEMENT;

import java.util.NoSuchElementException;

/*
*
* 1.3.21 编写一个方法find()，接受一条链表和一个字符串key作为参数。如果链表中的某个结点的item域
* 的值为key，则方法返回true，否则返回false。

1.3.21 Write a method find() that takes a linked list and a string key as
arguments and returns true if some node in the list has key as its item field,
false otherwise.
*
*
* */
public class Practise_01_03_21 {

    public static class LinkedList<Item> {

        private static class Node<Item> {
            Node next;
            Item item;
        }

        public boolean find(String key, Node<Item> first) {
            if (first == null) return false;
            boolean canFind = false;
            for (Node x = first; x != null;x = x.next)
            {
                if (x.item.equals(key))
                {
                    canFind = true;
                    break;
                }
            }

            return canFind;
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
            StdOut.println(linkedList.find("not",first));

        }

    }


}
