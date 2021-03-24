package com.gmail.gor;

class KnuthStep {
	private int i;

	public KnuthStep(int[] array) {
		for (; (Math.pow(3, i) - 1) / 2 < array.length / 3;) {
			i = i + 1;
		}
	}

	public int nextStep() {
		int step = (int) ((Math.pow(3, i) - 1) / 2);
		i = i - 1;
		return step;
	}
}
