package com.training.automation.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class is used to perform excel handling to read excel file,calculate
 * average and search word.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class ExcelFileReader {

	/**
	 * This method is used to read the excel file and display the content file to
	 * console.
	 * 
	 * @throws IOException
	 */
	public void readExcelFile(String filePath) {
		File file = new File(filePath);
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {

					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;

					case STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					default:
						break;
					}
				}
				workbook.close();
				System.out.println("");
			}
		}

		catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	/**
	 * This method is used to return the total number of rows in the excel file.
	 */
	public void numberOfRows(String filePath) {

		int rowCount = getRowCount(filePath);
		System.out.println("Total number of rows in the file: " + rowCount);
	}

	private static int getRowCount(String filePath) {
		int rowCount = 0;

		try (FileInputStream fileInputStream = new FileInputStream(new File(filePath))) {
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheetAt(0);
			rowCount = sheet.getLastRowNum() + 1;
			workbook.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

		return rowCount;
	}

	/**
	 * This method is used to read the excel file and extract the data from a
	 * specific sheet.
	 * 
	 * @throws IOException
	 */
	public void extractExcelData(String filePath, String sheetName) {
		if (sheetName.length()==0 || sheetName==null) {
			System.out.println("Please provide a valid sheet name");
			return;
		}
		
		File file = new File(filePath);
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

			XSSFSheet sheet = workbook.getSheet(sheetName);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {

					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;

					case STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					default:
						break;
					}
				}
				workbook.close();

				System.out.println("");
			}
		}

		catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();

		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

	}

	/**
	 * This method is used to reads an excel file and calculates the average value
	 * of a specific column,display the average value on the console.
	 * 
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void calculateAverage(String filePath, String sheetName) throws FileNotFoundException {

		Workbook workbook;
		try {
			workbook = WorkbookFactory.create(new FileInputStream(filePath));

			Sheet sheet = workbook.getSheet(sheetName);

			int columnIndex = 1;

			double sum = 0;
			int count = 0;

			for (Row row : sheet) {

				Cell cell = row.getCell(columnIndex);
				if (cell != null && cell.getCellType() == CellType.NUMERIC) {
					sum += cell.getNumericCellValue();
					count++;

				}
			}

			double average = sum / count;

			System.out.println("Average value: " + average);
		} catch (EncryptedDocumentException | IOException exception) {

			exception.printStackTrace();
		}

	}

	/**
	 * This method is used to reads an excel file and performs data validation on a
	 * specific column.
	 */
	public void validateData(String filePath, String sheetName, int columnNumber, double minimumValue,
			double maximumValue) {

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
							System.out.println("Validation failed for row " + (row.getRowNum() + 1) + ", column "
									+ (columnNumber + 1) + ", value: " + cellValue);
						}
					}
				}
			}
		}

		catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	/**
	 * This method is used to reads an excel file and searches for a specific value
	 * in a column,display the row(s) containing the searched value on the console
	 * 
	 * @throws IOException
	 */
	public void searchWord(String filePath, String sheetName, String searchWord) {

		try (Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath))) {
			Sheet sheet = workbook.getSheet(sheetName);

			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					if (cell != null && cell.getCellType() == CellType.STRING) {
						String value = cell.getStringCellValue();

						if (value.equals(searchWord)) {
							System.out.println("Found at row " + (row.getRowNum() + 1));

//						System.out.println("Row: " + row.toString());

						}

					} else {
						System.out.println("The given word does not match with file");
					}
				}

			}

		}

		catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	/**
	 * This is main method to create object for class and call the methods.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ExcelFileReader excelFileReding = new ExcelFileReader();
		String userWorkingDirectory, filePath;
		userWorkingDirectory = System.getProperty("user.dir");

		String fileName = "employee.xlsx";
		filePath = userWorkingDirectory + File.separator + fileName;
//		excelFileReding.readExcelFile("");
//		 excelFileReding.numberOfRows(filePath);
		excelFileReding.extractExcelData(filePath, "");
//		excelFileReding.calculateAverage(filePath, "Sheet2");
//		excelFileReding.searchWord(filePath, "Sheet2", "hi");
//		excelFileReding.validateData(filePath, "Sheet2",0,100,150);

	}
}
