package com.kyson.chapter1.section3;

/***
 * 1.3.15 编写一个Queue的用例，接受一个命令行参数k并打印出标准输入中的倒数第k个字符串（假设标准输入中至少有k个字符串）。
 * 
 * 1.3.15 Write a Queue client that takes a command-line argument k and prints
 * the kth from the last string found on standard input (assuming that standard
 * input has k or more strings).
 * 
 */
public class QueueExecise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a[] = 
		{
				"我的", 
				"名字", 
				"叫", 
				"顶级程序员不穿女装",
				"微博:https://m.weibo.cn/p/1005056186766482" 
				};
		
		int k = 3;
		Queue<String> stringQueue = new Queue<String>();
		for (int i = 0; i < a.length; ++i) {
			stringQueue.enqueue(a[i]);
		}

		int index = a.length - k;
		for (int j = 0; j <= index; ++j) {
			String dequeuedString = stringQueue.dequeue();
			if (j == index)
				System.out.print(dequeuedString);
		}
	}
}
