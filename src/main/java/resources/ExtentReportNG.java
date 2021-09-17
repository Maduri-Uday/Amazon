package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	
	static ExtentReports extent;
	static ExtentSparkReporter reporter;
	
	public static ExtentReports report()
	{
	String Extentpath = System.getProperty("user.dir")+"//reports//report.html";
	
	reporter =new ExtentSparkReporter(Extentpath);
	reporter.config().setDocumentTitle("Uday Sample");
	reporter.config().setReportName("uday");
	extent= new ExtentReports();
	extent.attachReporter(reporter);
	
	return extent;
	}

}
