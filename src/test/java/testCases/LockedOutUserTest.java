package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utils.Helper;

public class LockedOutUserTest extends BaseTest {
	
	@Test
	public void verifyLockedUser() {
		LoginPage login=new LoginPage(driver);
		
		login.Login(Helper.getPropertyValue("lockedUsername"),Helper.getPropertyValue("password"));
		Assert.assertTrue(login.isDispLockedMessage());
	}

}
