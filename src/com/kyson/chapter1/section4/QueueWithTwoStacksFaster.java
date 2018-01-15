package com.kyson.chapter1.section4;

import com.kyson.chapter1.section3.Stack;

public class QueueWithTwoStacksFaster<T> {
    private Stack<T> stack1 ;
    private Stack<T> stack2 ;

    public QueueWithTwoStacksFaster(){
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }

    public void enqueue(T item){
        stack1.push(item);
    }

    public T dequeue() throws Exception {
        if (stack1.size() < 1 && stack2.size() < 1)
        {
            throw new Exception("Queue is empty");
        }
        T ele = null;
        //Stack2为空，则将Stack1倒入Stack2
        if (stack2.size() < 1){
            while (stack1.size() > 1){
                T element = stack1.pop();
                stack2.push(element);
            }
            ele = stack1.pop();
        }else{
            ele = stack2.pop();
        }

        return ele;
    }

    public static void main(String[] args){
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
