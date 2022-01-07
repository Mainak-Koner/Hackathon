package com.policybazaar.smoke;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
	public static String[] readExcelData(String sheetName, int rowNum) throws IOException {
		
		FileInputStream readFile = new FileInputStream("src\\test\\resources\\SmokeTestDetails.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(readFile);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNum);
		
		int totalColumns = row.getLastCellNum();
		String[] stringArray = new String[totalColumns];
		
		for (Cell cell : row) {
			
			int colNum = cell.getColumnIndex();
			DataFormatter formatter = new DataFormatter();
			stringArray[colNum] = formatter.formatCellValue(cell);
			
		}
		
		workbook.close();
		return stringArray;
		
	}
	
}
