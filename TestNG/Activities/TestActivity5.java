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
import org.openqa.selenium.support.Color;

public class TestActivity5 {
	
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
		driver.get("https://training-support.net/webelements/target-practice");		
	}
	
	@Test(priority = 1)
	public void homePageTest()
	{
		Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
		
	}
	
	@Test(priority = 2)
	public void pageHeaderTest()
	{
		WebElement header3 = driver.findElement(By.xpath("//h3[contains(@class, 'orange')]"));
        Assert.assertEquals(header3.getText(), "Heading #3");
        
        Color header5Color = Color.fromString(driver.findElement(By.cssSelector("h5.text-purple-600")).getCssValue("color"));
        Assert.assertEquals(header5Color.asHex(), "#9333ea");
		
	}
	
	@Test(priority = 3)
	public void pageButtonTest()
	{
		WebElement button1 = driver.findElement(By.xpath("//button[contains(@class, 'emerald')]"));
        Assert.assertEquals(button1.getText(), "Emerald");
        
        Color button2Color = Color.fromString(driver.findElement(By.xpath("//button[contains(@class, 'purple')]")).getCssValue("color"));
        Assert.assertEquals(button2Color.asHex(), "#ffffff");
		
	}	
	
	//Browser cleanup function
	@AfterClass
	public void tearDown()
	{
		//Close the browser
		driver.quit();
		
	}

	

}
