package testcases;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import pageObjects.SignInPage;
import resources.Base;


public class TitleValidationTest extends Base {

	public WebDriver driver;
	
	public static Logger log =(Logger) LogManager.getLogger(Base.class.getName());

	@BeforeTest(groups = {"Regression"})
	public void opening() throws IOException
	{
		driver=init();
		
	}
	
	
	@Test
	public void test() throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.info("Hitting the URL");
		
		
		LandingPage ln = new LandingPage(driver);
		Actions a = new Actions(driver);
		Thread.sleep(3000);
		a.moveToElement((ln.Signin())).build().perform();		
		Thread.sleep(2000);
		log.info("Moved to the sigin element");
		Thread.sleep(2000);
		ln.signInButton().click();
		log.info("clicked on sigin button");
		Thread.sleep(2000);
		
		SignInPage sn = new SignInPage(driver);
		sn.username().sendKeys(prop.getProperty("username"));
		sn.continuebutton().click();
		Thread.sleep(2000);
		sn.password().sendKeys(prop.getProperty("password"));
		sn.loginButton().click();
		Thread.sleep(2000);
	Assert.assertEquals(driver.getTitle()," site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
			
		
	}

	@AfterTest
	public void close()
	{
		driver.close();
	}



}

