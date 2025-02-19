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
public class Activity_3 {

	
	private WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void test1() {
		
				driver.findElement(By.id("txtUsername")).sendKeys("orange");
				driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
				driver.findElement(By.name("Submit")).click();
				System.out.println("Titke: "+driver.getTitle());
				
				WebElement welcome=driver.findElement(By.id("welcome"));
				System.out.println(welcome.getText());
				WebElement current_page=driver.findElement(By.id("menu_dashboard_index"));
				System.out.println("You are on "+ current_page.getText());
				
				}

	}
	
