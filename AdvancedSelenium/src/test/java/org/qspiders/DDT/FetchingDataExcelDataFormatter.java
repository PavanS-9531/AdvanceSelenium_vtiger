package org.qspiders.DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.*;

public class FetchingDataExcelDataFormatter {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet3 = book.getSheet("Sheet3");
		
		Row row = sheet3.getRow(0);
		
		Cell cell = row.getCell(0);
		
		DataFormatter format = new DataFormatter();
		String excelData = format.formatCellValue(cell);
		System.out.println(excelData);
	}

}
