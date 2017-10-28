package com.kyson.chapter1.section3;

import java.io.IOException;
import java.io.PipedOutputStream;

public class PostfixSend implements Runnable{
	// 管道输出流
	private PipedOutputStream pos = null; 

	private String mInfixString;
	public PostfixSend(String infixString) {
		this.mInfixString = infixString;
		// 实例化输出流
		this.pos = new PipedOutputStream(); 
	}

	public void run() {
		// 要输出的内容
		String str = this.mInfixString; 
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

	}

}
