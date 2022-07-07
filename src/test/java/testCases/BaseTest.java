package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import utils.Helper;



public class BaseTest {


	public static WebDriver driver;



	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setup() throws IOException  {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		
		driver.get("https://www.saucedemo.com/");
	}
	
	
	@AfterClass
	public void close() {
		driver.quit();
	}
}
