package com.kyson.chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

/***
 * 
 * 1.2.13 用我们对Date的实现作为模板实现Transaction类型
 * 1.2.13 Using our implementation of
 * Date as a model(page91),develop an implementation of Transaction.
 * 1.2.14 用我们对Date的实现作为模板实现Transaction的euqal()函数
 * 1.2.14 Using our implementation of
 * equals() in Date as a model(page103),develop implementations of equals() for
 * Transaction.**
 *
 */
public class Transaction {

	private Date when;
	private String who;
	private double amount;

	public Date when() {
		return this.when;
	}

	public double amount() {
		return this.amount;
	}

	public String who() {
		return this.who;
	}

	public Transaction(String who, Date when, double amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
	}

	public String toString() {
		return "" + this.who + " at " + this.when + " transaction " + this.amount;
	}

	public boolean equals(Object x) {
		if (this == x)
			return true;
		if (x == null)
			return false;
		if (this.getClass() != x.getClass())
			return false;
		Transaction that = (Transaction) x;
		if (!this.when.equals(that.when))
			return false;
		if (!this.who.equals(that.who))
			return false;
		if (this.amount != that.amount)
			return false;

		return true;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Date date = new Date(1996, 12, 5);
		Transaction tran = new Transaction("Kyson", date, 1000);
		StdOut.println(tran.toString());
	}

}
