package com.training.automation.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to read an excel file and return the data as a collection
 * of objects representing each row.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class ExcelDataReader {
	private String filePath;

	public ExcelDataReader(String filePath,String sheetName) {
		this.filePath = filePath;
	}

	public List<ExcelRow> readExcelFile(String sheetName) {
		List<ExcelRow> rows = new ArrayList<>();

		try (FileInputStream fileInputStream = new FileInputStream(filePath);
				Workbook workbook = WorkbookFactory.create(fileInputStream)) {

			Sheet sheet = workbook.getSheet(sheetName);

			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				ExcelRow excelRow = new ExcelRow();

				Iterator<Cell> cellIterator = row.iterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case STRING:
						excelRow.addCell(cell.getStringCellValue());
						break;
					case NUMERIC:
						excelRow.addCell(cell.getNumericCellValue());
						break;
					case BOOLEAN:
						excelRow.addCell(cell.getBooleanCellValue());
						break;
					case BLANK:
						excelRow.addCell("");
						break;
					default:
						excelRow.addCell("");
						break;
					}
				}

				rows.add(excelRow);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return rows;
	}
	
	
	public class ExcelRow {
		private List<Object> cells;

		public ExcelRow() {
			cells = new ArrayList<>();
		}

		public void addCell(Object cellValue) {
			cells.add(cellValue);
		}

		@Override
		public String toString() {
			return cells.toString();
		}
	
	}}
