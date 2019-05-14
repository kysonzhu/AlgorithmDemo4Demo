package com.kyson.chapter1.section3;

import java.io.File;
import java.util.Iterator;

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
public class Practise_01_03_43 {

    public static void printFile(File file,int cengji){
        File[] tempList = file.listFiles();
        for (int i = 0; i < tempList.length; i++) {
            File fileItem = tempList[i];

            String str = "";
            for (int j = 0; j < cengji; j++) {
                str = str + " ";
            }
            System.out.println(str + fileItem.getName());

            if (fileItem.isDirectory()) {
                printFile(fileItem,cengji + 1);
            }
        }
    }

    public static void main(String[] args)
    {
        String path = "/Users/kyson/Desktop/";
        File file = new File(path);
        System.out.println("the files of path :[" + path + "] are:");

        printFile(file,0);
    }

}
