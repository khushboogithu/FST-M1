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

public class Activity_7 {
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
        
        WebElement my_info= driver.findElement(By.id("menu_pim_viewMyDetails"));
        Thread.sleep(2000);
        my_info.click();
        driver.findElement(By.linkText("Qualifications")).click();
      
        
        System.out.println("Clicked qualification");
        driver.findElement(By.id("addWorkExperience")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("IBM");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("QA");
        WebElement from=driver.findElement(By.id("experience_from_date"));
        from.clear();
        from.sendKeys("2022-06-12");
        WebElement to=driver.findElement(By.id("experience_to_date"));
        to.clear();
        to.sendKeys("2025-03-10");
        driver.findElement(By.id("experience_comments")).sendKeys("New learning, new experiences");
        driver.findElement(By.id("btnWorkExpSave")).click();
        System.out.println("experience added successfully");
        
     
        
    	
	}
	
	@AfterClass
	public void after() {
		driver.quit();
		
	}
	
	

}

