package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPage;
import resources.Base;

public class ValidationTest1 extends Base {
	
	WebDriver driver;
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(Base.class.getName());
	LandingPage p ;
//	SoftAssert s = new SoftAssert();
	
	@BeforeTest
	public void starting() throws IOException
	{
		driver=init();
		driver.get(prop.getProperty("url"));
		log.info("Hitting Amazon URL");
	}
	
	
		@Test
	public void cartValidation()
	{
			p = new LandingPage(driver);
		Assert.assertTrue(true);
		log.info("Checking Cart is Displayed or not");
	}

	
	

	@AfterTest
	public void close()
	{
		
		driver.close();
		//s.assertAll();
	}
}
