package pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

	public static Properties prop;
		protected WebDriver driver;

	    public BasePage(WebDriver driver) {
	        this.driver = driver;
	     PageFactory.initElements(driver, this);
	    
	}
}

