package com.training.automation.properties;

import org.apache.logging.log4j.*;

public class Log4JDemo {

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(Log4JDemo.class);

//	      logger.debug("Debug Message Logged !!!");
		logger.info("Info Message Logged !!!");
//	      logger.error("Error Message Logged !!!", new NullPointerException("NullError"));

	}

}
