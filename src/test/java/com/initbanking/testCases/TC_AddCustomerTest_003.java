package com.initbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.initbanking.pageObjects.AddCustomerPage;
import com.initbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassWord(password);
		lp.clickSubmit();
		Thread.sleep(3000);
		AddCustomerPage addcust= new  AddCustomerPage(driver);
	      addcust.ClickAddNewCustomer();
		  addcust.custName("Pavan");
		  addcust.custgender("male");
		  addcust.custdob("10","15","1985");
		  Thread.sleep(5000);
		  addcust.custaddress("INDIA");
		  addcust.custcity("HYD");
		  addcust.custstate("AP");
		  addcust.custpinNo("5000074");
		  addcust.custtelephoneno("9874152630");
		  
		  String email=randomstring()+"@gmail.com";
		  addcust.custemailId(email);
		  addcust.custpassword("abcdef");
		  addcust.custsubmit();
		  Thread.sleep(3000);
		 boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
		 if(res==true) {
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 captureScreen(driver,"addNewCustomer");
			 Assert.assertTrue(false);
		 }
		  
		  
}
	
}