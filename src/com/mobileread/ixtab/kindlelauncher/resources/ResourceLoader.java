package com.mobileread.ixtab.kindlelauncher.resources;

import java.io.InputStream;

public class ResourceLoader {
	public static InputStream load(String name) {
		return ResourceLoader.class.getResourceAsStream(name);
	}
}
