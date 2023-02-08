package com.qa.REBABudget.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.REBABudget.utils.Constants;

public class RolePageTest extends BaseTest{

	
	@BeforeClass
	public void navigateToRolesPage() throws InterruptedException
	{
		homepage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		userGroupsPage = homepage.goToUsersGroupsPage();
		userGroupsPage.getUserGroupsPageHeader();
		userGroupsPage.goToCreateUserGroupWindow();
		userGroupsPage.addUserGroup();
		userGroupsPage.deleteUserGroup();
		Thread.sleep(1000);
		userGroupsPage.clickOnRoleLinkOnUserGroupsPage();		
		rolepage = userGroupsPage.clickOnRoleLinkOnUserGroupsPage();
	}
	
	@Test (priority = 1)
	public void rolesPageHeaderTest() throws InterruptedException
	{
		String header = rolepage.getRolesPageHeader();
		Assert.assertEquals(header, Constants.ROLE_PAGE_HEADER);
		
	}
	
	@Test(priority = 2)
	public void createRoleWindowHeaderTest() throws InterruptedException
	{
		String header = rolepage.clickOnAddNewRoleLink();
		//System.out.println("Create Role window Header is :" + header);
		Assert.assertEquals(header,  Constants.CREATE_ROLE_WINDOW_HEADER);
		
	}
	
	@Test (priority = 3)
	public void addNewRoleTest() throws InterruptedException
	{
		
		rolepage.addNewRole();
	}
	
//	@Test (priority = 4)
//	public void deleteNewRoleTest() throws InterruptedException
//	{
//		
//		rolepage.deleteRole();
//	}
	
	
}

