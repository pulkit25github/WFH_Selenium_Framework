package tests;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import pages.Login_page;
import utilities.XlUtils;


public class Login_test_DDT  extends BaseClass
{

	@Test(dataProvider= "LoginData")
	public void login_DDT(String user, String pwd )
	{
		Login_page lp = new Login_page(driver);
		lp.setusrname(user);
		
	//    logger.info("user name provided");
		lp.entrpwd(pwd);
//		logger.info("Pwd provided");
		lp.submit();
		
		//Created below boolean method for this if else
		if (IsAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		//	System.out.println("TC failed");
//			logger.warn("TC failed");
		}
		else
		{
			Assert.assertTrue(true);
//			logger.info("login passed");
			lp.clicklogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		//	System.out.println("TC passed");
			
		}
		
	}
	
	public boolean IsAlertPresent() // user defined method created to check if alert is present or not after login
	{
		try {
			driver.switchTo().alert();
			return true;
		} 
		catch (NoAlertPresentException e) 
		{
			return false;
		}
		
	}
	//1st part: Create dataprovider method 
	
	@DataProvider(name = "LoginData")
	String [][] getData() throws Exception
	{
		// String path = "./"+ "\\src\\test\\java\\testdata\\DDT_demo.xlsx";
		
		String path = System.getProperty("user.dir") + "/src/test/java/testdata/DDT_demo.xlsx";
		
		int rownum =XlUtils.getRowCount(path, "Sheet1");
		int colcount  = XlUtils.getCellCount(path, "Sheet1", 1);
		
		
		String logindata[][] = new String [rownum][colcount];
	    for (int i=1; i<=rownum; i++)
	    {
		for (int j=0; j<colcount; j++)
		{
			logindata[i-1][j] = XlUtils.getCellData(path, "Sheet1", i,j); // using -1 because in sheet 0 row is heading
		}
		 
	}
		return logindata;
		
	}
}
