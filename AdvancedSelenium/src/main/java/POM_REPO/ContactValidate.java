package POM_REPO;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactValidate {
	public ContactValidate(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void validateContact(WebDriver driver,String firstname,String lastname) {
		
	String actcontactfirname = driver.findElement(By.id("dtlview_First Name")).getText();
	String actcontactlastname = driver.findElement(By.id("mouseArea_Last Name")).getText();
	//	if(actcontactfirname.equalsIgnoreCase(firstname) && actcontactlastname.trim().equalsIgnoreCase(lastname)) {
	//		System.out.println("Contact is created");
	//	}else {
	//		System.out.println("Contact is not created");
	//	}
	Assert.assertTrue(actcontactfirname.equalsIgnoreCase(firstname), "New Contact not created");
	System.out.println("New contact created");
}
}
