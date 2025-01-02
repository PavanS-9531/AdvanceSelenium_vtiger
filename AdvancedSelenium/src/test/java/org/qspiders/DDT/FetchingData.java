package org.qspiders.DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FetchingData {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver;
		driver= new ChromeDriver();
		
		//Step1: Get java representation objects of the physical file path.
		FileInputStream fis = new FileInputStream("D:\\Personal\\QSpiders\\demo.properties");
		
		//Step2 :- Create object of Properties class
		Properties prop = new Properties();
		
		//Step 3 : Load all the Keys
		prop.load(fis);
		
		//Step4: read keys using the method getProperty method
		String URL = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		
		
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		driver.quit();
		
		//Example to write data to file
		//FileOutputStream output = new FileOutputStream("D:\\Personal\\QSpiders\\demo.properties");
	  //prop.setProperty("Result", "Pass");
	  //prop.store(output,null);
	}

}
