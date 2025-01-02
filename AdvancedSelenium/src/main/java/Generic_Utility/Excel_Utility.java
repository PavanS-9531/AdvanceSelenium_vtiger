package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	DataFormatter formatter;
	final String filepath = IPathConstant.excelpath;
	final String filepathDP = IPathConstant.excelpathDP;
	/**
	 * This method reads from excel and returns the string value
	 * @param sheetname
	 * @param rownum
	 * @param colnum
	 * @return
	 * @throws Throwable
	 */
	public String getValueFromExcel(String sheetname, int rownum, int colnum) throws Throwable {
		String excelvalue;
		FileInputStream fis2 = new FileInputStream(filepath);
		
		Workbook workbook = WorkbookFactory.create(fis2);
		
		Sheet sheet = workbook.getSheet(sheetname);
		
		Row row = sheet.getRow(rownum);
		
		Cell cell = row.getCell(colnum);
		if(cell.getCellType()!=CellType.STRING) {
			formatter = new DataFormatter();
			excelvalue=formatter.formatCellValue(cell);
			//break;
		}else {
			excelvalue = cell.getStringCellValue();
		}
		
		return excelvalue;
		
	}
	
	public String getValueFromExcelDataFormatter(String sheetname, int rownum, int colnum) throws Throwable {
		String excelvalue;
		FileInputStream fis2 = new FileInputStream(filepath);
		
		Workbook workbook = WorkbookFactory.create(fis2);
		
		Sheet sheet = workbook.getSheet(sheetname);
		
		Row row = sheet.getRow(rownum);
		
		Cell cell = row.getCell(colnum);
		DataFormatter formatter = new DataFormatter();
		excelvalue=formatter.formatCellValue(cell);
		
		return excelvalue;
	}
	/**
	 * This method reads from excel and feeds to the data provider
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	
	public Object[][] readDataForDataProvider(String sheetname) throws Throwable{
				
		FileInputStream fis2 = new FileInputStream(filepathDP);
		
		Workbook workbook = WorkbookFactory.create(fis2);
		
		Sheet sheet = workbook.getSheet(sheetname);
		
		int lastrow= sheet.getLastRowNum()+1;
		
		int lastcell=sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastrow][lastcell];
		
		for(int i=0; i<lastrow ; i++) {
			for (int j=0;j<lastcell; j++) {
				objArr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return objArr;
	}

	
	
	
}
