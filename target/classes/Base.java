package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init() throws IOException
	{
	prop=new Properties();
	String propPath = System.getProperty("user.dir")+"//src//main//java//resources//data.properties";
	String browserPath = System.getProperty("user.dir")+"//src//main//java//resources//chromedriver.exe";
	
	FileInputStream fs = new FileInputStream(propPath);
	prop.load(fs);
	String browser= prop.getProperty("browser");
	
	if (browser.equalsIgnoreCase("chrome")) {
		
		System.setProperty("webdriver.chrome.driver",browserPath);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		}
	return driver;
		
	}
	
	public String screenshot(String name,WebDriver driver) throws IOException
	{
		String scrnpath = System.getProperty("user.dir")+"\\reports\\"+name+".jpg";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File(scrnpath));
		
		return scrnpath;
	}

}
