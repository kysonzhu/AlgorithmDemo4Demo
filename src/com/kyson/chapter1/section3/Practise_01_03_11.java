package com.kyson.chapter1.section3;

/*
*
* 1.3.11 编写一段程序EvaluatePostfix，从标准输入中得到一个后序表达式，求值并打印结果。
* (将上一题的程序中得到的输出用管道传递给这一段程序可以得到和Evaluate相同的行为)

1.3.11 Write a program EvaluatePostfix that takes a postfix expression
from standard input, evaluates it, and prints the value. (Piping the output
of your program from the previous exercise to this program gives equivalent
 behavior to Evaluate.
* */

import edu.princeton.cs.algs4.StdOut;

public class Practise_01_03_11 {

    public static class Evaluate {

        public static Double evaluateInfix(String x) {
            Stack<String> ops  = new Stack<String>();
            Stack<Double> vals = new Stack<Double>();
            for (int index = 0 ; index < x.length() ; ++index)
            {
                char y = x.charAt(index);
                String s = String.valueOf(y);

                if (s.equals("=")) break;
                if (s.equals("(")) ;
                else if (s.equals("sqrt") || s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                    ops.push(s);
                }
                else if (s.equals(")"))
                {
                    String op = ops.pop();
                    double v = vals.pop();
                    if (op.equals("+")) v = vals.pop() + v;
                    else if (op.equals("-")) v = vals.pop() - v;
                    else if (op.equals("*")) v = vals.pop() * v;
                    else if (op.equals("/")) v = vals.pop() / v;
                    else if (op.equals("sqrt")) v = Math.sqrt(v);
                    vals.push(v);
                }
                else vals.push(Double.parseDouble(s));
            }
            return vals.pop();
        }

        public static Double evaluatePostfix(String x) {
            Stack<Double> vals = new Stack<>();

            for (int index = 0 ; index < x.length() ; ++index)
            {
                char y = x.charAt(index);
                String s = String.valueOf(y);

                if (s.equals("+"))
                {
                    Double val1 = vals.pop();
                    Double val2 = vals.pop();
                    Double val = val1 + val2;
                    vals.push(val);

                } else if(s.equals("-") )
                {
                    Double val1 = vals.pop();
                    Double val2 = vals.pop();
                    Double val = val1 - val2;
                    vals.push(val);
                } else if(s.equals("*"))
                {
                    Double val1 = vals.pop();
                    Double val2 = vals.pop();
                    Double val = val1 * val2;
                    vals.push(val);
                }else if(s.equals("/"))
                {
                    Double val1 = vals.pop();
                    Double val2 = vals.pop();
                    Double val = val1 * val2;
                    vals.push(val);
                }
                else vals.push(Double.parseDouble(s));
            }
            return vals.pop();
        }

        public static String infixToPostfix(String x)
        {
            Stack<String> ops = new Stack<>();
            Stack<Double> vals = new Stack<>();
            StringBuilder builder = new StringBuilder();
            for (int index = 0; index < x.length() ; ++index)
            {
                char y = x.charAt(index);
                String s = String.valueOf(y);


                if (s.equals("(")) {
                    ;
                } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                    ops.push(s);
                } else if (s.equals(")")) {
                    String op = ops.pop();
                    builder.append(op);
                } else {
                    vals.push(Double.parseDouble(s));
                    builder.append(s);
                }
            }

            return builder.toString();
        }


        public static void main(String[] args) {
            String expression = "(1+((2+3)*(4*5)))";
            double x = evaluateInfix(expression);
            StdOut.print(x);

            String postfix = infixToPostfix(expression);
            double y = evaluatePostfix(postfix);
            StdOut.print(y);


        }

    }


}
