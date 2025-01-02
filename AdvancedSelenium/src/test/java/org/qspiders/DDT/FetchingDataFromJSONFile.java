package org.qspiders.DDT;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchingDataFromJSONFile {

	public static void main(String[] args) throws Throwable  {
		// TODO Auto-generated method stub
		File file = new File("./src/test/resources/JSonData.json");
		
		ObjectMapper obj = new ObjectMapper();
		JsonNode data = obj.readTree(file);
		
		String browser = data.get("browser").asText();
		String URL = data.get("url").asText();
		String username = data.get("username").asText();
		String password = data.get("password").asText();
		
		WebDriver driver;
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edg")) {
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
