package org.qspiders.organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_REPO.CampLookUp;
import POM_REPO.CampValidate;
import POM_REPO.CreateCampPage;
import POM_REPO.HomePage;
import POM_REPO.LoginPage;
@Listeners(Generic_Utility.ExtentReportConfig.class)
public class CreateCampaignTest extends BaseClass{
	//@Test(groups="sanityTest")
	@Test(retryAnalyzer = Generic_Utility.RetryConfig.class, groups="sanityTest")
	public void createCampaignTest() throws Throwable {
		// TODO Auto-generated method stub
		//WebDriver driver;
		Actions action;
		Excel_Utility excel_util = new Excel_Utility();
		//File_Utility flib = new File_Utility();
		WebDriver_Utility driver_util = new WebDriver_Utility();
		//FileInputStream fis = new FileInputStream("./src/test/resources/organization.properties");
		
		//Properties prop = new Properties();
		//prop.load(fis);
		//=====================Get the login details=================================
		//String URL = prop.getProperty("url");
		//String USERNAME = prop.getProperty("username");
		//String PASSWORD = prop.getProperty("password");
		//String BROWSER = prop.getProperty("browser");
		
		//String URL = flib.getKeyAndValuePair("url");
		//String USERNAME = flib.getKeyAndValuePair("username");
		//String PASSWORD = flib.getKeyAndValuePair("password");
		//String BROWSER=flib.getKeyAndValuePair("browser");
		//============================================================================
		//=======================Read Excel values====================================
		//FileInputStream fis2 = new FileInputStream("./src/test/resources/CampaignData.xlsx");
		//String filepath = "./src/test/resources/CampaignData.xlsx";
		String sheetname = "Campaign";
		int rownum = 0;
		int colnum =0;
		//Workbook workbook = WorkbookFactory.create(fis2);
		
		//Sheet sheet = workbook.getSheet("Sheet1");
		Java_Utility jlib = new Java_Utility();
		int randnum=jlib.getRandomNum();
		//------------------Get product name---------------------
		//Row row1 = sheet.getRow(0);
		
		//Cell cell1 = row1.getCell(0);
		
		//String campaignname = cell1.getStringCellValue()+randnum;
		
		String tmpcampaignname = excel_util.getValueFromExcel(sheetname, rownum, colnum);
		String campaignname = tmpcampaignname + randnum;
		//=============================================================================
		//Row row2 = sheet.getRow(1);
		
		//Cell cell2 = row2.getCell(0);
		
		//DataFormatter formatter = new DataFormatter();
		//String partnumber = formatter.formatCellValue(cell2);
		//String sponsorname = cell2.getStringCellValue();
		
		int rownum1 = 1;
		int colnum1 =0;
		String sponsorname = excel_util.getValueFromExcel(sheetname, rownum1, colnum1);
		//=============================================================================
		
		
		/*
		 * if(BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver();
		 * 
		 * }else if(BROWSER.equalsIgnoreCase("firefox")){ driver = new FirefoxDriver();
		 * }else { driver = new ChromeDriver(); }
		 */
		 
		//WebDriver driver =driver_util.getDriver(BROWSER);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().window().maximize();
		
		//driver.get(URL);
		//driver_util.waitForElementToLoad(driver);
		//driver_util.maximizeWindow(driver);
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		//LoginPage loginpage= new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CampLookUp camplookup = new CampLookUp(driver);
		CreateCampPage addcamp = new CreateCampPage(driver);
		CampValidate campValid = new CampValidate(driver);
		//loginpage.getUserTextField().sendKeys("admin");
		//loginpage.getPasswordTextField().sendKeys("admin");
		//loginpage.getLoginButton().click();
		//loginpage.loginToApp(USERNAME, PASSWORD);
		homepage.clickOnCampaign();
		
		Thread.sleep(1000);
		//action = new Actions(driver);
		
		//WebElement more = driver.findElement(By.linkText("More"));
		Thread.sleep(2000);
		//driver_util.moveToElement(driver, more);
		//action.moveToElement(more).build().perform();
		
		//driver.findElement(By.linkText("Campaigns")).click();
		
		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		//driver.findElement(By.name("campaignname")).sendKeys(campaignname);
		//driver.findElement(By.id("sponsor")).sendKeys(sponsorname);
		
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		camplookup.clickCampAdd();
		//Assert.fail("I am failing the script intentionally");
		addcamp.createCamp(campaignname,sponsorname);
		addcamp.clickSaveButton();
		Thread.sleep(5000);
		
		//String actCamp = driver.findElement(By.id("dtlview_Campaign Name")).getText();
		
		//if(actCamp.equalsIgnoreCase(campaignname)) {
		//	System.out.println("Campaign is created");
		//}else {
		//	System.out.println("Campaign is not created");
		//}
		
		campValid.validateCampain(campaignname,driver);
		
		//homepage.signout();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(1000);
		//driver.quit();

	}
	
	@Test
	public void execute() {
		System.out.println("Hello");
	}

}
