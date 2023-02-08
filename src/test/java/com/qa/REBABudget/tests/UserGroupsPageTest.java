package com.qa.REBABudget.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.REBABudget.pages.HomePage;
import com.qa.REBABudget.utils.Constants;

public class UserGroupsPageTest extends BaseTest{

	
	@BeforeClass
	public void navigateToUsergsGroupPage()
	{
		homepage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		userGroupsPage = homepage.goToUsersGroupsPage();
	}
	
	@Test(priority = 1)
	public void userGroupsPageHeaderTest() throws InterruptedException
	{
		
		String actluserGroupsPageHeader = userGroupsPage.getUserGroupsPageHeader();
		Assert.assertEquals(actluserGroupsPageHeader,  Constants.USER_GROUP_PAGE_HEADER);
		
	}	
	
	@Test(priority = 2)
	public void createUserGroupsWindowHeaderTest() throws InterruptedException
	{
		String actlCreateUserGroupHeader = userGroupsPage.goToCreateUserGroupWindow();
		System.out.println("Create User Group Header is :" + actlCreateUserGroupHeader);
		Assert.assertEquals(actlCreateUserGroupHeader,  Constants.CREATE_USER_GROUP_WINDOW_HEADER);
		
	}
	
	@Test(priority = 3)
	public void createUserGroupsTest() throws InterruptedException
	{
		
		Assert.assertEquals(userGroupsPage.addUserGroup(), Constants.NEWLY_ADDED_USER_GROUP);
		
	}
	
	@Test(priority = 4)
	public void deleteUserGroupTest() throws InterruptedException
	{
		
		userGroupsPage.deleteUserGroup();
				
	}
	
	@Test(priority = 5)
	public void goToRolesPageTest() throws InterruptedException
	{
		
		rolepage = userGroupsPage.clickOnRoleLinkOnUserGroupsPage();
				
	}
}
