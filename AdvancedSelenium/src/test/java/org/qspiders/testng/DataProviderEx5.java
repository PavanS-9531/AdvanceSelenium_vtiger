package org.qspiders.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;

public class DataProviderEx5 {
	
	Excel_Utility excel_util = new Excel_Utility();
	
	@Test(dataProvider="getData")
	public void createOrganization(String Orgname,String emailid) throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Organizations')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		Java_Utility jutil= new Java_Utility();
		int ranInt = jutil.getRandomNum();
		driver.findElement(By.name("accountname")).sendKeys(Orgname+ranInt);
		driver.findElement(By.id("email1")).sendKeys(emailid);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
			
				
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		
		Object[][] objArrData = excel_util.readDataForDataProvider("Sheet1");
		return objArrData;
		
	
	}
}
