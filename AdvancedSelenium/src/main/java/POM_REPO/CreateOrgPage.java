package POM_REPO;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {
	
	public CreateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="img[title='Create Organization...']")
	private WebElement createOrgButton;
	
	@FindBy(name="accountname")
	private WebElement orgNametext;
	
	@FindBy(id="phone")
	private WebElement phonefeild;
	
	@FindBy(id="email1")
	private WebElement emailfeild;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public void createOrganization(String orgname,String phoneno,String emailid) {
		createOrgButton.click();
		orgNametext.sendKeys(orgname);
		phonefeild.sendKeys(phoneno);
		emailfeild.sendKeys(emailid);
		saveButton.click();
		
	}
	
	
		
	

}
