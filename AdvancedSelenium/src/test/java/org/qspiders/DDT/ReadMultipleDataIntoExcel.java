package org.qspiders.DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataIntoExcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet("Sheet2");
		
		List<String> links = new ArrayList<String>();
		Row row;
		Cell cell;
		for(int rowIndex=0; rowIndex<=sheet.getLastRowNum();rowIndex++) {
			
			row = sheet.getRow(rowIndex);
			cell = row.getCell(0);
			links.add(cell.getStringCellValue());
		}
		
		for(String b: links) {
			System.out.println(b);
		}
		System.out.println("Number of links : " +links.size());
		

	}

}
