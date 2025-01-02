package org.qspiders.DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataToExcelt {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		//Step 1: connect to excel
				FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
				
				//step2:Keep the workbook in read mode
				Workbook book = WorkbookFactory.create(fis);
				
				//Step 3: Navigates to the sheet
				Sheet sheet = book.getSheet("Sheet1");
				
				//step 4: Navigates to row
				Row row = sheet.createRow(0);
				
				//Step5 : Navigate to cell
				 Cell cell = row.createCell(0);
				 
				 //Get the cell value
				 
				cell.setCellValue("Puma");
				 
				 FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
				 
				 book.write(fos);
				 book.close();

	}

}
