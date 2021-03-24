package com.gmail.gor;

public class AdditionNumber implements Runnable {
	private int[] numbers;
	private long addition;

	public AdditionNumber(int[] numbers) {
		super();
		this.numbers = numbers;
	}

	public long getAddition() {
		return addition;
	}

	public void addition() {
		for (int i = 0; i < numbers.length; i++) {
			addition += numbers[i];
		}
	}

	@Override
	public void run() {
		addition();
	}

}
