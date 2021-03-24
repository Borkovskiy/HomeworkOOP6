package com.gmail.gor;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File folder = new File(".");
		File folder2 = new File("folder");
		File folder3 = new File("folder3");
		folder2.mkdirs();
		folder3.mkdirs();
		File[] fileList = chek(folder);
		copyFile(fileList, folder2);
		copyFileThread(fileList, folder3);
	}

	public static File[] chek(File folder) {
		ExtensionFileFilter eFF = new ExtensionFileFilter("exe");
		File[] fileList = folder.listFiles(eFF);
		return fileList;
	}

	public static void copyFile(File[] fileList, File folder) {
		long start = System.nanoTime();
		for (File in : fileList) {
			File out = new File(folder + "/" + in.getName());
			try {
				FileService.copyFile(in, out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		long end = System.nanoTime() - start;
		System.out.println("default-" + end + " nanosecond");
	}

	public static void copyFileThread(File[] fileList, File folder) {
		long start = System.nanoTime();
		Thread[] threads = new Thread[fileList.length];

		for (int i = 0; i < fileList.length; i++) {
			File in = fileList[i];
			File out = new File(folder + "/" + in.getName());
			FileServiceThread fileServiceThread = new FileServiceThread(in, out);

			threads[i] = new Thread(fileServiceThread);
			threads[i].start();

		}
		for (int i = 0; i < fileList.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long end = System.nanoTime() - start;
		System.out.println("thread -" + end + " nanosecond");
	}

}
