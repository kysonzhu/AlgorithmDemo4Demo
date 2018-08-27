package com.kyson.chapter1.section3;

/*
*
* 1.3.27 编写一个方法max()，接受一个链表的首结点作为参数，返回链表中键最大的节点的值。假设所有键
* 均为正整数，如果链表为空则返回0。

1.3.27 Write a method max() that takes a reference to the first node in a
linkedlist as argument and returns the value of the maximum key in the list.
Assume that all keys are positive integers, and return 0 if the list is empty.
* */
public class Practise_01_03_27 {

    public static class LinkdedList {

        private static class Node {
            Node next;
            Integer item;
        }

        public Integer max(Node first) {
            if (null == first) {
                return 0;
            }

            if (first.next == null) {
                return first.item;
            }

            Node current = first;
            Integer max = current.item;
            while (current != null) {
                if (current.item > max) {
                    max = current.item;
                }
                current = current.next;
            }

            return max;
        }
    }
}
