package com.training.automation.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataValidation {
	public void validateData() {
		String filePath = "C:\\Users\\sandhya.kadiyala\\Desktop\\employee.xlsx";
		String sheetName = "Sheet2";
		int columnNumber = 0; 
		double minimumValue = 100; // Specify the minimum value for validation
		double maximumValue = 150; // Specify the maximum value for validation

		validateColumnData(filePath, sheetName, columnNumber, minimumValue, maximumValue);
	}

	public static void validateColumnData(String filePath, String sheetName, int columnNumber, double minValue,
			double maxValue) {
		try (FileInputStream fileInputStream = new FileInputStream(filePath);
				Workbook workbook = new XSSFWorkbook(fileInputStream)) {

			Sheet sheet = workbook.getSheet(sheetName);

			
			
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					
				
				if (cell != null && cell.getCellType() == CellType.NUMERIC) {
					double cellValue = cell.getNumericCellValue();
					System.out.println(cellValue);
				
					  if (cellValue < minValue || cellValue > maxValue) {
						  System.out.println();
	                        System.out.println("Validation failed for row " + (row.getRowNum() + 1) +
	                                ", column " + (columnNumber + 1) + ", value: " + cellValue);
	                    }
				}}}}

			

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ExcelDataValidation excelDataValidation = new ExcelDataValidation();
		excelDataValidation.validateData();

	}

}
