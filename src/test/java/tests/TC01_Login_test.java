package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_page;


public class TC01_Login_test extends BaseClass
{
	// First beforeclass will execute then @test and then Afterclass because of baseclass
	
	@Test
    public void loginpage_test() throws Exception
    {
    	
    	logger.info("Url opened");
    	
    	Login_page lp = new Login_page(driver);
    	lp.setusrname(username);
    	logger.info("Username Entered");
    	
    	lp.entrpwd(password);
    	logger.info("pwd Entered");
    	lp.submit();
  
    	
    	if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
    	{
    		Assert.assertTrue(true);
    		logger.info("Login test passed");
    	}
    	
    	else
    	{
    		captureScreen(driver, "TC01_Login_test");
    		Assert.assertTrue(false);
    		logger.info("Login test failed");
    	}
    
    }
    
	
	
	
}