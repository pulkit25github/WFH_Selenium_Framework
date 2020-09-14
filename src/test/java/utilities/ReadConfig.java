package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{

	Properties pro;
	
    // Creating constructor:
	public ReadConfig ()
	{
		File src = new File("./Configurations/config.properties");    // src is referring to config.pro file
		
		/* suppose file is not available in location and it throws exception...
		this is why putting statements in try catch */
		
		try {
			FileInputStream fis = new FileInputStream(src);  // opening the file
			pro = new Properties();                     // initiating the pro object
			pro.load(fis);                    // load method, to load file the compelete file
			
		} catch (Exception e) 
		
		{
			System.out.println("Exception is: "+e.getMessage());
		}
	}
		
		public String getApplicationUrl()
		{
			String url = pro.getProperty("baseUrl");   // same name present in config.pro file
			return url;
		}
		
		public String getusername()
		{
			String user = pro.getProperty("username");
			return user;
		}
		
		public String getpassword()
		{
			String pwd = pro.getProperty("password");
			return pwd;
		}
		
		public String getChromePath()
		{
			String chromepath = pro.getProperty("ChromePath");
			return chromepath;
		}
		
		public String getFirefoxPath()
		{
			String ffpath = pro.getProperty("FirefoxPath");
			return ffpath;
		}
	
		public String getIEPath()
		{
			String iepath = pro.getProperty("IEPath");
			return iepath;
		}
	
	
	
	
	
}
