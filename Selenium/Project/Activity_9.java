package HRM_Project_selenium;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

import jdk.internal.joptsimple.internal.Rows;

public class Activity_9 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void before() {
	driver=new FirefoxDriver();
	wait= new WebDriverWait(driver,DurationOfSeconds(20));
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
       Thread.sleep(1000);
        my_info.click();
        Thread.sleep(2000);
        
        driver.findElement(By.linkText("Emergency Contacts")).click();
      
       List<WebElement> coln=driver.findElements(By.xpath("//table[@id='emgcontact_list']/thead/tr/th"));
      List<WebElement> row=driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr"));
       System.out.println("total columns: "+coln.size());
       System.out.println("total rows: "+row.size());
       for (int i = 1; i <= row.size(); ++i)
	    {
	    	String a = String.valueOf(i);
	    	
	    	//Find and print all the cell values in the first row of the table.
	    	List<WebElement> rowData = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr[" + a + "]"));
	    
	    	System.out.println(a + " row cell values: ");
	    	for(WebElement cell : rowData) 
   		{
   			System.out.println(cell.getText());
   		}	    	
	    }
        
    	
	}
	
	@AfterClass
	public void after() {
		driver.quit();
		
	}
	
	

}

