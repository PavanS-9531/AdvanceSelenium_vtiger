package org.qspiders.DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadingBrowserValue {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("./src/test/resources/test.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		String browser = prop.getProperty("browser");
		
		WebDriver driver;
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edg")) {
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		
		Thread.sleep(3000);
		driver.quit();

	}

}
