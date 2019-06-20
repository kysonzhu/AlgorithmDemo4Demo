package com.kyson.chapter1.section3;

/*

1.3.49 栈与队列。用三个栈实现一个队列，保证每个队列操作（在最坏情况下）都只需要常数次的栈操作。

1.3.49 Queue with three stacks. Implement a queue with three stacks so that
each queue operation takes a constant (worst-case) number of stack operations.
Warning : high degree of difficulty.

* */
public class Practise_01_03_49 {

    public static class  Queue<Item> {
        private Stack<Item> stack1;
        private Stack stack2;
        private Stack<Item> stack3;

        private class Node {
            Item item;
            Node next;
        }


        public Queue() {
            stack1 = new Stack();
            stack2 = stack1;
        }


        public void equeue(Item item) {
            stack3 = new Stack();
            stack3.push(item);
            stack2.push(stack3);
            stack3 = new Stack();
            stack2.push(stack3);
            stack2 = stack3;

        }

        public Item deque() {
            Item popedItem = null;
            stack1.pop();
            stack3 = stack1;

            stack1.pop();
            stack1 = stack1;

            popedItem = stack1.pop();
            stack1 = stack3;
            return popedItem;
        }

        public boolean isEmpty() {
            return stack1.isEmpty();
        }

        public static void main(String[] args) {
            Queue queue = new Queue();
            queue.equeue("I");
            queue.equeue("am");
            queue.equeue("kyson");
            queue.equeue("who");
            queue.equeue("are");
            queue.equeue("you");
        }
    }

}
