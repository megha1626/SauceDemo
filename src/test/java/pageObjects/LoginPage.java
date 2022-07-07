package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCases.BaseTest;
import utils.Actions;
import utils.Helper;

public class LoginPage extends BasePage{

	@FindBy(id = "user-name")
	WebElement txtUserName;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="login-button")
	WebElement btnLogin;
	
	@FindBy(xpath="//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out')]")
	WebElement errorLocked;
	
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	
	public void Login(String username,String password){
		
		Actions.SendKeys(driver,txtUserName,username,"username");
		Actions.SendKeys(driver,txtPassword,password,"password");
		Actions.Click(driver,btnLogin,"btn Login");
		
		
	}
	
public boolean isDispLockedMessage(){
		
	return errorLocked.isDisplayed();
		
		
	}
	
	
}
