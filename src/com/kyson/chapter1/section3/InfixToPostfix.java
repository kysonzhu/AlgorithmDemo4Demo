package com.kyson.chapter1.section3;

/***
 * 1.3.10 编写一个过滤器InfixToPostfix，将算术表达式由中序表达式转为后序表达式。 1.3.10 Write a filter
 * InfixToPostfix that converts an arithmetic expression from infix to postfix.
 * 
 * 
 */
public class InfixToPostfix {
	

	public static void main(String[] args) {
		// 双栈
		String expression = "(1+((2+3)*(4*5)))";

		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		
		for (int j = 0; j < expression.length(); j++) {
			char charAtIndex = expression.charAt(j);
			String s = String.valueOf(charAtIndex);
			if(s.equals("(")) 
			{
			;
			}
			else if (s.equals("+"))
			{
				ops.push(s);
			}
			else if (s.equals("-"))
			{
				ops.push(s);
			}
			else if (s.equals("*"))
			{
				ops.push(s);
			}
			else if (s.equals("/"))
			{
				ops.push(s);
			}
			else if (s.equals(")")){
				String op = ops.pop();
	            double v = vals.pop();
			}


		}
		

		
	}
}
