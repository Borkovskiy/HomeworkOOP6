package com.gmail.gor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileServiceThread implements Runnable {
	private File in;
	private File out;

	public FileServiceThread(File in, File out) {
		super();
		this.in = in;
		this.out = out;
	}

	public void copyFile() throws IOException {
		try (FileInputStream fis = new FileInputStream(in); FileOutputStream fos = new FileOutputStream(out)) {
			byte[] buffer = new byte[1000000];
			int readByte = 0;
			for (;;) {
				readByte = fis.read(buffer);
				if (readByte <= 0) {
					break;
				}
				fos.write(buffer, 0, readByte);
			}
		}

	}

	@Override
	public void run() {
		try {
			copyFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
