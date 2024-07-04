package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testngwithbaseclass.Baseclass;

public class ServiceConsolePage extends Baseclass{
	public ServiceConsolePage(ChromeDriver driver) {
		this.driver=driver;
	}

	/*
	 * private RemoteWebDriver driver;
	 * 
	 * public ServiceConsolePage(RemoteWebDriver driver) { this.driver = driver; }
	 */
	public ServiceConsolePage toggleName() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1000));  
		WebElement toggleMenuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='App Launcher']//div")));
		toggleMenuButton.click();
		return this;
	}
	
	   public ServiceConsolePage viewall(){
	    	driver.findElement(By.xpath("//lightning-button[@class='slds-button slds-p-horizontal--small']//button[1]")).click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement acc = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
	js.executeScript("arguments[0].click();", acc);
	return this;
	    }
	public FilesPage servicesApp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement acc = driver.findElement(By.xpath("//p[text()='Service Console']"));
		js.executeScript("arguments[0].click();", acc);
		 return new FilesPage(driver);
		
	}
	
	
}
