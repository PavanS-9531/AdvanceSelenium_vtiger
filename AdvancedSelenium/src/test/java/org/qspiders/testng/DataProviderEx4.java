package org.qspiders.testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx4 {
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
		driver.findElement(By.name("accountname")).sendKeys(Orgname);
		driver.findElement(By.id("email1")).sendKeys(emailid);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
			
				
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		Object[][] objArray = new Object[3][2];
		FileInputStream fis = new FileInputStream("./src/test/resources/DataProvider.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		
		Sheet sheet = workbook.getSheet("Sheet1");
		
		Random ran = new Random(100);
		int ranInt = ran.nextInt();
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=1;j++) {
				Row row = sheet.getRow(i);
				Cell cell = row.getCell(j);
				if(j==0) {
				objArray[i][j]=cell.getStringCellValue()+ranInt;
				}else {
					objArray[i][j]=cell.getStringCellValue();
				}
				
			}
		}
		
				
		//Random ran = new Random(100);
		//int ranInt = ran.nextInt();
		
		//objArray[0][0]="AAA"+ranInt;
		//objArray[0][1]="abcd@gmail.com";
		//objArray[1][0]="BBB"+ranInt;
		//objArray[1][1]="efgh@yahoo.com";
		//objArray[2][0]="CCC"+ranInt;
		//objArray[2][1]="LMNO@hotmail.com";
		
		return objArray;
		
		
		
		
				
		
	}

}
