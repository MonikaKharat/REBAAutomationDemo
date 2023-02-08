package com.qa.REBABudget.tests;



import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.REBABudget.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	
	Logger log = Logger.getLogger(LoginPageTest.class);

	
	@Test(priority = 1)
	public void loginPageTitletest()
	{
		String loginPageTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(loginPageTitle, Constants.LOGIN_PAGE_TITLE);
		System.out.println("Login Page Title is : " + loginPageTitle );
	}
	
	@Test (priority = 2)
	public void loginPageURLtest()
	{
		Assert.assertTrue(loginpage.getLoginPageURL());
	}
	
	@Test (priority = 3)
	public void RememberMeLinkTest()
	{
		Assert.assertTrue(loginpage.isRememberMeLinkExist());
	}
		
	@Test (priority = 4)
	public void doLoginTest()
	{
		homepage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(homepage.getHomePageHeader(), Constants.HOME_PAGE_HEADER);
		
		
	}
	
}
