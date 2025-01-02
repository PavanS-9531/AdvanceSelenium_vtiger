package Generic_Utility;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportConfig implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//@Will trigger during @Test
		test = report.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
		System.out.println("Test script is PASS");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		System.out.println("Test script is FAIL");
		
		String screenShot =null;
		try {
			screenShot = WebDriver_Utility.takeScreenShot1(BaseClass.sDriver, result.getMethod().getMethodName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenShot);
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		System.out.println("Test script is skipped");
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		String dateTime = new Date().toString().replace(" ", "_").replace(":", "_");
		//Outlook of reports
		ExtentSparkReporter espark = new ExtentSparkReporter("ExtentReports/Report.html "+ dateTime);
		espark.config().setTheme(Theme.DARK);
		espark.config().setDocumentTitle("VTigerReport");
		espark.config().setReportName("TestReports");
		
		//System Configuration
		report = new ExtentReports();
		report.attachReporter(espark);
		report.setSystemInfo("PlatForm","Windows x64");
		report.setSystemInfo("executedBy","JenkinsAgent1");
		report.setSystemInfo("ReviewedBy","ReviewTeam");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
		
	}
	

}
