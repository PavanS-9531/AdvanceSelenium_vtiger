package Generic_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {
	//WebDriver driver;
	Alert alert;
	Actions action;
//	public WebDriver getDriver(String browser) {
//		if(browser.equalsIgnoreCase("chrome")) {
//			driver=new ChromeDriver();
//		}else if(browser.equalsIgnoreCase("firefox")) {
//			driver= new FirefoxDriver();
//		}else if(browser.equalsIgnoreCase("edg")) {
//			driver = new EdgeDriver();
//		}else {
//			driver=new ChromeDriver();
//		}
//		
//		return driver;
//	}
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void waitForElementToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void moveToElement(WebDriver driver,WebElement wb) {
		action = new Actions(driver);
		action.moveToElement(wb).build().perform();
	}
	
	public void contextClick(WebDriver driver,WebElement wb) {
		action = new Actions(driver);
		action.contextClick(wb).build().perform();
	}
	
	public void windowSwtiching(WebDriver driver, String partialTitle) {
		Set<String> allWins = driver.getWindowHandles();
		Iterator<String> id = allWins.iterator();

		while (id.hasNext()) {
			String win = id.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains(partialTitle))

			{
				break;
			}
		}
	}
	
	public void alertAcceptAction(WebDriver driver) {
		 driver.switchTo().alert().accept();
		
	}
	
	public void alertDismissAction(WebDriver driver) {
		 driver.switchTo().alert().dismiss();
		
	}
	
	public void selectFromDDByIndex(WebElement dropdown, int index) {
		Select s = new Select(dropdown);
		s.selectByIndex(index);
	}
	
	public void selectFromDDByValue(WebElement dropdown, String value) {
		Select s = new Select(dropdown);
		s.selectByValue(value);
		
	}
	
	public void selectFromDDByVisibleText(WebElement dropdown, String visibleText) {
		Select s = new Select(dropdown);
		s.selectByVisibleText(visibleText);
		
	}
	
	public void takeScreenShot() {
		
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/image.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String takeScreenShot1(WebDriver driver,String screenshotName) throws Throwable {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/" +screenshotName + ".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}

	

}
