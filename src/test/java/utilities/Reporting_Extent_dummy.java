package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

// Basically it is a Listener class used to generate extent reports

public class Reporting_Extent_dummy extends TestListenerAdapter
{

	public WebDriver driver;
	
	public ExtentHtmlReporter  htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setExtent()
	{
		// To create report with timestamp...so it will not overwrite
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // timestamp
		String MyReport = "Test-report-" +timestamp+".html";
		
		
		htmlreporter= new ExtentHtmlReporter("./"+"\\Reports\\"+MyReport);
		htmlreporter.config().setDocumentTitle("WFH_selenium_report"); // Title of the report
		htmlreporter.config().setReportName("Functional Report"); // Name of the report
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
		htmlreporter.config().setTheme(Theme.DARK);
		
		extent= new ExtentReports();
	    
		extent.attachReporter(htmlreporter); // Attach the htmlreporter to extent
		
		extent.setSystemInfo("Hostname", "Pulkit-PC");
		extent.setSystemInfo("Browser", "firefox");
		extent.setSystemInfo("OS", "Windows 10");
	    extent.setSystemInfo("Tester", "Rudra");
	}
	
	@AfterTest
	public void endreport()
	{
		extent.flush();
	}
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver" , System.getProperty("user.dir")+ "\\Drivers\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@Test
	public void titletest()
	{
		test=  extent.createTest("titlecheck"); // test refer from top
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "nopCommerce demo store");
	}
	
	@Test
	public void logotest()
	{
		test=  extent.createTest("logocheck"); // test refer from top
		
	    Boolean status=	 driver.findElement(By.xpath("html/body/div[6]/div[1]/div[2]/div[1]/a/img")).isDisplayed();
		Assert.assertTrue(status);
	} 
}
