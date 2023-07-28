package com.training.automation.testscripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelStatisticalAnalysis {
	String filePath = "C:\\Users\\sandhya.kadiyala\\Desktop\\employee.xlsx";
	String sheetName = "Sheet2";
	int columnNumber = 1; // Assuming the column number starts from 0

	public void statisticalAnalysis() {
		try (FileInputStream fileInputStream = new FileInputStream(filePath);
				Workbook workbook = WorkbookFactory.create(fileInputStream)) {

			Sheet sheet = workbook.getSheet(sheetName);
			DataFormatter dataFormatter = new DataFormatter();

			double sum = 0;
			double min = Double.MAX_VALUE;
			double max = Double.MIN_VALUE;
			int count = 0;

			for (Row row : sheet) {
				Cell cell = row.getCell(columnNumber);
				if (cell != null) {
					String cellValue = dataFormatter.formatCellValue(cell);
					try {
						double value = Double.parseDouble(cellValue);
						sum += value;
						min = Math.min(min, value);
						max = Math.max(max, value);
						count++;
					} catch (NumberFormatException ignored) {

					}
				}
			}

			double average = sum / count;

			System.out.println("Statistical analysis for column " + columnNumber + ":");
			System.out.println("Minimum value: " + min);
			System.out.println("Maximum value: " + max);
			System.out.println("Average value: " + average);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ExcelStatisticalAnalysis excelStatisticalAnalysis = new ExcelStatisticalAnalysis();
		excelStatisticalAnalysis.statisticalAnalysis();
	}
}
