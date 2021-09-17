package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public  class  LandingPage {

	public WebDriver driver;
	private	By signin = By.xpath("//a[@data-csa-c-content-id='nav_ya_signin']");
	private By signInButton = By.linkText("Sign in");
	private By searchBox = By.id("twotabsearchtextbox");
	private By cart = By.id("nav-cart");
	private By product = By.cssSelector("img[alt*='iQOO Z3 Series']");
	

	public  LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public WebElement Signin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement searchBox()
	{
		return driver.findElement(searchBox);
	}
	
	public WebElement cart()
	{
		return driver.findElement(cart);
	}
	
	public WebElement signInButton()
	{
		return driver.findElement(signInButton);
	}
	
	public WebElement product()
	{
		return driver.findElement(product);
	}
}
