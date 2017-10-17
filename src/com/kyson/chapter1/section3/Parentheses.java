package com.kyson.chapter1.section3;

/**
 * 1.3.4 编写一个Stack的用例Parentheses，从标准输入读取一个文本流并使用栈判定其中的括号是否配对完整。
 *       例如，对于[()]{}{[()()]()} 程序应该打印true，对于 [(])则打印false。
 *
 */
public class Parentheses {

    public boolean isMatch(String item){
        return false;
    }

    public static void main(String[] args) {
    	
    	Parentheses parentheses = new Parentheses();
    	String stream = "[()]{}{[()()]()}";
        boolean isMatch = parentheses.isMatch(stream);
        System.out.println(isMatch);

	}

    
}
