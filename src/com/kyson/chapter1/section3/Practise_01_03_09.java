package com.kyson.chapter1.section3;

/*
*1.3.9 编写一道程序，从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式。例如，给定输
* 入:1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) 你的程序应该输出((1 + 2) * ((3 - 4) * (5 - 6)))

1.3.9 Write a program that takes from standard input an expression without left pa- rentheses and prints the
equivalent infix expression with the parentheses inserted. For example, given the input:

1 + 2 ) * 3 - 4 ) * 5- 6 ) ) )
* */
public class Practise_01_03_09 {

    private static boolean isOperator(String s)
    {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

    public static String completionBrackets (String origin)
    {
        String[] params = origin.split(" ");
        Stack<String> ops = new Stack<String>();
        Stack<String> vals = new Stack<String>();
        for (int i = 0; i < params.length; i++)
        {
            if (isOperator(params[i]))
            {
                ops.push(params[i]);
            }
            else
                if (params[i].equals(")"))
            {
                String d1 = vals.pop();
                String d2 = vals.pop();
                String op = ops.pop();
                vals.push("( " + d2 + " " + op + " "+ d1 + " )");
            } else {
                vals.push(params[i]);
            }
        }
        return vals.pop();
    }

    public static void main (String[] args) {

        String originExpress = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String result = completionBrackets(originExpress);
        System.out.print(result);
    }


}
