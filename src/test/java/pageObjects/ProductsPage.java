package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.log4testng.Logger;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import utils.Actions;
import utils.TestListener;

public class ProductsPage extends BasePage{
	static Logger logger = Logger.getLogger(ProductsPage.class);

	@FindBy(xpath = "//span[contains(text(),'Products')]")
	WebElement lblProducts;

	@FindBy(xpath="//button[contains(@id,'add-to-cart')]")
	public List<WebElement> btnAddToCart;

	@FindBy(xpath="//button[contains(@id,'remove')]")
	public List<WebElement> btnRemove;


	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement iconCart;


	public ProductsPage(WebDriver driver) {
		super(driver);
	}


	public boolean isDisplayedProducts() {
		return lblProducts.isDisplayed();
	}

	public void AddtoCart(){


		for (int x = 0; x < btnRemove.size() ; x++) {
			logger.info("Some products are already is list. So removing them");
			WebElement remove = btnRemove.get(x);
			Actions.Click(driver, remove,"remove");

		}

		for (int x = 0; x < btnAddToCart.size() ; x++) {
			logger.info("Adding products in cart");
			WebElement add = btnAddToCart.get(x);
			Actions.Click(driver, add,"add to  cart");

		}

	}

	public void navigateToCartPage(){
		Actions.Click(driver, iconCart, "icon CArt");
	}


	public void removeAndNavigateToCart(){
		AddtoCart();
		navigateToCartPage();

	}




}
