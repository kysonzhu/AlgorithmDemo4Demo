package com.kyson.chapter1.section3;

/*
*1.3.43 文件列表。文件夹就是一列文件和文件夹的列表。编写一个程序，从命令行接受一个文件夹名作为
* 参数，打印出该文件夹下的所有文件并用递归的方式在所有子文件夹的名下（缩进）列出其下的所有文件。
* 提示：使用队列，并参考 java.io.File。

1.3.43 Listing files. A folder is a list of files and folders. Write
a program that takes the name of a folder as a command-line argument
and prints out all of the files contained in that folder, with the
contents of each folder recursively listed (indented) under that
folder’s name. Hint : Use a queue, and see java.io.File.
*
* */
public class Practise_01_03_44 {

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

        public int size()
        {
            return N;
        }
    }



    public class Buffer
    {
        private Stack<Character> leftside;
        private Stack<Character> rightside;

        public Buffer()
        {
            this.leftside = new Stack<Character>(1);
            this.rightside = new Stack<Character>(1);
        }

        public void insert(Character c)
        {
            this.leftside.push(c);
        }

        public char delete()
        {
            return this.leftside.pop();
        }

        public void left(int k)
        {
            for (int i = 0; i < k; ++i)
            {
                this.rightside.push(this.leftside.pop());
            }
        }

        public void right(int k)
        {
            for (int i = 0; i < k; ++i)
            {
                this.leftside.push(this.rightside.pop());
            }
        }

        public int size()
        {
            return this.leftside.size() + this.rightside.size();
        }

        public String getString()
        {
            while (!leftside.isEmpty())
            {
                this.rightside.push(this.leftside.pop());
            }

            return rightside.toString();
        }

    }


}
