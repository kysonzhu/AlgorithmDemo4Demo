package com.kyson.chapter1.section2;

/*
*
* 1.2.17 有理数实现的健壮性。在Rational（请见练习1.2.16）的开发中使用断言来防止溢出。

1.2.17 Robust implementation of rational numbers. Use assertions to develop
an implementation of Rational (see Exercise 1.2.16) that is immune to overflow.
* */
public class Practise_01_02_17 {

    public static class Rational{

        private int nume;
        private int deno;
        public Rational(int numerator,int denominator) {
            int g = gcd(numerator, denominator);
            if (denominator == 0)
                throw new RuntimeException("Denominator is zero");
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
            assert(deno < Integer.MAX_VALUE && deno > Integer.MIN_VALUE);
            assert(b.deno < Integer.MAX_VALUE && b.deno > Integer.MIN_VALUE);

            int numerator = this.nume * b.deno + b.nume * this.deno;
            int denominator = this.deno * b.deno;
            Rational rational = new Rational(numerator,denominator);
            return rational;
        }

        public Rational minus(Rational b) {
            assert(deno < Integer.MAX_VALUE && deno > Integer.MIN_VALUE);
            assert(b.deno < Integer.MAX_VALUE && b.deno > Integer.MIN_VALUE);

            int numerator = this.nume * b.deno - b.nume * this.deno;
            int denominator = this.deno * b.deno;
            Rational rational = new Rational(numerator,denominator);
            return rational;
        }

        public Rational times(Rational b) {
            assert(deno < Integer.MAX_VALUE && deno > Integer.MIN_VALUE);
            assert(b.deno < Integer.MAX_VALUE && b.deno > Integer.MIN_VALUE);

            int numerator = this.nume * b.nume;
            int denominator = this.deno * b.deno;
            Rational rational = new Rational(numerator,denominator);
            return rational;
        }

        public Rational devides(Rational b) {
            assert(deno < Integer.MAX_VALUE && deno > Integer.MIN_VALUE);
            assert(b.deno < Integer.MAX_VALUE && b.deno > Integer.MIN_VALUE);

            int numerator = this.nume * b.deno;
            int denominator = this.deno * b.nume;
            Rational rational = new Rational(numerator,denominator);
            return rational;
        }

        public boolean equals(Rational b) {
            assert(deno < Integer.MAX_VALUE && deno > Integer.MIN_VALUE);
            assert(b.deno < Integer.MAX_VALUE && b.deno > Integer.MIN_VALUE);

            if (this == b) return true;
            if (b == null) return false;
            if (this.getClass() != b.getClass()) return false;
            return (nume == b.nume && deno == b.deno);
        }

        public String toString(){
            return this.nume + "/" + this.deno;
        }
    }

}
