import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

			
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://reba-budget-brookfield-dev-web.azurewebsites.net/");
		driver.manage().window().maximize();
		
		
		By userName = By.name("userNameOrEmailAddress");	
		By password = By.name("password");
		By loginBttn = By.className("btn-lg");
		By rememberme = By.xpath("//span[contains(@class, 'mat-checkbox-label')]");
		//By homepage = By.xpath("//span[text()= 'ReportsBI']");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String remembermeVal = driver.findElement(rememberme).getText();
		System.out.println(remembermeVal);
		driver.findElement(userName).sendKeys("monika.kharat@saviantconsulting.com");
		driver.findElement(password).sendKeys("Monika@2022");
		driver.findElement(loginBttn).click();
		
		driver.quit();
	}

}
