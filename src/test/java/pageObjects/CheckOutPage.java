package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Actions;
import utils.Helper;

public class CheckOutPage extends BasePage {




	@FindBy(id ="first-name")
	WebElement txtFirstName;

	@FindBy(id="last-name")
	WebElement txtLastName;

	@FindBy(id="postal-code")
	WebElement txtZipCode;

	@FindBy(id="continue")
	WebElement btnContinue;

	@FindBy(id="finish")
	WebElement btnFinish;
	

	@FindBy(xpath="//span[contains(text(),'Checkout: Your Information')]")
	WebElement lblCheckoutInfo;
	
	
	

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isDispCheckOutInfo() {
		return lblCheckoutInfo.isDisplayed();
	}


	public void completeCheckOut(){
		
		Actions.SendKeys(driver,txtFirstName,Helper.getPropertyValue("firstName"),"firstName");
		
		Actions.SendKeys(driver,txtLastName,Helper.getPropertyValue("lastName"),"lastName");
		
		Actions.SendKeys(driver,txtZipCode,Helper.getPropertyValue("zipcode"),"Zipcode");
		Actions.Click(driver, btnContinue, "continue ");
		Actions.Click(driver, btnFinish,"Finish ");
		
	}
}