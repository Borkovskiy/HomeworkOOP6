package com.gmail.gor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileService {
	public static void copyFile(File in, File out) throws IOException {
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

}
