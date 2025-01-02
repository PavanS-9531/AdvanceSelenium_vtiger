package POM_REPO;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductValidationPage {
	
	public ProductValidationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void validateProduct(WebDriver driver,String productname) {
		String productCreated = driver.findElement(By.id("dtlview_Product Name")).getText();
		//if(productCreated.equalsIgnoreCase(productname)) {
		//	System.out.println("Product is created");
		//}else {
		//	System.out.println("Product is not created");
		//}
		Assert.assertEquals(productCreated, productname, "New Product is not created");
		System.out.println("New product is created");
	}
}
