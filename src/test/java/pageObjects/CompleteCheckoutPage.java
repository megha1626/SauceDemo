package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompleteCheckoutPage extends BasePage {

	
	
	@FindBy(xpath ="//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")
	WebElement lblThankYou;

	@FindBy(xpath="//span[contains(text(),'Checkout: Complete!')]")
	WebElement lblFinishCheckOut;

	@FindBy(xpath="//button[@id='back-to-products']")
	WebElement btnBackToProducts;

	@FindBy(xpath="//img[@class='pony_express']")
	WebElement imgThankYou;



	public CompleteCheckoutPage(WebDriver driver) {
		super(driver);
	}


	public boolean verifyCompleteText(){
		return lblThankYou.isDisplayed();
		
		
	}
	
	public boolean verifyCompleteImage(){
		return imgThankYou.isDisplayed();
		
		
	}
	
	public boolean verifyCompleteCheckout(){
		return lblFinishCheckOut.isDisplayed();
		
	}
	
	
	
}
