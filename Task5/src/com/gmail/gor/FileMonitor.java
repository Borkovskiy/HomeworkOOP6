package com.gmail.gor;

import java.io.File;

import java.util.Date;

public class FileMonitor implements Runnable {
	private File folder;
	private File[] fileList;
	private File[] fileListNew;

	public FileMonitor(File folder) {
		super();
		this.folder = folder;
	}

	public void chekFolder() {
		this.fileList = folder.listFiles();
		for (;;) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			fileListNew = folder.listFiles();
			if (fileListNew.length > fileList.length) {
				fileAdd();
			}
			if (fileListNew.length < fileList.length) {
				fileDell();
			}
		}

	}

	public void fileAdd() {

		for (File fileX : fileListNew) {

			boolean change = false;
			for (File fileY : fileList) {

				if (fileX.getName().equalsIgnoreCase(fileY.getName())) {
					change = true;
					break;
				}

			}
			if (!change) {
				Date date = new Date();
				System.out.println("File- " + fileX.getName() + " was add at " + date);

			}

		}
		fileList = fileListNew;
	}

	public void fileDell() {
		for (File fileX : fileList) {

			boolean change = false;
			for (File fileY : fileListNew) {

				if (fileX.getName().equalsIgnoreCase(fileY.getName())) {
					change = true;
					break;
				}

			}
			if (!change) {
				Date date = new Date();
				System.out.println("File- " + fileX.getName() + " was deleted at " + date);

			}

		}
		fileList = fileListNew;

	}

	@Override
	public void run() {
		chekFolder();

	}

}
