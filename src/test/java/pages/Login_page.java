package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class Login_page 
{

	WebDriver driver;
	
	public Login_page (WebDriver rdriver)
	{
	
		driver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	    // Elements
	
		@FindBy (name= "uid")
		@CacheLookup
		WebElement usrname;
		
		@FindBy (name= "password")
		@CacheLookup
		WebElement pwd;
		
		//Another method we can use for elements by using (how)...
		
		@FindBy(how = How.NAME, using = "btnLogin")
		@CacheLookup
		WebElement login;
		
		@FindBy (how =How.LINK_TEXT, using = "Log out")
		@CacheLookup
		WebElement logout;
		
		//Action methods
		
		public void  setusrname (String usr)
		{
			usrname.sendKeys(usr);
		}
		
		public void entrpwd(String paswrd)
		{
			pwd.sendKeys(paswrd);
		}
		
		public void submit()
		{
			login.click();
		}
		
		public void clicklogout()
		{
			logout.click();
		}
			
		}


