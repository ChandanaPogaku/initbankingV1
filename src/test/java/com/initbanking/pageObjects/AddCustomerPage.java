package com.initbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how= How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddNewCustomer;
	
	@FindBy(how=How.NAME,using="name")
	WebElement txtCustomerName;
	
	@FindBy(how=How.NAME,using="rad1")
	WebElement rdGender;
	
	@FindBy(how=How.ID_OR_NAME,using="dob")
	WebElement txtdob;
	
	@FindBy(how=How.NAME,using="addr")
	WebElement txtaddress;
	
	@FindBy(how=How.NAME,using="city")
	WebElement txtcity;
	
	@FindBy(how=How.NAME,using="state")
	WebElement txtstate;
	
	@FindBy(how=How.NAME,using="pinno")
	WebElement txtpinno;
	
	@FindBy(how=How.NAME,using="telephoneno")
	WebElement txttelephoneno;
	
	@FindBy(how=How.NAME,using="emailid")
	WebElement txtemailid;
	
	@FindBy(how=How.NAME,using="password")
	WebElement txtpassword;

	@FindBy(how=How.NAME,using="sub")
	WebElement btnSubmit;
 public void ClickAddNewCustomer()
	
	{
	 lnkAddNewCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void custgender(String cgender)
	{
		rdGender.click();
	}
	
	public void custdob(String mm, String dd, String yy) 
	{
	   
	    txtdob.sendKeys(mm);
	    txtdob.sendKeys(dd);
	    txtdob.sendKeys(yy);
	}

	public void custaddress(String address) 
	{
	    txtaddress.sendKeys(address); 
	}

	// Action method to set City
	public void custcity(String city) {
	    txtcity.sendKeys(city);  // Enter the City value
	}

	// Action method to set State
	public void custstate(String state) {
	    txtstate.clear();  // Clear any existing value in the State field
	    txtstate.sendKeys(state);  // Enter the State value
	}

	// Action method to set Pin Number
	public void custpinNo(String pinNo) {
	    txtpinno.clear();  // Clear any existing value in the Pin Number field
	    txtpinno.sendKeys(pinNo);  // Enter the Pin Number value
	}

	// Action method to set Telephone Number
	public void custtelephoneno(String telephoneno) {
	    txttelephoneno.clear();  // Clear any existing value in the Telephone Number field
	    txttelephoneno.sendKeys(telephoneno);  // Enter the Telephone Number value
	}

	// Action method to set Email ID
	public void custemailId(String emailId) {
	    txtemailid.clear();  // Clear any existing value in the Email ID field
	    txtemailid.sendKeys(emailId);  // Enter the Email ID value
	}

	// Action method to set Password
	public void custpassword(String password) {
	    txtpassword.clear();  // Clear any existing value in the Password field
	    txtpassword.sendKeys(password);  // Enter the Password value
	}

	// Action method to click Submit button
	public void custsubmit() 
	{
	    btnSubmit.click();  // Click the Submit button
		
	}
	
	
}
