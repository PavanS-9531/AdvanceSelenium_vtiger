package POM_REPO;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CampValidate {
	//WebDriver driver;
	public CampValidate(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void validateCampain(String name,WebDriver driver) {
	
	String actCamp = driver.findElement(By.id("dtlview_Campaign Name")).getText();
		
	//	if(actCamp.equalsIgnoreCase(name)) {
	//		System.out.println("Campaign is created");
	//	}else {
	//		System.out.println("Campaign is not created");
	//	}
	Assert.assertEquals(actCamp, name, "New Campaign is not created");
	System.out.println("New Campaign is created");
		
	}

}
