package com.kyson.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

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


    public static class LinkedList<Item> {

        private static class Node<Item> {
            Node next;
            Item item;
        }

        public void insertAfter(Node first,Node node) {
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
