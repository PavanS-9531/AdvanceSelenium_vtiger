package POM_REPO;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")
	private WebElement firstnametext;
	
	@FindBy(name="lastname")
	private WebElement lastnametext;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactBtn;
	
	public void clickCreateContactBtn() {
		createContactBtn.click();
	}
	public void createContact(String firstname, String lastname) {
		firstnametext.sendKeys(firstname);
		lastnametext.sendKeys(lastname);
		
		
	}
	
	public void clickContactSaveBtn() {
		saveButton.click();
	}
	
	
}
