package com.qa.REBABudget.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.REBABudget.factory.DriverFactory;
import com.qa.REBABudget.pages.HomePage;
import com.qa.REBABudget.pages.LoginPage;
import com.qa.REBABudget.pages.RolesPage;
import com.qa.REBABudget.pages.UserGroupsPage;

public class BaseTest {

	
	DriverFactory df;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage; //Cannot create object in Test Class hence doing it in the Super class
	HomePage homepage;
	UserGroupsPage userGroupsPage;
	RolesPage rolepage;
	
	//**Global Pre-Condition */
	@BeforeTest
	public void setup()
	{
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
	}
	
	
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
		
	}
	
}
