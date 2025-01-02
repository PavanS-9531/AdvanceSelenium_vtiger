package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class File_Utility {
	/**
	 * This method is used to read from properties file
	 * @param Key
	 * @return
	 * @throws Throwable
	 */
	
	public String getKeyAndValuePair(String Key) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstant.filePath);
		//Step2 :- Create object of Properties class
		Properties prop = new Properties();
		
		//Step 3 : Load all the Keys
		prop.load(fis);
		String value = prop.getProperty(Key);
		return value;
	}
	
	
}
