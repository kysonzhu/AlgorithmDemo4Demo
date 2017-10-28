package com.kyson.chapter1.section3;

import java.io.IOException;
import java.io.PipedInputStream;

public class EvalateReceive implements Runnable{

	// 管道输入流
	private PipedInputStream pis = null; 

	private OnConvertFinishedReceivedListener mListener; 
	
	public void setConvertFinishedListener(OnConvertFinishedReceivedListener listener){
		this.mListener = listener;
	}
	
	public EvalateReceive() {
		// 实例化输入流
		this.pis = new PipedInputStream(); 
	}

	public void run() {
		byte b[] = new byte[1024]; // 接收内容
		int len = 0;
		try {
			len = this.pis.read(b); // 读取内容
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			this.pis.close(); // 关闭
		} catch (IOException e) {
			e.printStackTrace();
		}
		String receivedString = new String(b, 0, len);
		System.out.println("接收的中缀表达式为：" + receivedString + "\n开始转换成为后缀表达式...");// 注意，这里是把读入的数组的数据输出，而不是PipeInputStream实例对象输出，
		String postfixString = infixToPostfix(receivedString);
		System.out.println("转换成的后缀表达式为" + postfixString);// 注意，这里是把读入的数组的数据输出，而不是PipeInputStream实例对象输出，
		if (this.mListener != null) {
			this.mListener.onFinished(postfixString);
		}
	}

	public PipedInputStream getPis() {
		return this.pis;
	}
	
	
	public static String infixToPostfix(String infixString) {
		String expression = infixString;
		String resultString = "";
		Stack<String> ops = new Stack<String>();
		for (int j = 0; j < expression.length(); j++) {
			char charAtIndex = expression.charAt(j);
			String s = String.valueOf(charAtIndex);
			if (s.equals("(")) {
				;
			} else if (s.equals("+")) {
				ops.push(s);
			} else if (s.equals("-")) {
				ops.push(s);
			} else if (s.equals("*")) {
				ops.push(s);
			} else if (s.equals("/")) {
				ops.push(s);
			} else if (s.equals(")")) {
				String op = ops.pop();
				resultString = resultString + op;
			} else {
				resultString = resultString + s;
			}
		}
		
		return resultString;
	}

	
	public interface OnConvertFinishedReceivedListener {  
	    
	    void onFinished(String postfixString);  
	}  
}
