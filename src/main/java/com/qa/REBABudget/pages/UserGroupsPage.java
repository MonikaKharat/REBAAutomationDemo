package com.qa.REBABudget.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.REBABudget.utils.Constants;
import com.qa.REBABudget.utils.ElementUtil;

public class UserGroupsPage {

	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public UserGroupsPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
		
	private By userGroupsPageHeader = By.xpath("//h2[normalize-space() ='User Groups']");
	private By userGroupcreationLink = By.xpath("/html/body/app-root/ng-component/section[2]/div/ng-component/div/div/div/div[1]/div/div/a");
	private By createUserGroupWindowText = By.xpath("//h2[normalize-space()='Create User Group']");
	private By userGroupName = By.xpath("//*[@id='mat-input-0']"); 	//*[@id='mat-input-0']
	private By selectRoleName = By.xpath("(//span[contains(text(),'Role')])[1]");
	//private By roleDropDownLst = By.xpath("//*[@id='cdk-overlay-1']/div/div"); 
	private By completeList = By.xpath("//*[@class='mat-option ng-star-inserted']");
	private By saveBttn = By.xpath("//span[text() = ' Save ']");
	private By accountsText = By.xpath("//mat-label[normalize-space()='Accounts']");
	private By newlyAddedUserGroupText = By.xpath("//div[normalize-space()='Demo Test User Group']");
	//private By recentlyAddedUserGroup = By.xpath("//tr[@class='ng-tns-c17-4 ng-star-inserted'][last()]");
	//private By newlyAddedUserGroupTexts = By.xpath("//*[@class='ng-tns-c16-4 ng-star-inserted']last()");
	//*[@class='ng-tns-c16-4 ng-star-inserted']
	private By deleteUserGroupLink = By.xpath("/html/body/app-root/ng-component/section[2]/div/ng-component/div/div/div/div[3]/table/tbody/tr[12]/td[6]/div/button[1]/span/em");
	private By deleteBttn = By.xpath("//*[@id=\'yes-button\']/span");
	private By rolesLink = By.linkText("Roles");
	
	
	public String getUserGroupsPageHeader()
	{
		
		eleUtil.doVisibilityOfElement(userGroupsPageHeader, Constants.DEFAULT_TIME_OUT);
		String header = eleUtil.doGetText(userGroupsPageHeader);
		System.out.println("Header of User Groups Page  is : " + header);
		return header;
	}
	
	public String goToCreateUserGroupWindow() throws InterruptedException
	{
		eleUtil.clickElementWhenReady(userGroupcreationLink, Constants.DEFAULT_TIME_OUT);
		//eleUtil.doClick(userGroupcreationLink);
		eleUtil.doVisibilityOfElement(createUserGroupWindowText, Constants.DEFAULT_TIME_OUT);
		String header =  eleUtil.doGetText(createUserGroupWindowText);
		System.out.println("Header of Create User Group Window is : " + header);
		return header;
	}
	
	public String addUserGroup() throws InterruptedException
	{
		
	//	Thread.sleep(1000);
		eleUtil.doSendKeysWithoutClear(userGroupName, Constants.NEWLY_ADDED_USER_GROUP);
		
		Thread.sleep(1000);
		eleUtil.doClick(selectRoleName);
		//System.out.println("Clicked on Role DropDwon on Create User Group");
				
		//eleUtil.doPresenceOfElementLocated(roleDropDownLst, Constants.DEFAULT_TIME_OUT);
		Thread.sleep(1000);
		eleUtil.selectDropDownValueWithPrint(completeList, "Analyst");

		eleUtil.clickElementWhenReady(saveBttn, Constants.DEFAULT_TIME_OUT);
		eleUtil.doClick(saveBttn);	
		
		String newlyAddedUserGroup = eleUtil.doGetText(newlyAddedUserGroupText);
		return newlyAddedUserGroup;
	}
		

	public void deleteUserGroup() throws InterruptedException
	{
//		String newlyAddedUserGroup = eleUtil.doGetText(newlyAddedUserGroupText);
//		System.out.println("Newly added User Group Name is : " + newlyAddedUserGroup);
		
		Thread.sleep(1000);
		eleUtil.selectNewlyAddedUserGroupWithPrint(newlyAddedUserGroupText, "Demo Test User Group");
		//eleUtil.deleteNewlyAddedUserGroupWithPrint(recentlyAddedUserGroup);
		eleUtil.doClick(deleteUserGroupLink);
		eleUtil.doClick(deleteBttn);
		
		
		
	}
	
	public RolesPage clickOnRoleLinkOnUserGroupsPage() 
	{
		eleUtil.clickElementWhenReady(rolesLink, Constants.DEFAULT_TIME_OUT);
		return new RolesPage(driver);
	}
}
	
	
