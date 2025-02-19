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

public class Activity_8 {
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
        
        WebElement dashboard= driver.findElement(By.id("menu_dashboard_index"));
        Thread.sleep(2000);
        dashboard.click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Apply Leave")).click();
      
        WebElement leave=driver.findElement(By.id("applyleave_txtLeaveType"));
        Select leave_option=new Select(leave);
        leave_option.selectByVisibleText("DayOff");
        Thread.sleep(1000);
        WebElement from=driver.findElement(By.id("applyleave_txtFromDate"));
        from.clear();
        from.sendKeys("2025-02-25");
        WebElement to=driver.findElement(By.id("applyleave_txtToDate"));
        to.clear();
        to.sendKeys("2025-02-26");
        WebElement comments=driver.findElement(By.id("applyleave_txtComment"));
        comments.sendKeys("training");
        Thread.sleep(1000);
        WebElement apply= driver.findElement(By.id("applyBtn"));
        Thread.sleep(1000);
        apply.click();   
    	
	}
	@Test(priority=2)
	public void test2() throws InterruptedException {
		
		driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
		WebElement from=driver.findElement(By.id("calFromDate"));
		from.clear();
		from.sendKeys("2025-02-25");
        WebElement to=driver.findElement(By.id("calToDate"));
        to.clear();
        to.sendKeys("2025-02-26");
        driver.findElement(By.id("btnSearch")).click();
        Thread.sleep(2000);
        List<WebElement> coln=driver.findElements(By.xpath("//table/thead/tr/th"));
        List<WebElement> row=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
       System.out.println("coln size:"+coln.size());
       System.out.println("rows size:"+row.size());
       for(int i=1;i<=row.size();i++) {
    	   List<WebElement> rowdata= driver.findElements(By.xpath("//table/tbody/tr[i]"));
    	   System.out.println(i+" row values");
    	   for( WebElement rows: row) {
    		  System.out.println(rows.getText());
    		  
    	   }
    	   if(row.get(0).getText().contains("training")){
    		   System.out.println("records found:");
    		   WebElement status=driver.findElement(By.xpath("//table/tbody/tr/td[6]"));
    		   System.out.println("status of the appalied leaves: "+status.getText());
    		   
    	   }
       }
	}
	@AfterClass
	public void after() {
		driver.quit();
		
	}
	
	

}

