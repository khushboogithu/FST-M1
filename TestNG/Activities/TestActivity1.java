package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity1 {
	
	//Declaring the driver object
			WebDriver driver;
			
			//Declaring the wait object
			WebDriverWait wait;
			
			//Browser setup function
			@BeforeClass
			public void setup()
			{
				//Initialize the driver
				driver = new FirefoxDriver();
				
				//Initialize the wait
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				
				//Open the page
				driver.get("https://training-support.net/");		
			}
			
			@Test(priority = 1)
			public void homePageTest()
			{
				Assert.assertEquals(driver.getTitle(), "Training Support");
				
			}
			
			@Test(dependsOnMethods = {"homePageTest"})
			public void aboutPageTest()
			{
				WebElement aboutUs = driver.findElement(By.linkText("About Us"));
				aboutUs.click();
				Assert.assertEquals(driver.getTitle(), "About Training Support");
				
			}
			
			//Browser cleanup function
			@AfterClass
			public void tearDown()
			{
				//Close the browser
				driver.quit();
				
			}

}
