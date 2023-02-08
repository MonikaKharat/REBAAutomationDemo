package com.qa.REBABudget.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.REBABudget.utils.Constants;
import com.qa.REBABudget.utils.ElementUtil;

public class LoginPage {

	//1. Declare Private driver - to perform any action on this page only
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	//2. Create page constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	//3. Private By Locators
	private By userName = By.name("userNameOrEmailAddress");	
	private By password = By.name("password");
	private By loginBttn = By.className("btn-lg");
	private By rememberMe = By.xpath("//span[contains(@class, 'mat-checkbox-label')]");
	private By homePage = By.xpath("//span[text()= 'ReportsBI']");
	
	//4. Page Actions	
	public String getLoginPageTitle()
	{
		return eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean getLoginPageURL()
	{
		return eleUtil.waitForURLToContain(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean isRememberMeLinkExist()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return eleUtil.doIsDisplayed(rememberMe);
	}
	
	public HomePage doLogin(String username, String pwd)
	{
		System.out.println("Login with : " +  username + " : " + pwd);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		eleUtil.doSendKeys(userName, username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBttn);
		return new HomePage(driver);
	}
	
}
