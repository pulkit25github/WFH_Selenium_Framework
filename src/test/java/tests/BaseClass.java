package tests;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



import utilities.ReadConfig;

public class BaseClass 
{

	 ReadConfig rc= new ReadConfig();
	
	public String baseUrl = rc.getApplicationUrl();
	public String username = rc.getusername();
	public String password = rc.getpassword();
	public static WebDriver driver;  

// You can put hardcoded values in baseclass or you can use config.properties file for values.	 
	
/*	public String baseUrl = "http://demo.guru99.com/V4/";
	public String username = "mngr282136";
	public String password = "pEjubup";
	public static WebDriver driver;   */
	public static Logger logger;

	//SETUP PART	

	@Parameters("browser")
	@BeforeClass
	
	public void setup(String br) throws Exception
	{
		
		// For testng xml file:
		
		if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver" , rc.getFirefoxPath());  // if using read config class
			driver= new FirefoxDriver();
		}
		else if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver" , rc.getChromePath());  // if using read config class
			driver= new ChromeDriver();
		}
		else if (br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver" , rc.getIEPath());  // if using read config class
			driver= new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Please check your browser name");
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl); 
		driver.manage().window().maximize();
		
	/* instead of System.getProperty("user.dir")...you can just type ./ (refer to directory)
	  "./" used in java and properties file both but system.get used only in java classes */
	
	/*System.setProperty("webdriver.gecko.driver" , rc.getFirefoxPath());  // if using read config class
	  driver= new FirefoxDriver();
		
      System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
      driver = new ChromeDriver(); */
     
     
     //For log4j
	 logger = Logger.getLogger("WFH_Selenium_Framework");
	// PropertyConfigurator.configure("log4j.properties");
	 PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/resources/log4j.properties");
}
    // For SS:
	public void captureScreen (WebDriver driver, String tcname) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source =  ts.getScreenshotAs(OutputType.FILE);
		File target = new File (System.getProperty("user.dir") + "/Screenshots/" + tcname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	/*TEARDOWN PART
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}*/
}
	
	


