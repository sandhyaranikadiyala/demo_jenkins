package com.training.automation.testscripts;

import java.io.File;

public class Filepath {

	public static void main(String[] args) {
		
		 String userWorkingDirectory,filePath; 
		 userWorkingDirectory = System.getProperty("user.dir");
		
		 String fileName="employee.xlsx";
		filePath = userWorkingDirectory + File.separator + fileName ;
		 System.out.println(filePath);

	}

}
