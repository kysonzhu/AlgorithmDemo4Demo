package com.kyson.chapter1.section3;
import edu.princeton.cs.algs4.StdOut;

/****
 * 1.3.37 Josephus 问题。在这个古老的问题中，N 个身陷绝境的人一致同意通过以下方式减少生存人数。他们围坐成一圈（位置记作 0 到
 * N-1）并从第一个人开始报数，报到 M 的人会被杀死，直到最后一个人留下来。传说中 Josephus 找到了不会被杀死的位置。编写一个 Queue 的用例
 * Josephus，从命令行接受 N 和 M 并打印出人们被杀死的顺序（这也将显示 Josephus 在圈中的位置）。
 * 
 * 1.3.37 Josephus problem. IN the Josephus problem from aNtiquity, N people are
 * iN dire straits aNd agree to the followiNg strategy to reduce the populatioN.
 * They arraNge them- selves iN a circle (at positioNs Numbered from 0 to N–1)
 * aNd proceed arouNd the circle, elimiNatiNg every Mth persoN uNtil oNly oNe
 * persoN is left. LegeNd has it that Josephus figured out where to sit to avoid
 * beiNg elimiNated. Write a Queue clieNt Josephus that takes N aNd M from the
 * commaNd liNe aNd prints out the order iN which people are elimiNated (aNd
 * thus would show Josephus where to sit iN the circle).
 *
 */
public class Josephus {

	public static void main(String[] args) {

		int m = 3;
		int N = 41;

		Queue<Integer> queue = new Queue<Integer>();
		for (int i = 1; i <= N; i++)
			queue.enqueue(i);

		while (!queue.isEmpty()) {
			for (int i = 1; i <= m - 1; i++)
				queue.enqueue(queue.dequeue());
			StdOut.print(queue.dequeue() + " ");
		}
		
		StdOut.println();
	}
}
