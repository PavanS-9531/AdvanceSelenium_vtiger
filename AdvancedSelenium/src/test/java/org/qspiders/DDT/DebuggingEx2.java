package org.qspiders.DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DebuggingEx2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Test pull request
		//Test again to push the code
		//Trying to create conflict
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("Puma");
		Thread.sleep(3000);
		driver.quit();
		
		}

}
