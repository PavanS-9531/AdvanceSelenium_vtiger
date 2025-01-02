package POM_REPO;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampPage {
	
	public CreateCampPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="campaignname")
	private WebElement campName;
	
	@FindBy(id="sponsor")
	private WebElement sponsorfield;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(css="[title='Select']")
	private WebElement ProductAddButton;
	
	public void createCamp(String campname,String sponsorname) {
		campName.sendKeys(campname);
		sponsorfield.sendKeys(sponsorname);
		
	}
	
	public void clickProductButton() {
		ProductAddButton.click();
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	

}
