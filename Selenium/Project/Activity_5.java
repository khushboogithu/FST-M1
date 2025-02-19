package HRM_Project_selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity_5 {
	WebDriver driver;
	@BeforeClass
	public void before() {
	driver=new FirefoxDriver();
	driver.get("http://alchemy.hguy.co/orangehrm");
	
	}
	
	@DataProvider(name="LoginCredientials")
		public static Object[][] credentials(){
			return new Object[][] { 
		        {"orange", "orangepassword123", "Welcome Mary" }
			
		   };
	}
	
	@Test(priority = 1, dataProvider = "LoginCredientials")
	public void login(String sUsername,String sPassword,String message) {
		
		// Find the username and password fields
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.name("txtPassword"));

        // Enter credentials
        username.sendKeys(sUsername);
        password.sendKeys(sPassword);

        // Click login
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();

        System.out.println("Title of the new page is : " + driver.getTitle());
        
        // Read login message
        String loginMessage = driver.findElement(By.id("welcome")).getText();
        
        System.out.println("Confirmation message is - " + loginMessage);
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("btnSave")).click();
        WebElement firstname=driver.findElement(By.id("personal_txtEmpFirstName"));
        firstname.clear();
        firstname.sendKeys("test");
       WebElement lastname =driver.findElement(By.id("personal_txtEmpLastName"));
      lastname.clear();
       lastname.sendKeys("test");
        driver.findElement(By.xpath("//ul[@class='radio_list']/li[2]")).click();
        WebElement nationality=driver.findElement(By.id("personal_cmbNation"));
        Select options=new Select(nationality);
        options.selectByVisibleText("Afghan");
        driver.findElement(By.id("personal_DOB")).clear();
        driver.findElement(By.id("personal_DOB")).sendKeys("2001-02-23");
        WebElement save=driver.findElement(By.id("btnSave"));
        save.click();
        System.out.println("fields are updated");
        System.out.println("Updated First Name : " + driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value"));
        System.out.println("Updated Last Name : " + driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value"));
    	System.out.println("Updated Gender : " + driver.findElement(By.id("personal_optGender_2")).isSelected());
    	System.out.println("Updated DOB : " + driver.findElement(By.id("personal_DOB")).getAttribute("value"));
        driver.quit();
        
        
        
        
		
	}
	@AfterClass
	public void after() {
		driver.quit();
		
	}
	
	

}
