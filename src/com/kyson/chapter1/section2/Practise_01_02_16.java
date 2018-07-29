package com.kyson.chapter1.section2;

/*
*
* 1.2.16 有理数。为有理数实现一个不可变数据类型Rational，支持加减乘除操作。无需测试溢出（请见练
* 习1.2.17），只需使用两个long型实例变量表示分子和分母来控制溢出的可能性。使用欧几里得算法来保证
* 分子和分母没有公因子。编写一个测试用例检测你实现的所有方法。

1.2.16 Rational numbers. Implement an immutable data type Rational for rational
numbers that supports addition, subtraction, multiplication, and division.

You do not have to worry about testing for overflow (see Exercise 1.2.17), but
use as instance variables two long values that represent the numerator and
denominator to limit the possibility of overflow. Use Euclid’s algorithm
(see page 4) to ensure that the numerator and denominator never have any
common factors. Include a test client that exercises all of your methods.
* */
public class Practise_01_02_16 {

    public static class Rational{

        private int nume;
        private int deno;
        public Rational(int numerator,int denominator) {

            int g = gcd(numerator, denominator);

            if (denominator < 0)
                g = -g;

            this.nume = numerator /g;
            this.deno = denominator / g;
        }

        public static int gcd(int m,int n) {
            int rem = 0;
            int M = m;
            int N = n;
            if (m < n)  {
                M = n ;
                N = m ;
            }
            rem = M % N ;
            if (0 == rem) return N;
            return gcd(N, rem);
        }

        public Rational plus(Rational b) {
            int numerator = this.nume * b.deno + b.nume * this.deno;
            int denominator = this.deno * b.deno;
            Rational rational = new Rational(numerator,denominator);
            return rational;
        }

        public Rational minus(Rational b) {
            int numerator = this.nume * b.deno - b.nume * this.deno;
            int denominator = this.deno * b.deno;
            Rational rational = new Rational(numerator,denominator);
            return rational;
        }

        public Rational times(Rational b) {
            int numerator = this.nume * b.nume;
            int denominator = this.deno * b.deno;
            Rational rational = new Rational(numerator,denominator);
            return rational;
        }

        public Rational devides(Rational b) {
            int numerator = this.nume * b.deno;
            int denominator = this.deno * b.nume;
            Rational rational = new Rational(numerator,denominator);
            return rational;
        }

        public boolean equals(Rational b) {
            if (this == b) return true;
            if (b == null) return false;
            if (this.getClass() != b.getClass()) return false;
            return (nume == b.nume && deno == b.deno);
        }

        public String toString(){
            return this.nume + "/" + this.deno;
        }
    }

    public static void main(String[]args) {
        Rational rational1 = new Rational(3,4);
        Rational rational2 = new Rational(5,6);
        Rational result1 = rational1.plus(rational2);
        Rational result2 = rational1.minus(rational2);
        Rational result3 = rational1.times(rational2);
        Rational result4 = rational1.devides(rational2);
        System.out.println("plus:"+result1);
        System.out.println("minus:"+result2);
        System.out.println("times:"+result3);
        System.out.println("devides:"+result4);
    }

}
