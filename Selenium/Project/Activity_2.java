package HRM_Project_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Activity_2 {

	
	private WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void test1() {
		
		driver.get("http://alchemy.hguy.co/orangehrm");
	    String Title=driver.getTitle();
	    System.out.println("Title: "+ Title); 
	    WebElement imgurl= driver.findElement(By.tagName("img"));
	    System.out.println("url: "+ imgurl.getAttribute("src"));
	    driver.quit();
	}
}
