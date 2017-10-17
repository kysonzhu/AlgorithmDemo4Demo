package com.kyson.chapter1.section3;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/***
 * 给定以下输入，java Stack的输出是什么？
 * it was - the best - of times - - - it was - the - -
 */
public class Stack<Item> {

    /**
     ******数组实现*****
     *
     *
    private int N;

    private Item[] a;

    public Stack(int cap){
        a =(Item[]) new Object[cap];
    }

    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];

        for (int i = 0 ; i < N ; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item){
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop(){
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);

        return item;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public boolean isFull(){
        return N == a.length;
    }

    public static void main(String[] args){
        Stack stack = new Stack<String>(2);
        stack.push("My");
        stack.push("name");
        stack.push("is");
        stack.push("顶级程序员不穿女装");



    }

     */


    /**
     *
     *****链表实现*****
     */
    private int N;
    private Node first;
    private class Node{
        Item item;
        Node next;
    }
    public Stack(){
        first = new Node();
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public boolean isEmpty(){
        //或:first = null
        return N == 0;
    }

    public static void main(String[] args){
//        String testString = "it was - the best - of times - - - it was - the - -";
        Stack<String> s = new Stack();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (item.equals("-")){
                s.push(item);
            }else if(!s.isEmpty()){
                StdOut.print(s.pop() + "");
            }
        }
    }
}
