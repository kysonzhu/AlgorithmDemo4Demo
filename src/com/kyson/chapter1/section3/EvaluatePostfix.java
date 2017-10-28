package com.kyson.chapter1.section3;

import java.io.IOException;

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
		PostfixSend s = new PostfixSend("(1+((2+3)*(4*5)))");
		EvalateReceive r = new EvalateReceive();
		EvaluatePostfix evaluatePostfix = new EvaluatePostfix();
		r.setConvertFinishedListener(evaluatePostfix);

		try {
			// 连接管道
			s.getPos().connect(r.getPis());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 启动线程
		new Thread(s).start();
		// 启动线程
		new Thread(r).start();
	}

	private static String evaluatePostfix(String expression) {
		Stack<Double> vals = new Stack<Double>();
		for (int j = 0; j < expression.length(); j++) {
			char charAtIndex = expression.charAt(j);
			String s = String.valueOf(charAtIndex);
			if (s.equals("+")) {
				Double valDouble1 = vals.pop();
				Double valDouble2 = vals.pop();
				s = valDouble1 + valDouble2 + "";
				vals.push(Double.parseDouble(s));
			}else if (s.equals("-")) {
				Double valDouble1 = vals.pop();
				Double valDouble2 = vals.pop();
				s = valDouble1 - valDouble2 + "";
				vals.push(Double.parseDouble(s));
			}else if (s.equals("*")) {
				Double valDouble1 = vals.pop();
				Double valDouble2 = vals.pop();
				s = valDouble1 * valDouble2 + "";
				vals.push(Double.parseDouble(s));
			}else if (s.equals("/")) {
				Double valDouble1 = vals.pop();
				Double valDouble2 = vals.pop();
				s = valDouble1 / valDouble2 + "";
				vals.push(Double.parseDouble(s));
			}else {
				vals.push(Double.parseDouble(s));
			}

		}

		return vals.pop().toString();
	}

	public void onFinished(String postfixString) {
		String resultString = evaluatePostfix(postfixString) + "";
		System.out.println("计算结果:" + resultString + "");
	}

}
