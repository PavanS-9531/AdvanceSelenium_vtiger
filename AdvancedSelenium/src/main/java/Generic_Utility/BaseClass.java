package Generic_Utility;

import POM_REPO.HomePage;
import POM_REPO.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseClass {
	public WebDriver driver;
	
	public static WebDriver sDriver;
	
	@BeforeSuite(groups= {"sanityTest","regressionTest","smokeTest"})
	public void Bs() {
		System.out.println("Open DataBase connection");
	}
	
	@BeforeTest(groups= {"sanityTest","regressionTest","smokeTest"})
	public void Bt() {
		System.out.println("Parallel execution");
	}
	
	//@Parameters(value="Browser")
	@BeforeClass(groups= {"sanityTest","regressionTest","smokeTest"})
	//public void Bc(String Browser) throws Throwable {
	public void Bc() throws Throwable {
		System.out.println("Launching browser");
		
		File_Utility flib = new File_Utility();
		String Browser=flib.getKeyAndValuePair("browser");
		
		//String Browser= System.getProperty("browser");
		if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		}else if(Browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		sDriver=driver;
	}
	
	//@Parameters({"url","Username","Password"})
	@BeforeMethod(groups= {"sanityTest","regressionTest","smokeTest"})
	//public void Bm(String url,String Username, String Password) throws Throwable {
	
	public void Bm() throws Throwable {
		System.out.println("Log into application");
		File_Utility flib = new File_Utility();
		LoginPage loginpage= new LoginPage(driver);
		WebDriver_Utility driver_util = new WebDriver_Utility();
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");
		//The below code is to get parameters from cmd line in maven execution
		//String URL =System.getProperty("url");
		//String USERNAME = System.getProperty("username");
		//String PASSWORD = System.getProperty("password");
		driver.get(URL);
		driver_util.waitForElementToLoad(driver);
		driver_util.maximizeWindow(driver);

		loginpage.loginToApp(USERNAME, PASSWORD);
		
	}
	
	@AfterMethod(groups= {"sanityTest","regressionTest","smokeTest"})
	public void Am() {
		System.out.println("Log Out from application");
		HomePage homepage = new HomePage(driver);
		homepage.signout();
	}
	
	@AfterClass(groups= {"sanityTest","regressionTest","smokeTest"})
	public void Ac() {
		System.out.println("Close browser");
		driver.quit();
	}
	
	@AfterTest(groups= {"sanityTest","regressionTest","smokeTest"})
	public void At() {
		System.out.println("Close Parallel execution");
	}
	
	@AfterSuite(groups= {"sanityTest","regressionTest","smokeTest"})
	public void As() {
		System.out.println("Close DataBase connection");
	}
	
	

}
