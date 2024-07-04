package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testngwithbaseclass.Baseclass;

public class Loginpages extends Baseclass{

	/*
	 * private RemoteWebDriver driver;
	 * 
	 * public Loginpages(RemoteWebDriver driver) { this.driver = driver; }
	 */

	public Loginpages (ChromeDriver driver) {
		this.driver=driver;
	}
	public Loginpages userName(String username) {
		driver.findElement(By.id("username"));
		return this;
		
	}
	public Loginpages password(String Password) {
		driver.findElement(By.id("password"));
		return this;
		

	}

	public ServiceConsolePage click() {
		driver.findElement(By.id("Login"));
		//ServiceConsolePage lp =new ServiceConsolePage(driver);
	    // return lp;
		return new ServiceConsolePage(driver);

	}

}
