package com.kyson.chapter1.section3;

/**
 * 1.3.4 编写一个Stack的用例Parentheses，从标准输入读取一个文本流并使用栈判定其中的括号是否配对完整。
 * 例如，对于[()]{}{[()()]()} 程序应该打印true，对于 [(])则打印false。
 * 
 * 1.3.4 Write a stack client Parentheses that reads in a text stream from
 * standard input and uses a stack to determine whether its parentheses are
 * properly balanced. For example, your program should print true for
 * [()]{}{()()} and false for [(]).
 * 
 */
public class Parentheses {

	public boolean isMatch(String item) {
		return false;
	}

	public static void main(String[] args) {

//		String stream = "[()]{}{[()()]()}";
		String stream = "[(])";
		
		
		boolean isPaired = true;
		
		Stack<String> ops = new Stack<String>();
		for (int i = 0; i < stream.length(); i++) 
		{
			char item = stream.charAt(i);
			String s = String.valueOf(item);
			
			if (s.equals("[")) {
				ops.push(s);
			}else if (s.equals("(")) {
				ops.push(s);
			}else if (s.equals("{")) {
				ops.push(s);
			}
			else 
			if(s.equals("]"))
			{
				String popedString = ops.pop();
				if (!popedString.equals("[")) 
				{
					isPaired = false;
					break;
				}
			}
			else
			if(s.equals("}"))
			{
				String popedString = ops.pop();
				if (!popedString.equals("{")) 
				{
					isPaired = false;
					break;
				}
			}
			else
			if (s.equals(")")) 
			{
				String popedString = ops.pop();
				if (!popedString.equals("(")) 
				{
					isPaired = false;
					break;
				}
			}
		}
		System.out.println(isPaired);
		
		

	}

}
