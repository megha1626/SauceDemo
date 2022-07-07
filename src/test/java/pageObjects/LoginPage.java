package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCases.BaseTest;
import utils.Actions;

public class LoginPage extends BasePage{

	@FindBy(id = "user-name")
	WebElement txtUserName;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="login-button")
	WebElement btnLogin;
	
	
	
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	
	public void Login(){
		
	
		Actions.SendKeys(driver,txtUserName,prop.getProperty("username"),"username");
		Actions.SendKeys(driver,txtPassword,prop.getProperty("password"),"password");
		Actions.Click(driver,btnLogin,"btn Login");
		
		
	}
	
}
