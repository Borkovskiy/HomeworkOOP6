package com.gmail.gor;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] numbers = new int[100_000_000];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 10);
		}
		addition(numbers);
		additionThreads(numbers);

	}

	public static void addition(int[] numbers) {
		long start = System.nanoTime();
		long addition = 0;
		for (int i = 0; i < numbers.length; i++) {
			addition += numbers[i];
		}
		long end = start - System.nanoTime();
		System.out.println("sum of numbers= " + addition);
		System.out.println("time spent on a task with one method" + end);
	}

	public static void additionThreads(int[] numbers) {
		long start = System.nanoTime();
		long addition = 0;
		Thread[] threads = new Thread[4];
		AdditionNumber[] additionNumber = new AdditionNumber[4];
		for (int i = 0; i < 4; i++) {
			int size = numbers.length / 4;
			int startSequence = size * i;
			int endSequence = ((i + 1) * size);
			if ((numbers.length - endSequence) < size) {
				endSequence = numbers.length;
			}

			int[] a = Arrays.copyOfRange(numbers, startSequence, endSequence);
			additionNumber[i] = new AdditionNumber(a);
			threads[i] = new Thread(additionNumber[i]);
			threads[i].start();

		}
		for (int i = 0; i < 4; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 4; i++) {
			addition += additionNumber[i].getAddition();
		}

		long end = start - System.nanoTime();
		System.out.println("sum of numbers= " + addition);
		System.out.println("time spent on a task with threads" + end);
	}

}
