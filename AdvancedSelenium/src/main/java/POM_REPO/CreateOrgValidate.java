package POM_REPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateOrgValidate {
	public CreateOrgValidate(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
		public void validateOrg(WebDriver driver,String Orgname) {
		String actData = driver.findElement(By.id("dtlview_Organization Name")).getText();
		//	if(actData.equalsIgnoreCase(Orgname)) {
		//		System.out.println("Organization is created");
		//	}else {
		//		System.out.println("Organization not created");
		//	}
			Assert.assertEquals(actData, Orgname, "New Organization is not created");
			System.out.println("New Organization is created");
		}
	
	
		
	

}
