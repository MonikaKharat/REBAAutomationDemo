package com.qa.REBABudget.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.REBABudget.utils.Constants;
import com.qa.REBABudget.utils.ElementUtil;

public class RolesPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public RolesPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	private By rolesLink = By.linkText("Roles");
	private By rolesPageHeader = By.xpath("//h2[normalize-space() ='Roles']");
	private By addNewRoleLink = By.linkText("+ Add New Role");
	private By createNewRoleHeader = By.xpath("//h1[normalize-space() ='Create new role']");
	private By roleName = By.xpath("//*[@id = 'mat-input-1']");
//	private By roleName = By.xpath("#mat-input-1"); //css selector 
	private By displayName = By.xpath("//*[@id = 'mat-input-2']");
	private By saveButton = By.xpath("//span[text() = ' Save ']");
	private By newlyAddedRole = By.xpath("//td[normalize-space() ='Test Role']");
	private By permissionsTab = By.xpath("//div[text() = 'Permissions']");
	//*[@id="mat-tab-label-1-1"]
	//private By permissionDropDown = By.xpath("//tr[@class='ng-star-inserted']");
	private By permissionDropDown = By.xpath("//*[@id=\'budgetReport\']/table/tbody/tr[1]/td[2]/select/option[3]");
	//*[@id="budgetReport"]/table/tbody/tr[1]/td[2]/select/option[3]
	private By deleteRoleLink = By.xpath("/html/body/app-root/ng-component/section[2]/div/ng-component/div/div/div/div[3]/table/tbody/tr[1]/td[3]/button[1]/span/em");
	private By notifyYesButton = By.xpath("//button[normalize-space() ='Yes']");
	
	//*[@class='ng-star-inserted']
	
	public String getRolesPageHeader()
	{
		
		eleUtil.doVisibilityOfElement(rolesPageHeader, Constants.DEFAULT_TIME_OUT);
		String header = eleUtil.doGetText(rolesPageHeader);
		System.out.println("Header of Roles Page  is : " + header);
		return header;
	}
	
	public String clickOnAddNewRoleLink() throws InterruptedException 
	{
		
		Thread.sleep(1000);
		eleUtil.clickElementWhenReady(addNewRoleLink,  Constants.DEFAULT_TIME_OUT);
		
		//eleUtil.doClick(addNewRoleLink);
		
		String header = eleUtil.doGetText(createNewRoleHeader);
		System.out.println("Header of Create New Role window  is : " + header);
		return header;
	}
	
	public void addNewRole() throws InterruptedException 
	{		
		Thread.sleep(1000);
	//	eleUtil.waitForElementsToBeVisible(roleName, Constants.DEFAULT_TIME_OUT);
		eleUtil.doSendKeysWithoutClear(roleName, Constants.NEWLY_ADDED_ROLE);
		
		Thread.sleep(1000);
	//	eleUtil.waitForElementsToBeVisible(displayName, Constants.DEFAULT_TIME_OUT);
		eleUtil.doSendKeys(displayName,  Constants.ROLE_DISPLAY_NAME);
		
		eleUtil.waitForElementsToBeVisible(permissionsTab, Constants.DEFAULT_TIME_OUT);
		eleUtil.doClick(permissionsTab);
		
		Thread.sleep(1000);
		eleUtil.selectDropDownValueRolePermissionWithPrint(permissionDropDown, Constants.READ_WRITE_PERMISSION);
		
		eleUtil.clickElementWhenReady(saveButton, Constants.DEFAULT_TIME_OUT);
		
		//System.out.println("Clicked on Role DropDwon on Create User Group");
				
		//eleUtil.doPresenceOfElementLocated(roleDropDownLst, Constants.DEFAULT_TIME_OUT);
				
	}
	
	public void deleteRole() throws InterruptedException
	{
		
		Thread.sleep(1000);
		eleUtil.doClick(newlyAddedRole);
		eleUtil.doClick(deleteRoleLink);
		eleUtil.doClick(notifyYesButton);
		
		
	}
	
	
	
}
