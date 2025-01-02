package POM_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Organizations')]")
	private WebElement organizationlink;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	private WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	private WebElement productslink;
	
	@FindBy(xpath="//a[contains(text(),'More')]")
	private WebElement morelink;
	
	@FindBy(xpath="//a[contains(text(),'Campaigns')]")
	private WebElement campaignlink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutDD;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutlink;
	
	public WebElement getLogoutDD() {
		return logoutDD;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getContactslink() {
		return contactslink;
	}

	public WebElement getProductslink() {
		return productslink;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}
	
	//Businesslogic
	public void clickOnCampaign() {
		morelink.click();
		campaignlink.click();
	}
	
	public void signout() {
		logoutDD.click();
		signoutlink.click();
		
	}
	
	public void clickOnProductHome() {
		productslink.click();
	}
	
	public void clickOnContacts() {
		contactslink.click();
	}
	
	public void clickOnOrg() {
		organizationlink.click();
	}
	
	
	
	
	
	
	

}
