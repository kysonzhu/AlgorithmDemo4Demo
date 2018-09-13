package com.kyson.chapter1.section3;

import java.util.NoSuchElementException;

/*
*
*1.3.31 实现一个嵌套类DoubleNode用来构造双向链表，其中每个结点都含有一个指向前驱元素的引用和一个指向后续元素的引用（如果不存在则为
* null）。为以下任务实现若干静态方法：在头插入结点、在表尾插入结点、从表头删除结点、从表尾删除结点、在指定结点前插入新结点、在指定结点之
* 后插入新结点、删除指定结点。

1.3.31 Implement a nested class DoubleNode for building doubly-linked lists, where each node contains a reference to
the item preceding it and the item following it in the list (null if there is no such item). Then implement static
 methods for the following tasks: insert at the beginning, insert at the end, remove from the beginning, remove from
 the end, insert before a given node, insert after a given node, and remove a given node.


* */
public class Practise_01_03_31 {

    public static class DoubleLinkedList<Item> {

        public static class DoubleNode<Item> {
            DoubleNode previous, next;
            Item item;

            //无参数的构造器
            public DoubleNode() {

            }

            //初始化全部属性的构造器
            public DoubleNode(Item data, DoubleNode prev, DoubleNode next) {
                this.item = data;
                this.previous = prev;
                this.next = next;
            }
        }

        private DoubleNode head;
        private DoubleNode tail;
        private int size;

        public boolean isEmpty() {
            return size == 0;
        }

        public DoubleNode getNodeByIndex(int index) {
            if (index < 0 || index > size - 1) {
                throw new IndexOutOfBoundsException("线性表索引越界");
            }

            if (index < size / 2) {
                DoubleNode current = head;
                for (int i = 0; i < size; i++) {
                    current = current.next;
                }
                return current;
            } else {
                DoubleNode current = tail;
                for (int i = size - 1; i > index; i--) {
                    current = current.previous;
                }
                return current;
            }
        }

        //向线性链表的表头插入一个元素
        public void addFirst(Item element) {
            linkFirst(element);
        }


        //在线性链表表头插入一个元素
        public void linkFirst(Item element) {
            DoubleNode f = head;
            DoubleNode newNode = new DoubleNode(element, null, f);
            head = newNode;
            if (f == null) {
                tail = newNode;
            } else {
                f.previous = newNode;
            }
            size++;
        }

        //在线性链表的表尾插入一个元素
        public void linkTail(Item element) {
            DoubleNode t = tail;
            DoubleNode newNode = new DoubleNode(element, t, null);
            tail = newNode;
            if (t == null) {
                head = newNode;
            } else {
                t.next = newNode;
            }
            size++;
        }

        //向线性链表的表尾插入一个元素
        public void addTail(Item element) {
            linkTail(element);
        }

        //在线性表中某个元素前面插入一个节点
        public void linkBefore(Item element, DoubleNode node) {
            DoubleNode pre = node.previous;
            DoubleNode newNode = new DoubleNode(element, pre, node);
            node.previous = newNode;
            if (pre == null) {
                head = newNode;
            } else {
                pre.next = newNode;
            }
            size++;
        }

        //删除头结点
        public void unlinkFirst(DoubleNode node) {
            DoubleNode next = node.next;
            node.item = null;
            node.next = null;
            head = next;
            if (next == null) {
                tail = null;
            } else {
                next.previous = null;
            }
            size--;
        }

        //移走线性链表的头结点
        public void removeFirst() {
            DoubleNode first = head;
            if (first == null)
                throw new NoSuchElementException("此节点不存在");
            unlinkFirst(first);
        }

        //删除尾节点
        public void unlinkLast(DoubleNode node) {
            DoubleNode pre = node.previous;
            node.item = null;
            node.previous = null;
            tail = pre;
            if (pre == null) {
                head = null;
            } else {
                pre.next = null;
            }
            size--;
        }

        //移走线性链表的尾节点
        public void removeTail() {
            DoubleNode last = tail;
            if (last == null)
                throw new NoSuchElementException("此节点不存在");
            unlinkLast(last);
        }

        //移走线性表中的任意一个节点
        public void remove(int index) {
            if (index < 0 || index > size - 1) {
                throw new IndexOutOfBoundsException("线性表越界");
            }
            unlink(getNodeByIndex(index));
        }

        //删除线性表中任意一个元素
        public void unlink(DoubleNode node) {
            DoubleNode pre = node.previous;
            DoubleNode next = node.next;
            node.item = null;
            if (pre == null) {
                head = next;
            } else {
                pre.next = next;
                node.previous = null;
            }
            if (next == null) {
                tail = pre;
            } else {
                next.previous = pre;
                node.next = null;
            }
            size--;
        }


    }
}