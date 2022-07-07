package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Actions {
static Logger logger = Logger.getLogger(Actions.class);  
	
	public static void Click(WebDriver driver, WebElement element, String elementName) {
		
		try {
			
			element.click();
			logger.info(elementName+" is clicked Successfully");
			
		}
		
		catch(Exception e) {
			logger.error(elementName+" cannot be clicked Successfully ");
		}
		
	}
public static void SendKeys(WebDriver driver, WebElement element, String Value, String elementName) {
		
		try {
			
			element.sendKeys(Value);
			logger.info(Value+" is entered Successfully in "+elementName);
			
		}
		
		catch(Exception e) {
			logger.error(Value+" cannot be enetered Successfully ");
		}
		
	}
public static void getText(WebDriver driver, WebElement element, String elementName) {
	
	try {
		
		String value=element.getText();
		logger.info(value+" is fetched Successfully from "+elementName);
		
	}
	
	catch(Exception e) {
		logger.error("Not Able to fetched text");
	}
	
}
}
