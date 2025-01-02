package POM_REPO;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitching {
	
	public WindowSwitching(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="search_text")
	private WebElement prdTxtField;
	
	@FindBy(name="search")
	private WebElement searchButton;

	public WebElement getPrdTxtField() {
		return prdTxtField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public void selectProductFromWindow(WebDriver driver,String productname) {
		
		searchButton.click();
		prdTxtField.sendKeys(productname);
		driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
	}

}
