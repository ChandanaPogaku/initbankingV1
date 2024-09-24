package com.initbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.initbanking.pageObjects.LoginPage;
import com.initbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass 
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String username, String password) throws InterruptedException
	{
		
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(username);
		  log.info("Entered username");
		lp.setPassWord(password);
		log.info("Entered password");
		
		lp.clickSubmit();

        Thread.sleep(3000);
		
		if (isAlertPresent()==true)
        {
	      driver.switchTo().alert().accept(); //close alert
	      driver.switchTo().defaultContent();
	      Assert.assertTrue(false);
	      log.warn("Login Failed");
         }
		else
		{
			Assert.assertTrue(true);
			log.info("Login Passed");
			lp.lnklogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();//switch to login
		}
	}
	public boolean isAlertPresent()//user defined methopd to check alert is present or not 
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			
			return false;
		}
	}
	@DataProvider(name="LoginData")
    String[][] getData() throws IOException
    {
		String path = System.getProperty("user.dir")+"/src/test/java/com/initbanking/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path,"Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1; i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i, j);
			}
		}
		 return logindata;
		
    }
}
