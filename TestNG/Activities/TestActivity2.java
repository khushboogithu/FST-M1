package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity2 {
	
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
	public void pageTitleTest()
	{
		Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
		
	}
	
	@Test(dependsOnMethods = {"pageTitleTest"})
	public void blackButtonTest()
	{
		WebElement slateButton = driver.findElement(By.xpath("//button[text()='Slate']"));
        Assert.assertTrue(slateButton.isDisplayed());
        Assert.assertEquals(slateButton.getText(), "Slate");
		//WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        //Assert.assertTrue(blackButton.isDisplayed());
        //Assert.assertEquals(blackButton.getText(), "black");
		
	}
	
	@Test(priority = 2, enabled = false)
    public void skipTestCase1() {
        // This test will be skipped and not counted
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }
 
    @Test(priority = 3)
    public void skipTestCase2() throws SkipException {
        // This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case");
    }
    
    
	//Browser cleanup function
	@AfterClass
	public void tearDown()
	{
		//Close the browser
		driver.quit();
		
	}



}
