package com.training.automation.properties;

import java.io.File;

/**
 * This is Runner class which has main method.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class Runner {
	/**
	 * This is main method create object for class and call the methods.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PropertiesReader propertiesReader = new PropertiesReader();
		String userWorkingDirectory, filePath, filePath1, filePath2;
		userWorkingDirectory = System.getProperty("user.dir");

		String fileName = "sample.properties";
		String fileName1 = "sample1.properties";
		String fileName2 = "sample2.properties";
		filePath = userWorkingDirectory + File.separator + fileName;
		filePath1 = userWorkingDirectory + File.separator + fileName1;
		filePath2 = userWorkingDirectory + File.separator + fileName2;
//		propertiesReader.readPropertyFile("");
//		propertiesReader.getPropertyFromFile(filePath, "");
//		propertiesReader.verifyKey(filePath,null);

//		propertiesReader.searchPrifix(filePath, "");

		PropertiesMerger propertiesMerger = new PropertiesMerger();

		propertiesMerger.mergedFiles(fileName, fileName1, fileName2);
		propertiesMerger.displayMergedProperties();

	}

}
