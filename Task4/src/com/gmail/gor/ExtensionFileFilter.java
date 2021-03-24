package com.gmail.gor;

import java.io.File;
import java.io.FileFilter;


public class ExtensionFileFilter implements FileFilter {
	private String[] array;

	public ExtensionFileFilter(String... array) {
		super();
		this.array = array;
	}


	private boolean check(String extension) {
		for (String stringExt : array) {
			if (stringExt.equals(extension)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean accept(File pathname) {
		int pointerIndex = pathname.getName().lastIndexOf(".");
		if (pointerIndex == -1) {
			return false;
		}
		String extension = pathname.getName().substring(pointerIndex + 1);
		return check(extension);

	}

}
