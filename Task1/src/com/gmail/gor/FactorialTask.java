package com.gmail.gor;

import java.math.BigInteger;

public class FactorialTask implements Runnable {

	private int number;

	public FactorialTask(int number) {
		this.number = number;
	}

	public BigInteger factorial(int n) {
		BigInteger fact = BigInteger.ONE;
		for (int i = 1; i <= n; i += 1) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}

	@Override
	public void run() {
		Thread thr = Thread.currentThread();
		System.out.println(thr.getName() + " " + number + "!=" + factorial(number));
	}

}
