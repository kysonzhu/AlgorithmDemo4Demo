package com.kyson.chapter1.section3;

/*
*1.3.48 双向队列与栈。用一个双向队列实现两个栈，保证每个栈操作只需要常数次的双向队列操作。
* （请见练习 1.3.33）**

----
 1.3.48 Two stacks with a deque. Implement two stacks with a single deque so
* that each operation takes a constant number of deque operations
 * (see Exercise 1.3.33).**
* */
public class Practise_01_03_48 {

    public static class  Stack<Item> {
        private int N = 0;
        private Node topNode = null;
        private class Node {
            Item item;
            Node next;
        }

        private Practise_01_03_33.Deque<Item> deque;


        public void push(Item item) {
            if (deque == null) {
                deque = new Practise_01_03_33.Deque<Item>();
            }
            deque.pushRight(item);
        }

        public Item pop() {
            return deque.popRight();
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }

        public int size() {
            return deque.size();
        }

        public static void main(String[] args) {
            Stack<String> stack = new Stack();
            stack.push("I");
            stack.push("am");
            stack.push("Kyson");
            stack.push("You");
            stack.push("are");

            System.out.println(stack.pop());
            System.out.println("size:" + stack.size());

            System.out.println(stack.pop());
            System.out.println("size:" + stack.size());

            System.out.println(stack.pop());
            System.out.println("size:" + stack.size());


            System.out.println(stack.pop());
            System.out.println("size:" + stack.size());

            System.out.println(stack.pop());
            System.out.println("size:" + stack.size());

        }
    }

}
