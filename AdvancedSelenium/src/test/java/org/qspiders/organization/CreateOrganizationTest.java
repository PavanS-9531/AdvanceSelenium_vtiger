package org.qspiders.organization;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_REPO.CreateOrgPage;
import POM_REPO.CreateOrgValidate;
import POM_REPO.HomePage;
import POM_REPO.LoginPage;

public class CreateOrganizationTest extends BaseClass {
	
	
	//String URL ="http://localhost:8888/index.php?action=Login&module=Users";
	
	@Test(groups="sanityTest")
	public void createOrganizationTest() throws Throwable {
		//WebDriver driver;
		/*
		 * FileInputStream fis = new
		 * FileInputStream("./src/test/resources/organization.properties"); //Step2 :-
		 * Create object of Properties class Properties prop = new Properties();
		 * 
		 * 
		 * //Step 3 : Load all the Keys prop.load(fis);
		 */
		
	    
	    //String URL = prop.getProperty("url");
		//String Username = prop.getProperty("username");
		//String Password =prop.getProperty("password");
		//String Browser=prop.getProperty("browser");
		WebDriver_Utility driver_util = new WebDriver_Utility();
		//File_Utility flib = new File_Utility();
		
		//String URL = flib.getKeyAndValuePair("url");
		//String Username = flib.getKeyAndValuePair("username");
		//String Password = flib.getKeyAndValuePair("password");
		/*
		 * String Browser=flib.getKeyAndValuePair("browser");
		 * 
		 * if(Browser.equalsIgnoreCase("chrome")) { driver = new ChromeDriver();
		 * 
		 * }else if(Browser.equalsIgnoreCase("firefox")){ driver = new FirefoxDriver();
		 * }else { driver = new ChromeDriver(); }
		 */
		
		Java_Utility jlib = new Java_Utility();
		Excel_Utility excel_util = new Excel_Utility();
		int ranNum=jlib.getRandomNum();
		//=================================================
		//Step 1: connect to excel
				//FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData7.xlsx");
				
				//step2:Keep the workbook in read mode
				//Workbook book = WorkbookFactory.create(fis1);
				
				//Step 3: Navigates to the sheet
				//Sheet sheet = book.getSheet("Sheet1");
				
				//step 4: Navigates to row
				//Row row = sheet.getRow(0);
				
				//Step5 : Navigate to cell
				 //Cell cell = row.getCell(0);
				 
				 //Get the cell value
		String sheetname = "Sheet1";
		int rownum = 0;
		int colnum =0;
				 
		String Orgname = excel_util.getValueFromExcel(sheetname, rownum, colnum)+ranNum;
		//==============================================================================================
				 //Row row1 = sheet.getRow(1);
					
					//Step5 : Navigate to cell
					 //Cell cell1 = row1.getCell(0);
					 
					 //Get the cell value
					// DataFormatter format = new DataFormatter();
		int rownum1 = 1;
		int colnum1 =0;
					 
		String phone =excel_util.getValueFromExcel(sheetname, rownum1, colnum1);
		//==============================================================================================
					// Row row3 = sheet.getRow(2);
						
						//Step5 : Navigate to cell
						// Cell cell2 = row3.getCell(0);
						 
						 //Get the cell value
						 
						 //String email = cell2.getStringCellValue();
		
		int rownum2 = 2;
		int colnum2 =0;
		String email = 	excel_util.getValueFromExcel(sheetname, rownum2, colnum2);
			
			//======================================================================================================
				
		
		//Step4: read keys using the method getProperty method
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver_util.waitForElementToLoad(driver);
		//driver_util.maximizeWindow(driver);
		//driver.get(URL);
		//driver.findElement(By.name("user_name")).sendKeys(Username);
		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);
		//driver.findElement(By.id("submitButton")).click();
		//LoginPage loginpage= new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateOrgPage CreateOrg = new CreateOrgPage(driver);
		CreateOrgValidate COrgValidate = new CreateOrgValidate(driver);
		//loginpage.loginToApp(Username, Password);
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//a[contains(text(),'Organizations')]")).click();
		homepage.clickOnOrg();
		//driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		//driver.findElement(By.name("accountname")).sendKeys(Orgname);
		//driver.findElement(By.id("phone")).sendKeys(phone);
		//driver.findElement(By.id("email1")).sendKeys(email);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreateOrg.createOrganization(Orgname, phone, email);
		
		Thread.sleep(5000);
		COrgValidate.validateOrg(driver,Orgname);
		//String actData = driver.findElement(By.id("dtlview_Organization Name")).getText();
		//if(actData.equalsIgnoreCase(Orgname)) {
		//	System.out.println("Organization is created");
		//}else {
		//	System.out.println("Organization not created");
		//}
		
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		//homepage.signout();
		Thread.sleep(2000);
		//driver.quit();
		
	}

	

}
