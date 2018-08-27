package com.kyson.chapter1.section3;

/*
*
* 1.3.26 编写一个方法remove()，接受一个链表和一个字符串key作为参数，删除链表中所有item域为key
* 的结点。

1.3.26 Write a method remove() that takes a linkedlist and a string key as
arguments and removes all of the nodes in the list that have key as its item field.
*
* */
public class Practise_01_03_26 {

    public static class LinkdedList<Item> {

        private static class Node<Item> {
            Node next;
            String item;
        }

        public Node remove(Node first, String key) {
            Node newFirst = new Node();
            newFirst.next = first;

            Node current = newFirst;
            while (current.next != null) {
                if (current.next.item.equals(key)) {
                    current.next = current.next.next;
                }else {
                    current = current.next;
                }
            }
            return newFirst.next;
        }

        public static void main(String[] args) {

        }

    }
}
