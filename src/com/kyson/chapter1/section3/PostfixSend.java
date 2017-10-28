package com.kyson.chapter1.section3;

import java.io.IOException;
import java.io.PipedOutputStream;

public class PostfixSend implements Runnable{

	private PipedOutputStream pos = null; // 管道输出流

	private String mInfixString;
	public PostfixSend(String infixString) {
		this.mInfixString = infixString;
		this.pos = new PipedOutputStream(); // 实例化输出流
	}

	public void run() {
		String str = this.mInfixString; // 要输出的内容
		try {
			this.pos.write(str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			this.pos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PipedOutputStream getPos() { 
		// 得到此线程的管道输出流
		return this.pos;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
