package com.kyson.chapter1.section3;

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
