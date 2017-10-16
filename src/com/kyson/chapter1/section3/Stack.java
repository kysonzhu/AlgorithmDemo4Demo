package com.kyson.chapter1.section3;

/***
 * 给定以下输入，java Stack的输出是什么？
 * it was - the best - of times - - - it was - the - -
 */
public class Stack<Item> {

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

}
