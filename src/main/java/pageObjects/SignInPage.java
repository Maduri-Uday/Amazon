package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	
	public WebDriver driver;
	
	By username = By.id("ap_email");
	By continuebutton = By.id("continue");
	By password = By.id("ap_password");
	By loginButton =By.id("signInSubmit");
	
	public  SignInPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public WebElement username()
	{
		return driver.findElement(username);
	}
	
	public WebElement continuebutton()
	{
		return driver.findElement(continuebutton);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement loginButton()
	{
		return driver.findElement(loginButton);
	}
	
	
}
