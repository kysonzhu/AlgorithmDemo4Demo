package com.kyson.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

/*
*
*1.3.10 编写一个过滤器InfixToPostfix，将算术表达式由中序表达式转为后序表达式。

1.3.10 Write a filter InfixToPostfix that converts an arithmetic expression from infix to postfix.
* */
public class Practise_01_03_10 {

    public static class InfixToPostfix {

        public static void infixToPostfix(String x)
        {
            Stack<String> ops = new Stack<String>();
            Stack<Double> vals = new Stack<Double>();

            for (int index = 0 ; index < x.length() ; ++ index)
            {
                char y = x.charAt(index);
                String s = String.valueOf(y);

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
                    StdOut.print(op);
                } else {
                    vals.push(Double.parseDouble(s));
                    StdOut.print(s);
                }
            }
        }

        public static void main(String[] args) {
            String expression = "(1+((2+3)*(4*5)))";
            infixToPostfix(expression);
        }

    }



}
