package POM_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLookUpImage {
	
	public ProductLookUpImage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProductButton;

	public WebElement getCreateProductButton() {
		return createProductButton;
	}
	
	public void clickProductImage() {
		createProductButton.click();
	}
}
