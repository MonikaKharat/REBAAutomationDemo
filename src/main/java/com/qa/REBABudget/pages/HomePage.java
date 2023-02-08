package com.qa.REBABudget.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.REBABudget.utils.Constants;
import com.qa.REBABudget.utils.ElementUtil;

public class HomePage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	private By headerHomePage = By.xpath("//span[text() = 'Home']");
	private By clientName = By.xpath("//div[text()= ' Brookfield ']");
	private By setupMenu = By.xpath("//*[@id=\'leftsidebar\']/sidebar-nav/div/div/ul/li[2]/a");
	//*[@id="leftsidebar"]/sidebar-nav/div/div/ul/li[2]/a
	private By usersLink = By.xpath("//*[@id=\"leftsidebar\"]/sidebar-nav/div/div/ul/li[2]/ul/li[1]/a/span");
	private By userGroupLink = By.xpath("//*[@id=\"2\"]");
	
	//UserGroups Page
	private By userGroupcreationLink = By.xpath("/html/body/app-root/ng-component/section[2]/div/ng-component/div/div/div/div[1]/div/div/a");
	private By createUserGroupWindowText = By.xpath("//h2[@id = 'mat-dialog-title-0' and @class = 'mat-dialog-title']");
	//private By logoutLink = By.xpath("//*[@id=\"leftsidebar\"]/sidebar-footer/div/div[1]/span");
	
				
	public String getHomePageHeader()
	{
		eleUtil.doPresenceOfElementLocated(headerHomePage, Constants.DEFAULT_TIME_OUT);
		String homePageHeader = eleUtil.doGetText(headerHomePage);
		System.out.println("Home Page Header is : " + homePageHeader);
		return homePageHeader;
	}
	
	public String getClientName()
	{
		eleUtil.doPresenceOfElementLocated(clientName, Constants.DEFAULT_TIME_OUT);
		String clientNameVal = eleUtil.doGetText(clientName);
		System.out.println("Client name on Home Page is : " + clientNameVal);
		return clientNameVal;
	}
	
	public UserGroupsPage goToUsersGroupsPage()
	{
		eleUtil.doClick(setupMenu);
		eleUtil.doClick(usersLink);
		eleUtil.doClick(userGroupLink);
		return new UserGroupsPage(driver);
	}
	

}
