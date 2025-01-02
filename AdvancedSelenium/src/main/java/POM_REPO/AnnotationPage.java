package POM_REPO;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class AnnotationPage {
	
	public AnnotationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernametxtFld;
	
	@FindAll({@FindBy(css="[type=\"password\"]"),@FindBy(name="user_password")})
	private WebElement passwordTxtFld;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement loginButton;
	
	public void login(String name,String password) {
		usernametxtFld.sendKeys(name);
		passwordTxtFld.sendKeys(password);
		loginButton.click();
		
		
	}

}
