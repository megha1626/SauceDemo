package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Actions;

public class PriceInfoPage extends BasePage{



	@FindBy(xpath ="//div[@class='inventory_item_price']")
	public List<WebElement>  lblPrice;

	@FindBy(xpath="//span[contains(text(),'Checkout: Overview')]")
	WebElement headerPayment;

	@FindBy(xpath="//div[contains(text(),'Payment Information')]")
	WebElement lblPriceInfo;


	@FindBy(xpath="//div[contains(text(),'SauceCard')]")
	WebElement lblCardInfo;


	@FindBy(xpath="//div[contains(@class,'summary_subtotal_label')]")
	WebElement lblSubTotal ;


	@FindBy(xpath="//div[contains(@class,'summary_tax_label')]")
	WebElement lbltax;


	@FindBy(xpath="//div[contains(@class,'summary_total_label')]")
	WebElement lblTotal;

	@FindBy(id="finish")
	WebElement btnFinish;





	public PriceInfoPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isDisPaymentHeader() {
		return headerPayment.isDisplayed();
	}
	
	public boolean isDisPriceInfo() {
		return lblPriceInfo.isDisplayed();
	}


	public boolean verifyPriceInfo() {

		float productTotal=0,  expectedtotal=0,actualTotal=0;
		String amount = null;
		boolean flag =false;
		System.out.println(lblPrice.size());
		for (int x = 0; x < lblPrice.size() ; x++) {

			WebElement price = lblPrice.get(x);
			amount=(Actions.getText(driver, price, "price"));
			amount=amount.substring(amount.indexOf("$") + 1 , amount.length());
			productTotal+=Float.valueOf(amount).floatValue();
		}


		String subtotal= Actions.getText(driver, lblSubTotal, "subtotal");
		subtotal=subtotal.substring(subtotal.indexOf("$") + 1 , subtotal.length());
		float subtotalValue=Float.valueOf(subtotal).floatValue();

		if(productTotal!=subtotalValue) {
			return false;
		}
		
		


		String tax= Actions.getText(driver, lbltax, "tax");
		tax=tax.substring(tax.indexOf("$") + 1 , tax.length());
		float subtTaxValue=Float.valueOf(tax).floatValue();



		String Total= Actions.getText(driver, lblTotal, "total");
		Total=Total.substring(Total.indexOf("$") + 1 , Total.length());


		expectedtotal= Float.valueOf(subtotal).floatValue()+Float.valueOf(tax).floatValue();
		actualTotal= Float.valueOf(Total).floatValue();

		if(actualTotal== expectedtotal) {

			System.out.println("Prive isnew  :"+Total);
			Actions.Click(driver, btnFinish,"Finish ");
			return flag;
		}


		return flag;

	}






}
