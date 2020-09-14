package tests;



import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import pages.Login_page;
import pages.New_Customer;

public class TC02_Verify_New_cust extends BaseClass
{
	@Test
	public void addNewCust() throws Exception
	{
		
		Login_page lp = new Login_page(driver);
		lp.setusrname(username);
		lp.entrpwd(password);
		lp.submit();
		Thread.sleep(5000);
		
		//***********New Customer************
		
		New_Customer nc = new New_Customer(driver);
		
		nc.Opn_New_Cust();
	//	driver.findElement(By.xpath("//a[contains(text(),'New Customer')]"));
		Thread.sleep(3000);
		nc.New_Cust_name("Pulkit");
		nc.New_Cust_gender();
		nc.New_Cust_dob("10", "25", "1990");
		nc.New_Cust_add("1626 Saini Vihar");
		nc.New_cust_city("Zirakpur");
		nc.New_cust_state("Punjab");
		nc.New_cust_pincode("140603");
		nc.New_cust_tel("9569709454");

		//email: Create method for this (it will generate random email id)
		String email = randonemail()+ "@gmail.com";
		
		
		nc.New_cust_email(email);	
		nc.New_cust_pwd("123456789");
		nc.New_cust_submit();
		
		// 
		
		boolean success= driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (success=true)
		{
			Assert.assertTrue(true);
		}
		else
		{
		Assert.assertTrue(false);	
		}
			
	}
//RandomStringUtils class will import by putting dependency of common-lang3 in pom xml file
	
	public static String randonemail()
	{
		String email_result = RandomStringUtils.randomAlphabetic(5); 
		return(email_result);
	}
	
	
	
	
	
	
	
}
