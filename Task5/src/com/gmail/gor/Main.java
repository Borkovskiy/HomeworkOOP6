package com.gmail.gor;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File folder = new File(".");
		FileMonitor fileMonitor= new FileMonitor(folder);
		Thread thread= new Thread(fileMonitor);
		thread.start();
		
		
	}

}
