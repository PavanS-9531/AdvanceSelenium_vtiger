package POM_REPO;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitchOrgnPage {
	
	public WindowSwitchOrgnPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_txt")
	private WebElement searchTxtFeild;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	@FindBy(xpath="(//a[contains(text(),'Test')])[1]")
	private WebElement OrgName;
	

	public WebElement getSearchTxtFeild() {
		return searchTxtFeild;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public void searchOrg(String OrgName) {
		searchTxtFeild.sendKeys(OrgName);
		searchButton.click();
		
	}
	
	public void selectOrg() {
		OrgName.click();
	}
}
