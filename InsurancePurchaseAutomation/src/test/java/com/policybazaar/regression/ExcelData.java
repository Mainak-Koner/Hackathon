package com.policybazaar.regression;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
	public static String[][] readExcelData(String sheetName) throws IOException {
		
		FileInputStream readFile = new FileInputStream("src\\test\\resources\\RegressionTestDetails.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(readFile);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int totalRows = sheet.getLastRowNum();
		int totalColumns = sheet.getRow(0).getLastCellNum();
		
		String[][] sheetData = new String[totalRows][totalColumns];
		
		for (int i = 1; i <= totalRows; i ++) {
			
			Row row = sheet.getRow(i);
			
			for (Cell cell : row) {
				
				int colNum = cell.getColumnIndex();
				
				DataFormatter formatter = new DataFormatter();
				sheetData[i-1][colNum] = formatter.formatCellValue(cell);
			}
		}
		
		workbook.close();
		return sheetData;
		
	}
	
}
