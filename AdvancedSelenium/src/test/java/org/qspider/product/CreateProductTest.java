package org.qspider.product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_REPO.CreateProductPage;
import POM_REPO.HomePage;
import POM_REPO.LoginPage;
import POM_REPO.ProductLookUpImage;
import POM_REPO.ProductValidationPage;

@Listeners(Generic_Utility.ExtentReportConfig.class)
public class CreateProductTest extends BaseClass{
	@Test(groups ="smokeTest")
	public void createProductTest() throws Throwable {
		// TODO Auto-generated method stub
		//WebDriver driver;//This is coming from Base class
		//FileInputStream fis = new FileInputStream("./src/test/resources/organization.properties");
		
		//Properties prop = new Properties();
		//prop.load(fis);
		//=====================Get the login details=================================
		//String URL = prop.getProperty("url");
		//String USERNAME = prop.getProperty("username");
		//String PASSWORD = prop.getProperty("password");
		//String BROWSER = prop.getProperty("browser");
		WebDriver_Utility driver_util = new WebDriver_Utility();
		//File_Utility flib = new File_Utility();
		//String URL = flib.getKeyAndValuePair("url");
		//String USERNAME = flib.getKeyAndValuePair("username");
		//String PASSWORD = flib.getKeyAndValuePair("password");
		//String BROWSER=flib.getKeyAndValuePair("browser");
		//============================================================================
		//=======================Read Excel values====================================
		//FileInputStream fis2 = new FileInputStream("./src/test/resources/TestProduct.xlsx");
		
		//Workbook workbook = WorkbookFactory.create(fis2);
		
		//Sheet sheet = workbook.getSheet("Sheet1");
		//Java_Utility jlib = new Java_Utility();
		Excel_Utility excel_util = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		String sheetname = "Product";
		int randnum=jlib.getRandomNum();
		//------------------Get product name---------------------
		//Row row1 = sheet.getRow(0);
		
		//Cell cell1 = row1.getCell(0);
		
		
		int rownum = 0;
		int colnum =0;
		
		String productname = excel_util.getValueFromExcel(sheetname, rownum, colnum)+randnum;
		//=============================================================================
		//Row row2 = sheet.getRow(1);
		
		//Cell cell2 = row2.getCell(0);
		
		//DataFormatter formatter = new DataFormatter();
		//String partnumber = formatter.formatCellValue(cell2);
		int rownum1 = 1;
		int colnum1 =0;
		String partnumber = excel_util.getValueFromExcel(sheetname, rownum1, colnum1);
		//=============================================================================
		
		/*
		 * if(BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver();
		 * 
		 * }else if(BROWSER.equalsIgnoreCase("firefox")){ driver = new FirefoxDriver();
		 * }else { driver = new ChromeDriver(); }
		 */
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().window().maximize();
		//driver_util.waitForElementToLoad(driver);
		//driver_util.maximizeWindow(driver);
		//driver.get(URL);
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		//LoginPage loginpage= new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		ProductLookUpImage PLImage = new ProductLookUpImage(driver);
		CreateProductPage Cprod = new CreateProductPage(driver);
		ProductValidationPage ProdValidPage =new ProductValidationPage(driver);
		//loginpage.loginToApp(USERNAME, PASSWORD);
		Thread.sleep(3000);
		
		//driver.findElement(By.linkText("Products")).click();
		homepage.clickOnProductHome();
		//Assert.fail();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		//driver.findElement(By.name("productname")).sendKeys(productname);
		//driver.findElement(By.id("productcode")).sendKeys(partnumber);
		
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		PLImage.clickProductImage();
		Cprod.createProduct(productname, partnumber);
		Thread.sleep(5000);
		
		//String productCreated = driver.findElement(By.id("dtlview_Product Name")).getText();
		//if(productCreated.equalsIgnoreCase(productname)) {
		//	System.out.println("Product is created");
		//}else {
		//	System.out.println("Product is not created");
		//}
		
		ProdValidPage.validateProduct(driver, productname);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		//homepage.signout();
		Thread.sleep(2000);
		//driver.quit();

	}

}
