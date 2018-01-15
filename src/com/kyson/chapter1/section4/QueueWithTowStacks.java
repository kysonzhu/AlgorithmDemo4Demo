package com.kyson.chapter1.section4;

import com.kyson.chapter1.section3.Stack;

/**
 * 1.4.27 两个栈实现的队列。用两个栈实现一个队列，使得每个队列操作所需要的堆栈操作均摊后为一个常数。
 * 提示：如果将所有元素压入栈再弹出，它们的顺序就被颠倒了。如果再次重复这个过程，它们的顺序则会复原。
 * 1.4.27 Queue with two stacks. Implement a queue with two stacks so that each queue
 * operation takes a constant amortized number of stack operations. Hint: If you push
 * elements onto a stack and then pop them all, they appear in reverse order. If you
 * repeat this process, they’re now back in order.
 */
public class QueueWithTowStacks<T> {
    private Stack<T> stack1 ;
    private Stack<T> stack2 ;

    public QueueWithTowStacks(){
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }

    public void enqueue(T item){
        stack1.push(item);
    }

    public T dequeue(){
        if (stack1.size() < 1 && stack2.size() < 1)
        {
            System.out.println("Queue is empty");
            return null;
        }
        //把stack1清空
        while (stack1.size() > 1){
            T element = stack1.pop();
            stack2.push(element);
        }
        T ele = stack1.pop();
        //把stack2 清空
        while (stack2.size() > 0){
            T element = stack2.pop();
            stack1.push(element);
        }
        return ele;
    }

    public static void main(String[] args){
        QueueWithTowStacks gfg = new QueueWithTowStacks();
        gfg.enqueue("我的");
        gfg.enqueue("名字");
        gfg.enqueue("叫");
        gfg.enqueue("顶级程序员不穿女装");
        gfg.enqueue("微博:https://m.weibo.cn/p/1005056186766482");
        System.out.print(gfg.dequeue());
        System.out.print(gfg.dequeue());
        System.out.print(gfg.dequeue());
        System.out.print(gfg.dequeue());
        System.out.print(gfg.dequeue());
    }
}
