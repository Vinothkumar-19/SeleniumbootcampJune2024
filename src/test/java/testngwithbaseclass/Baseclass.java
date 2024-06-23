package testngwithbaseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Baseclass {
public ChromeDriver driver;
	
	@BeforeMethod
	
	public void preCondition() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		 driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// 1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		// Perform login steps (e.g., enter username and password, click login button)
		driver.findElement(By.id("username")).sendKeys("rajiivino@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Login@1234");
		driver.findElement(By.id("Login")).click();
		
	}
	@AfterMethod
	public void postCondition () {
		
		driver.quit();
	}
}
