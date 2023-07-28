package com.training.automation.testscripts;

import java.util.ArrayList;
import java.util.List;

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
}


