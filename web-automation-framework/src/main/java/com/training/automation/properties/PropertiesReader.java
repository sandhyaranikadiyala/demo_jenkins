package com.training.automation.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.*;

/**
 * This class is used to read the data from property files.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class PropertiesReader {
	private static final Logger logger = LogManager.getLogger(PropertiesReader.class);

	/**
	 * This method is used to reads a properties file and displays all the key-value
	 * pairs on the console.
	 * 
	 * @param filePath
	 */
	public void readPropertyFile(String filePath) {

		Properties properties = new Properties();

		try {
			logger.log(Level.INFO, "Reading property file and display data with provided file name");
			FileInputStream fileInputStream = new FileInputStream(filePath);
			properties.load(fileInputStream);
			if (properties.isEmpty()) {
				System.out.println("No key-value pairs found in the properties file.");
			} else {
				System.out.println("Key-Value Pairs:");
				for (String key : properties.stringPropertyNames()) {
					String value = properties.getProperty(key);
					System.out.println(key + " = " + value);

				}
			}

		} catch (FileNotFoundException fileNotFoundException) {
			logger.log(Level.WARN, "An error occurred while reading the properties file.",
					fileNotFoundException.getLocalizedMessage());

		} catch (IOException ioException) {
			logger.log(Level.WARN, "An error occurred while reading the properties file.", ioException);
		}
	}

	/**
	 * This method is used from property files taking key as inputs, and returns the
	 * corresponding value from the properties file.
	 * 
	 * @param filePath
	 * @param key
	 */
	public void getPropertyFromFile(String filePath, String key) {
		Properties properties = new Properties();

		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(filePath);
			properties.load(fileInputStream);
			String value = properties.getProperty(key);

			if (value == null) {
				logger.log(Level.WARN, "Value for key '" + key + "' not found in the properties file.");
				System.out.println("please provide a valid key");
			} else {
				logger.log(Level.INFO, "Value for key '" + key + "' = " + value);
				System.out.println("Value for key '" + key + "': " + value);
			}

		} catch (FileNotFoundException fileNotFoundException) {
			logger.log(Level.WARN, "An error occurred while reading the properties file.", fileNotFoundException);

		}
		
		catch (IOException ioException) {
			logger.log(Level.WARN, "An error occurred while reading the properties file.", ioException);
		}
	}

	/**
	 * This method is used to reads a properties file and checks if a specific key
	 * exists in the file,display a message indicating whether the key is found or
	 * not.
	 * 
	 * @param filePath
	 * @param key
	 */
	public void verifyKey(String filePath, String key) {
		Properties properties = new Properties();

		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(filePath);
			properties.load(fileInputStream);

			if (properties.containsKey(key)) {
				logger.log(Level.INFO, "Key '" + key + "' exists in the properties file.");
				System.out.println("Key '" + key + "' exists in the properties file.");

			} else {
				logger.log(Level.WARN, "Key '" + key + "' not found in the properties file.");
				System.out.println("Key '" + key + "' does not exist in the properties file.");
			}

		} catch (FileNotFoundException fileNotFoundException) {
			logger.log(Level.WARN, "An error occurred while reading the properties file.", fileNotFoundException);

//			System.out.println(fileNotFoundException);
		}
		
		catch (IOException ioException) {
			logger.log(Level.WARN, "An error occurred while reading the properties file.", ioException);

//			System.out.println(ioException);
		}
		catch (Exception exception) {
			logger.error(exception);
			
		}

	}

	/**
	 * This method is used to reads a properties file and extracts all the keys
	 * starting with a specific prefix.
	 * 
	 * @param filePath
	 * @param prifix
	 */
	public void searchPrifix(String filePath, String prifix) {

		Properties properties = new Properties();

		boolean foundKeys = false;
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			properties.load(fileInputStream);
			for (String key : properties.stringPropertyNames()) {
				if ((key.startsWith(prifix))) {
					String value = properties.getProperty(key);
					System.out.println(key + " = " + value);
					foundKeys = true;
				}

			}
			if (!foundKeys) {
				logger.log(Level.WARN, "Keys with '" + prifix + "' not found in the properties file.");
				System.out.println("No keys found with prefix: " + prifix);
			}

		} catch (FileNotFoundException fileNotFoundException) {
			logger.log(Level.WARN, "An error occurred while reading the properties file.", fileNotFoundException);


		} catch (IOException ioException) {
			logger.log(Level.WARN, "An error occurred while reading the properties file.", ioException);


		}

	}

}
