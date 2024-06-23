package vennilascripts;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Createtaskwithout {
	public static void main(String[] args) throws InterruptedException {


		// Create a new instance of the ChromeDriver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//  Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		// Perform login steps (e.g., enter username and password, click login button)
		driver.findElement(By.id("username")).sendKeys("rajiivino@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Login@1234");
		driver.findElement(By.id("Login")).click();
		// Click on the toggle menu button from the left corner

		driver.findElement(By.xpath("//button[@title='App Launcher']//div")).click();

		//  Click View All and click Work Type Groups from App Launcher
		driver.findElement(By.xpath("//lightning-button[@class='slds-button slds-p-horizontal--small']//button[1]"))
		.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement acc = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		js.executeScript("arguments[0].click();", acc);

		// Click on New Work Type Group
		driver.findElement(By.className("forceActionLink")).click();

		//  Click on Save
		WebElement acc1 = driver.findElement(By.xpath("//span[text()='Save']"));

		driver.executeScript("arguments[0].click();", acc1);

		WebElement acc2 = driver.findElement(By.xpath("//button[text()='Save']"));
		driver.executeScript("arguments[0].click();", acc2);


		//  Verify the Alert message (Complete this field) displayed for Work Type Group Name
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		//WebElement alertMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("Work Type Group Name")));
		//String expectedAlertMessage = "Work Type Group Name";

		Thread.sleep(1000);
		String msg = driver.findElement(By.xpath("//a[@href='javascript:void(0)']")).getText();

		System.out.println(msg);
		if (msg.contains("Work Type Group Name")) {
			System.out.println("WorkType Created");
		} else {
			System.out.println("WorkType not Created");
		}

		// Close the browser
		driver.quit();
	}
}


