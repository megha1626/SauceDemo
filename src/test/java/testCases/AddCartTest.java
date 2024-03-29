package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.CompleteCheckoutPage;
import pageObjects.LoginPage;
import pageObjects.PriceInfoPage;
import pageObjects.ProductsPage;
import utils.Helper;

public class AddCartTest extends BaseTest {

	
	@Test
	public void addTocart() {
		
		LoginPage login=new LoginPage(driver);
	
		login.Login(Helper.getPropertyValue("standUsername"),Helper.getPropertyValue("password"));
		
		ProductsPage prod=new ProductsPage(driver);
		Assert.assertTrue(prod.isDisplayedProducts());
		prod.removeAndNavigateToCart();
		
		CartPage cart=new CartPage(driver);
		Assert.assertTrue(cart.isDisplayedCartLabel());
		cart.removeAndAddToCart();
		
		CheckOutPage checkout=new CheckOutPage(driver);
		Assert.assertTrue(checkout.isDispCheckOutInfo());
		checkout.completeCheckOut();
		
		PriceInfoPage priceInfo=new PriceInfoPage(driver);
		Assert.assertTrue(priceInfo.verifyPriceInfo());
		
		
		CompleteCheckoutPage completecheck=new CompleteCheckoutPage(driver);
		Assert.assertTrue(completecheck.verifyCompleteText());
		Assert.assertTrue(completecheck.verifyCompleteImage());
		Assert.assertTrue(completecheck.verifyCompleteCheckout());
		
		
	}
	
	
}
