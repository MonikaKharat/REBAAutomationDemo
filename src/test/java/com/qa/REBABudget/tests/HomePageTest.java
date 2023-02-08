package com.qa.REBABudget.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.REBABudget.utils.Constants;

public class HomePageTest extends BaseTest{

	
	//**Pre-Condition of the Page */
	@BeforeClass
	public void navigateToHomePage() 
	{
		homepage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
	
	@Test (priority = 1)
	public void homePageHeaderTest()
	{
		
		Assert.assertEquals( homepage.getHomePageHeader(), Constants.HOME_PAGE_HEADER);
		
	}
	
	@Test (priority = 2)
	public void clientNameTest()
	{
		
		Assert.assertEquals(homepage.getClientName(), Constants.CLIENT_NAME);
		
	}

	@Test(priority = 3)
	public void goToUsersGroupsPageTest()
	{
		userGroupsPage = homepage.goToUsersGroupsPage();
		Assert.assertEquals(userGroupsPage.getUserGroupsPageHeader(),  Constants.USER_GROUP_PAGE_HEADER);
		
	}
	
	
}
	

