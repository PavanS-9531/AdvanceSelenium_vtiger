package POM_REPO;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FindAndDeleteProduct {
	public FindAndDeleteProduct(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement prodDeleteBthn;
	
	@FindBy(xpath="(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]")
	private List<WebElement> prodList;
	
	public void deleteProduct(WebDriver driver,String productname) {
		driver.findElement(By.xpath("//a[contains(text(),'"+productname+"')]/../../td[1]/input")).click();
		prodDeleteBthn.click();
	}
	
	public void validateDeletion(String productname) {
		Boolean flag= false;
		for(WebElement ProdName : prodList) {
			String prodData = ProdName.getText();
			if(prodData.contains(productname)) {
				flag = true;
				break;
			}
			
		}
		//if(flag) {
		//	System.out.println("Product " +productname+ " is Deleted");
		//}else {
		//	System.out.println("Product " +productname+ " is not Deleted");
		//}
		Assert.assertTrue(flag, "Product is not deleted");
		System.out.println("Product is deleted");
	
		
	}
}
