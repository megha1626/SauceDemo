package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import testCases.BaseTest;



public class TestListener extends BaseTest implements ITestListener{

	static Logger logger = Logger.getLogger(TestListener.class);
	public void onTestStart(ITestResult result) {
		logger.info("**********TEST START: "+result.getMethod().getMethodName()+"****************************");

	}

	public void onTestSuccess(ITestResult result) {
		logger.info("------------------------TEST PASS: "+result.getMethod().getMethodName()+"----------------------------------");

	}

	public void onTestFailure(ITestResult result) {

		logger.info("TEST FAIL: "+result.getMethod().getMethodName()+" - "+result.
				getMethod().getDescription()); 
		String folderName=System.getProperty("user.dir")+"/Screenshots/"; 
		String fileName =
				folderName+result.getMethod().getMethodName() + ".png";
		try { 
			File dest = new
					File(fileName); FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), dest);
		} catch (IOException ioe) {

			throw new RuntimeException(ioe); 
		}

	}


}
