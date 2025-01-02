package org.qspiders.contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_REPO.ContactValidate;
import POM_REPO.CreateContactPage;
import POM_REPO.CreateProductPage;
import POM_REPO.HomePage;
import POM_REPO.LoginPage;
import POM_REPO.ProductLookUpImage;
import POM_REPO.ProductValidationPage;

public class CreateContactTest extends BaseClass {
	@Test(groups= {"smokeTest","sanityTest"})
	public void createContactTest() throws Throwable {
		//WebDriver driver;
		WebDriver_Utility driver_util = new WebDriver_Utility();
		// TODO Auto-generated method stub
		//============================================================
		//Read login properties from file
		//FileInputStream fis = new FileInputStream("./src/test/resources/organization.properties");
		//Properties prop = new Properties();
		//prop.load(fis);
		
		//String USERNAME = prop.getProperty("username");
		//String PASSWORD = prop.getProperty("password");
		//String URL = prop.getProperty("url");
		//String BROWSER = prop.getProperty("browser");
		//File_Utility flib = new File_Utility();
		//String URL = flib.getKeyAndValuePair("url");
		//String USERNAME = flib.getKeyAndValuePair("username");
		//String PASSWORD = flib.getKeyAndValuePair("password");
		//String BROWSER=flib.getKeyAndValuePair("browser");
		Excel_Utility excel_util = new Excel_Utility();
		Java_Utility jutil = new Java_Utility();
		//============================================================
		//Read test data from XL file
		//FileInputStream fis2 = new FileInputStream("src/test/resources/TestData7.xlsx");
		
		//Workbook book = WorkbookFactory.create(fis2);
		
		//Sheet sheet = book.getSheet("Contacts");
		
		//Row row = sheet.getRow(0);
		
		//Cell cell = row.getCell(0);
		//String firstname = cell.getStringCellValue();
		String sheetname = "Contacts";
		int rownum = 0;
		int colnum =0;
		
		String firstname = excel_util.getValueFromExcel(sheetname, rownum, colnum);
		
		//------------------Get Salutation from excel-------------------
		//Row row1 = sheet.getRow(1);
		
		//Cell cell1 = row1.getCell(0);
		
		//String salutation = cell1.getStringCellValue();
		int rownum1 = 1;
		int colnum1 =0;
		String salutation = excel_util.getValueFromExcel(sheetname, rownum1, colnum1);
		//-----------------Get Last name from excel-------------------------
		//Random ran = new Random();
		//int rannum = ran.nextInt(1000);
		//Row row2 = sheet.getRow(2);
		
		//Cell cell2 = row2.getCell(0);
		
		//String lastname = cell2.getStringCellValue()+rannum;
		int rannum = jutil.getRandomNum();
		int rownum2 = 2;
		int colnum2 =0;
		
		String lastname = excel_util.getValueFromExcel(sheetname, rownum2, colnum2)+rannum;
		//=====================================================================
		/*
		 * if(BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver();
		 * 
		 * }else if(BROWSER.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver();
		 * 
		 * }else { driver = new ChromeDriver(); }
		 */
		
		//driver.get(URL);
		//driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver_util.waitForElementToLoad(driver);
		//driver_util.maximizeWindow(driver);
		
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		//LoginPage loginpage= new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		//loginpage.loginToApp(USERNAME, PASSWORD);
		Thread.sleep(3000);
		
		//driver.findElement(By.linkText("Contacts")).click();
		homepage.clickOnContacts();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//===============Select salutation from drop down=================
		WebElement salutationdd = driver.findElement(By.name("salutationtype"));
		//Select s = new Select(salutationdd);
		//s.selectByValue(salutation);
		driver_util.selectFromDDByValue(salutationdd, salutation);
		//============================================================
		//driver.findElement(By.name("firstname")).sendKeys(firstname);
		//driver.findElement(By.name("lastname")).sendKeys(lastname);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreateContactPage CCPage = new CreateContactPage(driver);
		ContactValidate CPage = new ContactValidate(driver);
		
		CCPage.createContact(firstname, lastname);
		CCPage.clickContactSaveBtn();
		CPage.validateContact(driver, firstname, lastname);
		
		//String actcontactfirname = driver.findElement(By.id("dtlview_First Name")).getText();
		//String actcontactlastname = driver.findElement(By.id("mouseArea_Last Name")).getText();
		
		//String expfirstname = salutation.trim()+" "+firstname;
		
		//if(actcontactfirname.equalsIgnoreCase(firstname) && actcontactlastname.trim().equalsIgnoreCase(lastname)) {
		//	System.out.println("Contact is created");
		//}else {
		//	System.out.println("Contact is not created");
		//}
		
		
		//homepage.signout();//These are implemented in @AfterClass and @AFter method
		//driver.quit();
		
		
		

	}
	
	

}
