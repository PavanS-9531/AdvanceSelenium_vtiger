package POM_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnLookUp {
	
	public OrgnLookUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement orgnCamp;

	public WebElement getOrgnCamp() {
		return orgnCamp;
	}
	
	public void clickOrgnAdd() {
		orgnCamp.click();
	}

}
