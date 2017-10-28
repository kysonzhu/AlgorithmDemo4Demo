package com.kyson.chapter1.section3;

import java.io.IOException;
import java.util.ArrayList;

import com.kyson.chapter1.section3.EvalateReceive.OnConvertFinishedReceivedListener;

/***
 * 
 * 1.3.11 编写一段程序EvaluatePostfix，从标准输入中得到一个后序表达式，求值并打印结果。(
 * 将上一题的程序中得到的输出用管道传递给这一段程序可以得到和Evaluate相同的行为)
 * 
 * 1.3.11 Write a program EvaluatePostfix that takes a postfix expression from
 * standard input, evaluates it, and prints the value. (Piping the output of
 * your program from the previous exercise to this program gives equivalent
 * behavior to Evaluate.
 * 
 */
public class EvaluatePostfix implements OnConvertFinishedReceivedListener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PostfixSend s = new PostfixSend("(1+((2+3)*(4*5)))");
		EvalateReceive r = new EvalateReceive();
		EvaluatePostfix evaluatePostfix = new EvaluatePostfix();
		r.setConvertFinishedListener(evaluatePostfix);

		try {
			s.getPos().connect(r.getPis()); // 连接管道
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Thread(s).start(); // 启动线程
		new Thread(r).start(); // 启动线程
	}

	private static int evaluatePostfix(String expression) {
		ArrayList<String> params = new ArrayList<String>();
		for (int j = 0; j < expression.length(); j++) {
			char charAtIndex = expression.charAt(j);
			String s = String.valueOf(charAtIndex);
			params.add(s);
		}

		Stack<Integer> stack = new Stack<Integer>();
		for (String param : params) {
			if (param.equals("+")) {
				int d2 = stack.pop();
				int d1 = stack.pop();
				stack.push(d1 + d2);
			} else if (param.equals("-")) {
				int d2 = stack.pop();
				int d1 = stack.pop();
				stack.push(d1 - d2);
			} else if (param.equals("*")) {
				int d2 = stack.pop();
				int d1 = stack.pop();
				stack.push(d1 * d2);
			} else if (param.equals("/")) {
				int d2 = stack.pop();
				int d1 = stack.pop();
				stack.push(d1 / d2);
			} else { // number
				stack.push(Integer.parseInt(param));
			}
		}
		return stack.pop();
	}

	public void onFinished(String postfixString) {
		// TODO Auto-generated method stub
		String resultString = evaluatePostfix(postfixString) + "";
		System.out.println("计算结果:" + resultString + "");
	}

}
