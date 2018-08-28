package com.kyson.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

/*
*
*1.3.30 编写一个函数，接受一条链表的首结点作为参数，（破坏性地）将链表反转并返回结果链表的首结点。
* */
public class Practise_01_03_30 {


    public static class LinkedList<Item> {

        public static class Node<Item> {
            Node<Item> next;
            Item item;
        }

        public Node reverse(Node first)
        {
            if (first == null) return null;
            if (first.next == null) return first;
            Node second = first.next;
            Node rest = reverse(second);
            second.next = first;
            first.next  = null;
            return rest;
        }

        public static void main(String[] args) {

            Node<String> first = new Node<>();
            first.item = "To";

            Node<String> second = new Node<>();
            second.item = "Be";

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


            LinkedList linkedList = new LinkedList();
            Node reset = linkedList.reverse(first);

            for (Node x = reset; x != null;x = x.next)
            {
                StdOut.println(x.item);
            }
        }


    }


}
