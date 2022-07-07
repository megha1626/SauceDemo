package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Actions;

public class CartPage extends BasePage{



	@FindBy(xpath ="//button[text()='Remove']")
	public List<WebElement>  btnRemove;

	@FindBy(id="checkout")
	WebElement btnCheckout;

	@FindBy(xpath="//span[contains(text(),'Your Cart')]")
	WebElement lblYourCart;




	public CartPage(WebDriver driver) {
		super(driver);
	}


	public void removeSecondItem(){

		WebElement remove = btnRemove.get(1);
		Actions.Click(driver, remove, "remove btn");

	}
	
	public boolean isDisplayedCartLabel() {
		return lblYourCart.isDisplayed();
		
	}
	
	public void clickCheckout(){

		Actions.Click(driver, btnCheckout,"checkout btn");
		
	}
	
	public void removeAndAddToCart(){

		removeSecondItem();
		clickCheckout();
		
	}
	


}
