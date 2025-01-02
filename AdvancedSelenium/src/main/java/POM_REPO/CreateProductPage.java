package POM_REPO;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	public CreateProductPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement prodNameField;
	
	@FindBy(id="productcode")
	private WebElement prodCodeFeild;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getProdNameField() {
		return prodNameField;
	}

	public WebElement getProdCodeFeild() {
		return prodCodeFeild;
	}
	
	public void createProduct(String productname,String productcode) {
		prodNameField.sendKeys(productname);
		prodCodeFeild.sendKeys(productcode);
		saveButton.click();
	}
	

}
