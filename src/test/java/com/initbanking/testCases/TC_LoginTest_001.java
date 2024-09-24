package com.initbanking.testCases;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.initbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
   public void loginTest() throws IOException
   {
	   driver.get(baseURL);
	   
	   log.info("URL is opened");
	   
	   LoginPage lp=new LoginPage(driver);
	   lp.setUserName(username);
	   log.info("Entered username");
	   
	   lp.setPassWord(password);
	   log.info("Entered password");
	   
	   lp.clickSubmit();
	   
	   if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		   
	   {
		   Assert.assertTrue(true);
		   log.info("Login test passed");
	   }
	   else
	   {   captureScreen(driver,"loginTest");
		   Assert.assertTrue(false);
		   log.info("Login test failed");
	   }
	   
   } 
}
