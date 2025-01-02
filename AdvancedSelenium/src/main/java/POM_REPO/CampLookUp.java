package POM_REPO;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampLookUp {
	
	public CampLookUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createCamp;

	public WebElement getCreateCamp() {
		return createCamp;
	}
	
	public void clickCampAdd() {
		createCamp.click();
	}

}
