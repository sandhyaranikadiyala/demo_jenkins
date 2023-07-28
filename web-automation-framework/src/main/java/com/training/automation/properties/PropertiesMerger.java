package com.training.automation.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.*;

/**
 * This class is used to read multiple properties files and merge them into a
 * single Properties object.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class PropertiesMerger {
	private static final Logger logger = LogManager.getLogger(PropertiesMerger.class);
	private Properties mergedProperties;

	public PropertiesMerger() {
		mergedProperties = new Properties();
	}

	public void mergedFiles(String... filePaths) {

		Properties mergedProperties = new Properties();

		for (String filePath : filePaths) {
			Properties properties = new Properties();
			try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
				properties.load(fileInputStream);
				mergedProperties.putAll(properties);
				
			} catch (IOException ioException) {
				logger.log(Level.WARN, "An error occurred while reading the properties file.", ioException);
//				System.out.println(ioException);

			}
		}
		System.out.println(mergedProperties);

	}

	public void displayMergedProperties() {
		logger.log(Level.INFO, "Merged Properties:");
		mergedProperties.forEach((key, value) -> System.out.println(key + " = " + value));

	}

}
