package resources;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports {

	static com.aventstack.extentreports.ExtentReports extent;
	
	public static  com.aventstack.extentreports.ExtentReports getReportObject()
	{
		String reportpath =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
		reporter.config().setDocumentTitle("AMAZON VALIDATION TITLE");
		reporter.config().setReportName("UDAY");
		
		extent = new com.aventstack.extentreports.ExtentReports();
		extent.attachReporter(reporter);

		return extent;
		
		
	}
}

