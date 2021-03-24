package com.gmail.gor;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[50];
		Random rn = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(10);
		}
		System.out.println(Arrays.toString(array));
		MultiThreadSorting.sort(array, 5);
		System.out.println(Arrays.toString(array));

	}

}
