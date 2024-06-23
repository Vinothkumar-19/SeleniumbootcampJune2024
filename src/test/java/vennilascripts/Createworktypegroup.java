package vennilascripts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Createworktypegroup {

	public static void main(String[] args) throws InterruptedException {
		
			// Create a new instance of the ChromeDriver
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			ChromeDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			// 1. Login to https://login.salesforce.com
			driver.get("https://login.salesforce.com");
			// Perform login steps (e.g., enter username and password, click login button)
			driver.findElement(By.id("username")).sendKeys("rajiivino@gmail.com");
			driver.findElement(By.id("password")).sendKeys("Login@1234");
			driver.findElement(By.id("Login")).click();
			
			Thread.sleep(2000);
			// 2. Click on the toggle menu button from the left corner
			driver.findElement(By.xpath("//button[@title='App Launcher']//div")).click();

			// 3. Click View All and click Work Type Groups from App Launcher
			driver.findElement(By.xpath("//lightning-button[@class='slds-button slds-p-horizontal--small']//button[1]"))
					.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement acc = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
			js.executeScript("arguments[0].click();", acc);

			// 4. Click on the Dropdown icon in the Work Type Groups tab
			// WebElement dropdownIcon =
			// driver.findElement(By.cssSelector("locator_for_dropdown_icon"));
			// dropdownIcon.click();

			// 5. Click on New Work Type Group
			driver.findElement(By.className("forceActionLink")).click();

			// 6. Enter Work Type Group Name as 'Salesforce Automation by Your Name'
			driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following::input")).sendKeys("Automation");

			// 7. Click save and verify Work Type Group Name

			WebElement acc1 = driver.findElement(By.xpath("//span[text()='Save']"));

			driver.executeScript("arguments[0].click();", acc1);

			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@title='OK']")).click();

			WebElement acc2 = driver.findElement(By.xpath("//button[text()='Save']"));
			driver.executeScript("arguments[0].click();", acc2);

			// Verify the Created message
			Thread.sleep(1000);
			String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();

			System.out.println(msg);
			if (msg.contains("created")) {
				System.out.println("WorkType Created");
			} else {
				System.out.println("WorkType not Created");
			}

			// driver.quit();
		}

	}