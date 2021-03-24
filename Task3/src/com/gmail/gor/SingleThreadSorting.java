package com.gmail.gor;

import java.util.Arrays;

public class SingleThreadSorting implements Runnable {
	private int[] array;
	private Thread thr;
	private int index;
	private boolean stop = false;

	public SingleThreadSorting(int[] array) {
		super();
		this.array = array;
		thr = new Thread(this);
		thr.start();
		this.index = 0;
	}

	public Thread getThr() {
		return thr;
	}

	public int peekElement() {
		return array[index];
	}

	public int pollElement() {
		int temp = array[index];
		check();
		return temp;
	}

	public boolean isStop() {
		return stop;
	}

	@Override
	public void run() {
		shellSort(new KnuthStep(array));
		System.out.println(Arrays.toString(array));
	}

	public void shellSort(KnuthStep knuthStep) {
		int step = knuthStep.nextStep();
		for (; step > 0;) {
			for (int i = step; i < array.length; i++) {
				for (int j = i; j >= step && array[j] < array[j - step]; j -= step) {
					int temp = array[j];
					array[j] = array[j - step];
					array[j - step] = temp;
				}
			}
			step = knuthStep.nextStep();
		}

	}

	private void check() {
		this.index++;
		if (this.index >= array.length) {
			this.stop = true;
		}
	}
}
