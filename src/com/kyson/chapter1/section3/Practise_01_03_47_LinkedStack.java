package com.kyson.chapter1.section3;

/*
**1.3.47 可连接的队列、栈或 steque。为队列、栈或 steque（见练习 1.3.32）添加一个能够
* （破坏性地）链接两个同类对象的额外操作 catenation。**
----
**1.3.47 Catenable queues, stacks, or steques. Add an extra operation
* catenation that (destructively) concatenates two queues, stacks, or
* steques (see Exercise 1.3.32). Hint : Use a circular linked list,
* maintaining a pointer to the last item.**
* */
public class Practise_01_03_47_LinkedStack {

    public static class  LinkedStack<Item> {
        private int N = 0;
        private Node topNode = null;
        private class Node {
            Item item;
            Node next;
        }

        public void push(Item item) {
            Node newNode = new Node();
            newNode.next = topNode;
            newNode.item = item;
            topNode = newNode;
            N++;
        }

        public Item peek() {
            Item item = topNode.item;
            return item;
        }

        public Item pop() {
            Item item = topNode.item;
            topNode = topNode.next;
            N--;
            return item;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public void catenation(LinkedStack<Item> original) {
            Node newCopy;

            if (!original.isEmpty()) {

                Node current = original.topNode;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = topNode;
                topNode = original.topNode;
                N += original.size();
            }

        }

        public static void main(String[] args) {

            LinkedStack<String> a = new LinkedStack<>();
            a.push("1");
            a.push("2");
            a.push("3");
            a.push("4");
            a.push("5");
            a.push("6");


            LinkedStack<String> b = new LinkedStack<>();
            b.push("7");
            b.push("8");
            b.push("9");
            b.push("10");
            b.push("11");
            b.push("12");

            a.catenation(b);

            System.out.println(a.pop());//12
            System.out.println(a.pop());//11
            System.out.println(a.pop());//10
            System.out.println(a.pop());//9
            System.out.println(a.pop());//8
            System.out.println(a.pop());//7
            System.out.println(a.pop());//6
            System.out.println(a.pop());//5
            System.out.println(a.pop());//4
            System.out.println(a.pop());//3
            System.out.println(a.pop());//2
            System.out.println(a.pop());//1
            System.out.println(a.pop());
        }
    }

}
