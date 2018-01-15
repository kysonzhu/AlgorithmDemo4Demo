package com.kyson.chapter1.section4;

import com.kyson.chapter1.section3.Stack;

/**
 * 1.4.27 两个栈实现的队列。用两个栈实现一个队列，使得每个队列操作所需要的堆栈操作均摊后为一个常数。
 * 提示：如果将所有元素压入栈再弹出，它们的顺序就被颠倒了。如果再次重复这个过程，它们的顺序则会复原。* <p>
 * <p>
 * 1.4.27 Queue with two stacks. Implement a queue with two stacks so that each queue
 * operation takes a constant amortized number of stack operations. Hint: If you push
 * elements onto a stack and then pop them all, they appear in reverse order. If you
 * repeat this process, they’re now back in order.
 *
 */
public class QueueWithTwoStacksFaster<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueWithTwoStacksFaster() {
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }

    public void enqueue(T item) {
        stack1.push(item);
    }

    public T dequeue() throws Exception {
        if (stack1.size() < 1 && stack2.size() < 1) {
            throw new Exception("Queue is empty");
        }
        T ele = null;
        //Stack2为空，则将Stack1倒入Stack2
        if (stack2.size() < 1) {
            while (stack1.size() > 1) {
                T element = stack1.pop();
                stack2.push(element);
            }
            ele = stack1.pop();
        } else {
            ele = stack2.pop();
        }

        return ele;
    }

    public static void main(String[] args) {
        QueueWithTwoStacksFaster queueWithTwoStacksFaster = new QueueWithTwoStacksFaster();
        queueWithTwoStacksFaster.enqueue("我的");
        queueWithTwoStacksFaster.enqueue("名字");
        queueWithTwoStacksFaster.enqueue("叫");
        queueWithTwoStacksFaster.enqueue("顶级程序员不穿女装");
        queueWithTwoStacksFaster.enqueue("微博:https://m.weibo.cn/p/1005056186766482");
        try {
            System.out.print(queueWithTwoStacksFaster.dequeue());
            System.out.print(queueWithTwoStacksFaster.dequeue());
            System.out.print(queueWithTwoStacksFaster.dequeue());
            System.out.print(queueWithTwoStacksFaster.dequeue());
            System.out.print(queueWithTwoStacksFaster.dequeue());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
