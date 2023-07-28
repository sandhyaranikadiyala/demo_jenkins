//package com.training.automation.testscripts;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//
//
//public class ExcelAverageValue {
//
//	public void calculateAverage() {
//		String filePath = "C:\\Users\\sandhya.kadiyala\\Desktop\\employee.xlsx";
//        String sheetName = "Sheet1";
//        int columnNumber = 2; // Specify the column number (starting from 0)
//
//        double average = calculateColumnAverage(filePath, sheetName, columnNumber);
//
//        System.out.println("Average value of column " + columnNumber + ": " + average);
//	}
//
//    public static double calculateColumnAverage(String filePath, String sheetName, int columnNumber) {
//        double sum = 0;
//        int count = 0;
//
//        FileInputStream fis = new FileInputStream(filePath);
//             Workbook workbook = new XSSFWorkbook(fis);
//
//            Sheet sheet = workbook.getSheet(sheetName);
//
//            // Iterate over the rows of the sheet
//            for (Row row : sheet) {
//                Cell cell = row.getCell(columnNumber);
//
//                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
//                    sum += cell.getNumericCellValue();
//                    count++;
//                    return sum/count;
//                }
//            }
//
//        } 
//
//      
//    
//			    }
//}
//
//
//
//
