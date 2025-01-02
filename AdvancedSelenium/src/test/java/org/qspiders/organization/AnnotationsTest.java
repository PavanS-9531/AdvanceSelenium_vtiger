package org.qspiders.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.File_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_REPO.AnnotationPage;
import POM_REPO.HomePage;

public class AnnotationsTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver;
		// TODO Auto-generated method stub
		WebDriver_Utility driver_util = new WebDriver_Utility();
		File_Utility flib = new File_Utility();
		
		
		String URL = flib.getKeyAndValuePair("url");
		String Username = flib.getKeyAndValuePair("username");
		String Password = flib.getKeyAndValuePair("password");
		String Browser=flib.getKeyAndValuePair("browser");
		
		if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		}else if(Browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		driver_util.waitForElementToLoad(driver);
		driver_util.maximizeWindow(driver);
		driver.get(URL);
		AnnotationPage annotTest = new AnnotationPage(driver);
		HomePage homepage = new HomePage(driver);
		annotTest.login(Username, Password);
		
		homepage.signout();
		
		Thread.sleep(2000);
		driver.quit();


	}

}
