package com.initbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
/*import org.apache.log4j2.PropertyConfigurator;*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.initbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	public String baseURL= readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getpassword();
	/*public String baseURL= "https://demo.guru99.com/v4/";
	public String UserName="mngr589212";
	public String password ="nAvyvum";*/
	public static WebDriver driver;
	public static Logger log;
	@BeforeClass
	public void setup()
	{
	    System.setProperty("webdriver.chromedriver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		/*System.setProperty("webdriver.chromedriver",readconfig.getchromepath()); */
	    driver=new ChromeDriver();
	    
	
	    log = LogManager.getLogger(TC_LoginTest_001.class);
	    /*PropertyConfigurator.configure("log4j2.properties");*/
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.get(baseURL);
	    
	 }
	
	@AfterClass
	public void tearDown()
	{
		 driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/" +tname + ".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot taken");
	}
	public String randomstring()
	  {
		String generatedstring= RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
		  
	  }
	  public String randomNum()
	  {
		String generatedstring2= RandomStringUtils.randomAlphabetic(8);
		return(generatedstring2);
		  
	  }
}
