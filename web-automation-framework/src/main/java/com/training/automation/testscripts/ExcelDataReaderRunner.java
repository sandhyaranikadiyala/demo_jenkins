package com.training.automation.testscripts;

import java.io.File;
import java.util.List;

import com.training.automation.testscripts.ExcelDataReader.ExcelRow;

public class ExcelDataReaderRunner {
	public static void main(String[] args) {
		String userWorkingDirectory, filePath;
		userWorkingDirectory = System.getProperty("user.dir");

		String fileName = "employee.xlsx";
		filePath = userWorkingDirectory + File.separator + fileName;
		

		ExcelDataReader reader = new ExcelDataReader(filePath,"Sheet1");
		
		List<ExcelRow> rows = reader.readExcelFile("Sheet1");

		for (ExcelRow row : rows) {
			System.out.println(row);
		}
	}

}
