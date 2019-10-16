//Login page first changes
package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestUtil;
import com.qa.util.Testbase;



public class LoginPage extends Testbase
{
	//Page Factory - OR Create object repository;
	
	@FindBy(xpath =".//*[@name='username']")
	WebElement username;
	
	@FindBy(xpath = ".//*[@name='password']")
	WebElement password;
	
	@FindBy(xpath = ".//*[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath=".//*[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath=".//*[contains(@class,'navbar-brand')]//img")
	WebElement crmLogo;
	

	//Initializing the Page Objects:
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions:
	public String validateLoginPageTitle() //PageTile test
	{
		return driver.getTitle();	
	}
	
	public boolean validateCRMImage() //Image Test
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException //login page tests
	{
		//username.click();
		Thread.sleep(2000);
		TestUtil.sendKeys(driver,username , TestUtil.timeout, un); //username
		Thread.sleep(2000);
		//password.click();
		TestUtil.sendKeys(driver, password, TestUtil.timeout, pwd); //password
		Thread.sleep(2000);
		TestUtil.clickOn(driver, loginBtn, TestUtil.timeout); //login button
		
		return new HomePage();
	}

}
