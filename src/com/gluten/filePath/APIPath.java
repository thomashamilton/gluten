package com.gluten.filePath;

import java.io.File;

public interface APIPath {
	
	File HOME = new File(System.getProperty("HOME", "C:/Users/Chris/Desktop"));

//	File DATA_DIR = new File(HOME, "data");
	
	File USER_XML = new File(HOME, "user.xml");
	File USER_JSON = new File(HOME, "user.json");

}
