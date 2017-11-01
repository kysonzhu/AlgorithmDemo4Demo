package com.kyson.chapter1.section3;

import edu.princeton.cs.algs4.In;

/***
 * 
 * 1.3.16 使用1.3.1.5节中的readInts()作为模板为Date编写一个静态方法readDates()，从标准输入中读取由练习1.2.19
 * 的表格所指定的格式的多个日期并返回一个它们的数组。
 * 
 * 1.3.16 Using readInts() on page 126 as a model,write a static method
 * readDates() for Date that reads dates from standard input in the format
 * specified in the table on page 119 and returns an array containing them.
 * 
 */
public class Date1 {

	private int month;
	private int day;
	private int year;

	public Date1(String date) {
		String[] fields = date.split("/");
		month = Integer.parseInt(fields[0]);
		day = Integer.parseInt(fields[1]);
		year = Integer.parseInt(fields[2]);
	}

	public String toString() {
		return "" + month + "/" + day + "/" + year;
	}

	public static Date1[] readDates(String name) {
		In in = new In(name);
		Queue<Date1> q = new Queue<Date1>();
		while (!in.isEmpty()) {
			String readedString = in.readString();
			Date1 date1 = new Date1(readedString);
			q.enqueue(date1);
		}
		int N = q.size();
		Date1[] a = new Date1[N];
		for (int i = 0; i < N; i++)
			a[i] = q.dequeue();
		return a;
	}

	public static void main(String[] args) {
		String filePathString = System.getProperty("user.dir");

		String intFileString = filePathString
				+ "/src/com/kyson/chapter1/section3/" + "a.txt";
		System.out.println("即将读取" + intFileString + "文件中得到的数组为：");
		int[] ints = readInts(intFileString);
		System.out.println("读取文件中得到的数组为：");
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}

		String dateFileString = filePathString
				+ "/src/com/kyson/chapter1/section3/" + "b.txt";
		System.out.println("即将读取" + dateFileString + "文件中得到的数组为：");
		Date1[] date1 = readDates(dateFileString);
		System.out.println("读取文件中得到的数组为：");
		for (int i = 0; i < date1.length; i++) {
			System.out.println(date1[i]);
		}
	}

	public static int[] readInts(String name) {
		In in = new In(name);
		Queue<Integer> q = new Queue<Integer>();
		while (!in.isEmpty())
			q.enqueue(in.readInt());
		int N = q.size();
		int[] a = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = q.dequeue();
		return a;
	}

}
