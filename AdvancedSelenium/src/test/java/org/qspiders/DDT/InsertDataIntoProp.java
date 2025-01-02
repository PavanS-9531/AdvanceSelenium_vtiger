package org.qspiders.DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertDataIntoProp {

	public static void main(String[] args) throws Throwable {
		
		//WebDriver driver = new ChromeDriver();
		
		//Step1: Get java representation objects of the physical file path.
		//FileInputStream fis = new FileInputStream("D:\\Personal\\QSpiders\\demo.properties");
		
		//Step2 :- Create object of Properties class
		Properties prop = new Properties();
		
		prop.setProperty("url", "http://www.saucedemo.com/v1");
		prop.setProperty("username", "standard_user");
		prop.setProperty("password", "secret_sauce");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/test.properties");
		prop.store(fos, "CommonData");
		
		//Read the properties file
		WebDriver driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream("./src/test/resources/test.properties");
		prop.load(fis);
		
		String URL = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
			
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		driver.quit();
		
	
		
		
		
		
	}

}
