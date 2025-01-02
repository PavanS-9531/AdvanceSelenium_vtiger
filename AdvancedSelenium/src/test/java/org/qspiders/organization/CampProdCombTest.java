package org.qspiders.organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import Generic_Utility.WindowSwitch_Util;
import POM_REPO.CampLookUp;
import POM_REPO.CampValidate;
import POM_REPO.CreateCampPage;
import POM_REPO.CreateProductPage;
import POM_REPO.HomePage;
import POM_REPO.LoginPage;
import POM_REPO.ProductLookUpImage;
import POM_REPO.WindowSwitching;

public class CampProdCombTest extends BaseClass {
	
	@Test(groups="regressionTest")
	public void campProdCombTest() throws Throwable {
		// TODO Auto-generated method stub
		Java_Utility jlib = new Java_Utility();
		Excel_Utility excel_util = new Excel_Utility();
		WebDriver_Utility driver_util = new WebDriver_Utility();
		
		
		//FileInputStream fis = new FileInputStream("./src/test/resources/organization.properties");
		
		//Properties prop = new Properties();
		//prop.load(fis);
		//=====================Get the login details=================================
		//String URL = prop.getProperty("url");
		//String USERNAME = prop.getProperty("username");
		//String PASSWORD = prop.getProperty("password");
		//String BROWSER = prop.getProperty("browser");
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
		
		int randnum=jlib.getRandomNum();
		//------------------Get product name---------------------
		String sheetname = "Product";
		int rownum = 0;
		int colnum =0;
		
		String tmpproductname = excel_util.getValueFromExcel(sheetname, rownum, colnum);
		String productname = tmpproductname+randnum;
		//=============================================================================
		//Row row2 = sheet.getRow(1);
		
		//Cell cell2 = row2.getCell(0);
		int rownum1 = 1;
		int colnum1 =0;
		String partnumber = excel_util.getValueFromExcel(sheetname, rownum1, colnum1);
		//DataFormatter formatter = new DataFormatter();
		//String partnumber = formatter.formatCellValue(cell2);
		//=============================================================================
		
			
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().window().maximize();
		driver_util.maximizeWindow(driver);
		driver_util.waitForElementToLoad(driver);
		
		//driver.get(URL);
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		//LoginPage loginpage= new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		WindowSwitching winSwitch = new WindowSwitching(driver);
		CreateProductPage CreateProd = new CreateProductPage(driver);
		ProductLookUpImage ProdLkUp = new ProductLookUpImage(driver);
		CreateCampPage CreateCamp = new CreateCampPage(driver);
		CampLookUp CreateCampButton = new CampLookUp(driver);
		CampValidate validateCamp = new CampValidate(driver);
		
		//loginpage.loginToApp(USERNAME, PASSWORD);
		Thread.sleep(3000);
		
		//driver.findElement(By.linkText("Products")).click();
		homepage.clickOnProductHome();
		
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		//driver.findElement(By.name("productname")).sendKeys(productname);
		//driver.findElement(By.id("productcode")).sendKeys(partnumber);
		
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		ProdLkUp.clickProductImage();
		CreateProd.createProduct(productname, partnumber);
		
		//===================================================================
		//=======================Read Excel values====================================
				FileInputStream fis3 = new FileInputStream("./src/test/resources/CampaignData.xlsx");
				
				Workbook workbook1 = WorkbookFactory.create(fis3);
				
				Sheet sheet2 = workbook1.getSheet("Sheet1");
				//Java_Utility jlib = new Java_Utility();
				//int randnum=jlib.getRandomNum();
				//------------------Get product name---------------------
				Row row3 = sheet2.getRow(0);
				
				Cell cell3 = row3.getCell(0);
				
				String campaignname = cell3.getStringCellValue()+randnum;
				//=============================================================================
				Row row4 = sheet2.getRow(1);
				
				Cell cell4 = row4.getCell(0);
				
				//DataFormatter formatter = new DataFormatter();
				//String partnumber = formatter.formatCellValue(cell2);
				String sponsorname = cell4.getStringCellValue();
				//=============================================================================
				
			
				//driver.findElement(By.linkText("More")).click();
				//driver.findElement(By.linkText("Campaigns")).click();
				
				homepage.clickOnCampaign();
				
				//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
				//driver.findElement(By.name("campaignname")).sendKeys(campaignname);
				//driver.findElement(By.id("sponsor")).sendKeys(sponsorname);
				
				//driver.findElement(By.cssSelector("[title='Select']")).click();
				CreateCampButton.clickCampAdd();
				CreateCamp.createCamp(campaignname, sponsorname);
				CreateCamp.clickProductButton();
				driver_util.windowSwtiching(driver, "Products&action");
				winSwitch.selectProductFromWindow(driver, productname);
				
		/*
		 * Set<String> allWin= driver.getWindowHandles();
		 * 
		 * Iterator<String> it = allWin.iterator();
		 * 
		 * while(it.hasNext()) { String Window = it.next();
		 * driver.switchTo().window(Window); String title = driver.getTitle();
		 * if(title.equalsIgnoreCase("Products&action")) { break; } }
		 */
		 
				Thread.sleep(5000);
				
				
				
				//driver_util.switchWindow(driver, "Products&action");
				Thread.sleep(5000);
			//	driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(productname);
				
				//driver.findElement(By.name("search_text")).sendKeys(productname);
			//	driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
				//driver.findElement(By.name("search")).click();
				
				//driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
				
				//=============Save and check if campaign is created or not
				//Switch to Campaign window
		/*
		 * Set<String> allWin1= driver.getWindowHandles();
		 * 
		 * Iterator<String> it1 = allWin1.iterator();
		 * 
		 * while(it1.hasNext()) { String Window1 = it1.next();
		 * driver.switchTo().window(Window1); String title1 = driver.getTitle();
		 * if(title1.equalsIgnoreCase("Campaigns&action")) { break; } }
		// */
				
				Thread.sleep(3000);
				//=================================================================
				driver_util.windowSwtiching(driver, "Campaigns&action");
				Thread.sleep(2000);
				CreateCamp.clickSaveButton();
				
				Thread.sleep(5000);
				
				//String actCamp = driver.findElement(By.id("dtlview_Campaign Name")).getText();
				
				//if(actCamp.equalsIgnoreCase(campaignname)) {
				//	System.out.println("Campaign with product is created");
				//}else {
				//	System.out.println("Campaign with product is not created");
				//}
				validateCamp.validateCampain(campaignname, driver);
				
				//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				//driver.findElement(By.linkText("Sign Out")).click();
				//homepage.signout();
				Thread.sleep(2000);
				//driver.quit();
	}

}
