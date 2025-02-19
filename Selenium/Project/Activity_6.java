package HRM_Project_selenium;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity_6 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void before() {
	driver=new FirefoxDriver();
	wait= new WebDriverWait(driver,DurationOfSeconds(10));
	driver.get("http://alchemy.hguy.co/orangehrm");
	
	}
	
	private Duration DurationOfSeconds(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@DataProvider(name="LoginCredientials")
		public static Object[][] credentials(){
			return new Object[][] { 
		        {"orange", "orangepassword123", "Welcome Mary" }
			
		   };
	}
	
	@Test(priority = 1, dataProvider = "LoginCredientials")
	public void login(String sUsername,String sPassword,String message) throws InterruptedException {
		
		// Find the username and password fields
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.name("txtPassword"));

        // Enter credentials
        username.sendKeys(sUsername);
        password.sendKeys(sPassword);

        // Click login
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();

        System.out.println("Title of the new page is : " + driver.getTitle());
        
        WebElement directory= driver.findElement(By.id("menu_directory_viewDirectory"));
        System.out.println("Directory botton is enabled:"+ directory.isDisplayed());
        System.out.println("Directory botton is clickable:"+ directory.isEnabled());
        if(directory.isEnabled()==true) {
        
        Thread.sleep(2000);
        System.out.println("directory button is clickable");
        directory.click();
        }
        String text_1=driver.findElement(By.xpath("//div/h1")).getText();
        System.out.println("heading of the page:" +text_1);
        Assert.assertEquals("Search Directory",text_1 );
        
    	
	}
	@AfterClass
	public void after() {
		driver.quit();
		
	}
	
	

}
