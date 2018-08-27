package com.kyson.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

/*
*
* 1.3.24 编写一个方法removeAfter()，接受一个链表结点作为参数并删除该结点的后续结点（如果参
* 数结点或参数结点的后续结点为空则什么也不做）。

1.3.24 Write a method removeAfter() that takes a linked-list Node as argument
and removes the node following the given one (and does nothing if the argument
or the next field in the argument node is null).
* */
public class Practise_01_03_24 {

    public static class LinkedList<Item> {

        private static class Node<Item> {
            Node next;
            Item item;
        }

        public void removeAfter(Node node, Node first) {
            if (first == null) return ;

            for (Node x = first; x != null;x = x.next)
            {
                if (x.item.equals(node.item))
                {
                    if (x.next !=null)
                    {
                        if (x.next.next != null) {
                            x.next = x.next.next;
                        } else  {
                            x.next = null;
                        }
                    }
                    break;
                }
            }
        }

        public static void main(String[] args)
        {
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

            LinkedList<String> linkedList = new LinkedList<>();
            linkedList.removeAfter(fifth,first);

            for (Node x = first; x != null;x = x.next)
            {
                StdOut.println(x.item);
            }

        }


    }
}
