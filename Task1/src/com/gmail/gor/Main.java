package com.gmail.gor;

public class Main {

	public static void main(String[] args) {

		Thread[] threads = new Thread[100];
		for (int i = 0; i < threads.length; i++) {
			FactorialTask factorials = new FactorialTask(i);
			threads[i] = new Thread(factorials);
			threads[i].start();
		}

	}

}
