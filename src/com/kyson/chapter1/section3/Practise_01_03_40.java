package com.kyson.chapter1.section3;

/*
*
* 1.3.40 前移编码。从标准输入读取一串字符，使用链表保存这些字符并删除重复字符。当你读取了一个从未见过的字符时，将它插入表头。当你读取了一个重复的
* 字符时，将它从链表中删去并再次插入表头。将你的程序命名为 MoveToFront：它实现了著名的前移编码策略，这种策略假设最近访问过的元素很可能会再次访
* 问，因此可以用于缓存、数据压缩等许多场景。

1.3.40 Move-to-front. Read in a sequence of characters from standard input and maintain the characters in a linked
list with no duplicates. When you read in a previ- ously unseen character, insert it at the front of the list.
When you read in a duplicate character, delete it from the list and reinsert it at the beginning. Name your
program MoveToFront: it implements the well-known move-to-front strategy, which is useful for caching, data
compression, and many other applications where items that have been recently accessed are more likely to be reaccessed.
* */

import edu.princeton.cs.algs4.StdIn;

public class Practise_01_03_40 {

    private static class Node {
        char item;
        Node next;
    }

    public static class MoveToFront {

        private Node first;
        private int N=0;

        public void Judge(char c)
        {
            Node current = first;
            for(int i=0;i < N;i++)
            {
                if(current.item == c)
                {
                    current = current.next;
                    return ;
                }
                current=current.next;
            }
            this.push(c);
        }

        public void push(char item)
        {
            Node oldfirst= first;
            first = new Node();
            first.item=item;
            first.next=oldfirst;
            N++;
        }

        public void print()
        {
            for(Node current=first;current!=null;current=current.next) {
                System.out.print(current.item+" ");
            }
        }

    }

    public static void main(String[] args){
//        String a = "annbaa";
        MoveToFront mtf = new MoveToFront();
        while(!StdIn.isEmpty())
        {
            mtf.Judge(StdIn.readChar());
        }
        mtf.print();

    }

}
