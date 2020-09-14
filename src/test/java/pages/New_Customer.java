package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class New_Customer 
{

	WebDriver driver;
	
	public New_Customer(WebDriver rdriver)
	{
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement new_cust_link; 

	@FindBy(name = "name")
	@CacheLookup
	WebElement cust_name;
	
	@FindBy(name = "rad1")
	@CacheLookup
	WebElement cust_gender;
	
	@FindBy(name = "dob")
	@CacheLookup
	WebElement cust_date_birth;
	
	@FindBy(name = "addr")
	@CacheLookup
	WebElement cust_add;
	
	@FindBy(name = "city")
	@CacheLookup
	WebElement cust_city;
	
	@FindBy(name = "state")
	@CacheLookup
	WebElement cust_state;
	
	@FindBy(name = "pinno")
	@CacheLookup
	WebElement cust_pincode;
	
	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement cust_tel;
	
	@FindBy(name = "emailid")
	@CacheLookup
	WebElement cust_email;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement cust_pas;
	
	@FindBy(name = "sub")
	@CacheLookup
	WebElement cust_submit;

	
 public void Opn_New_Cust()
{
		new_cust_link.click();
}
	
	
public void New_Cust_name(String cname)
{
	cust_name.sendKeys(cname);
}

public void New_Cust_gender()
{
	cust_gender.click();
}

public void New_Cust_dob(String mm, String dd, String yyyy)  
{
	// converting int to string using value of
	cust_date_birth.sendKeys(String.valueOf(mm));
	cust_date_birth.sendKeys(String.valueOf(dd));
	cust_date_birth.sendKeys(String.valueOf(yyyy));
}

public void New_Cust_add(String add)
{
	cust_add.sendKeys(add);
}


public void New_cust_city(String city)
{
	cust_city.sendKeys(city);
}

public void New_cust_state(String state)
{
	cust_state.sendKeys(state);
}

public void New_cust_pincode(String pincode)
{
	cust_pincode.sendKeys(String.valueOf(pincode));
}

public void New_cust_tel(String tel)
{
	cust_tel.sendKeys(String.valueOf(tel));
}

public void New_cust_email(String email)
{
	cust_email.sendKeys(email);
}

public void New_cust_pwd(String pwd)
{
	cust_pas.sendKeys(pwd);
}

public void New_cust_submit()
{
	cust_submit.click();
}

}
