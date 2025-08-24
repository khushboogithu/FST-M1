package project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;

public class TestActivity7project {
	
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
		driver.get("https://alchemy.hguy.co/jobs/");		
	}
	
	@Test(priority = 1)
	public void homePageTest()
	{
		Assert.assertEquals(driver.getTitle(), "Alchemy Jobs – Job Board Application");
		
	}
	
	@Test(dependsOnMethods = {"homePageTest"})
	public void postJobPageTest() throws InterruptedException
	{
		WebElement postJob = driver.findElement(By.linkText("Post a Job"));
		postJob.click();
		Assert.assertEquals(driver.getTitle(), "Post a Job – Alchemy Jobs");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Post a job details			    
		
		WebElement yourEmail = driver.findElement(By.id("create_account_email"));
		String yourEmailrandom = RandomStringUtils.randomAlphanumeric(8);
		String yourEmailText = yourEmailrandom + "@test.com";
        System.out.println("Job Email: " + yourEmailText);
		yourEmail.sendKeys(yourEmailText);		
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));		
		
		WebElement jobTitle = driver.findElement(By.xpath("//input[@id='job_title']"));
		String jobTitletext = RandomStringUtils.randomAlphabetic(8);
        System.out.println("Job Title: " + jobTitletext);
		jobTitle.sendKeys(jobTitletext);		
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement jobDescription = driver.findElement(By.id("job_description_ifr"));
		jobDescription.sendKeys("test");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement jobApplicationURL = driver.findElement(By.xpath("//input[@id='application']"));
		jobApplicationURL.sendKeys("test@test.com");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement companyName = driver.findElement(By.id("company_name"));
		companyName.sendKeys("test");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		WebElement previewButton = driver.findElement(By.xpath("//input[@type='submit'][@name='submit_job'][@value='Preview']"));
		previewButton.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		WebElement submitListingButton = driver.findElement(By.xpath("//input[@type='submit'][@name='continue'][@id='job_preview_submit_button']"));
		submitListingButton.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		WebElement jobPostedSuccessMessage = driver.findElement(By.xpath("//div[contains(text(), 'Job listed successfully. To view your listing ')]"));
		System.out.println("Message: " + jobPostedSuccessMessage.getText());						
		Assert.assertEquals(jobPostedSuccessMessage.getText(), "Job listed successfully. To view your listing click here.");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		WebElement jobsLink = driver.findElement(By.xpath("//a[text()='Jobs']"));
		jobsLink.click();
		
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        
        //Job Search page
		
        //Enter Keyword
		WebElement jobsSearchKeyword = driver.findElement(By.xpath("//input[@id='search_keywords']"));
		jobsSearchKeyword.sendKeys(jobTitletext);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		//Click on search
		WebElement jobsSearchButton = driver.findElement(By.xpath("//input[@type='submit'][@value='Search Jobs']"));
		jobsSearchButton.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));		
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='job_listings']")));
		
		// Locate the container holding all the search results.
		// Replace with the actual locator.
		List<WebElement> jobRecords = driver.findElements(By.cssSelector("div.job_listings")); 
		System.out.println("Found " + jobRecords.size() + " job record(s).");
		
		for (WebElement job : jobRecords) {
		    try {
		        String sjobTitle = job.findElement(By.tagName("h3")).getText(); // Locate job title by h3 tag
		        String joblocation = job.findElement(By.className("location")).getText(); // Locate location by class
		        String jobType = job.findElement(By.className("job-type")).getText(); // Locate job type by class

		        System.out.println("Job Title: " + sjobTitle);
		        System.out.println("Location: " + joblocation);
		        System.out.println("Job Type: " + jobType);
		        System.out.println("--------------------");
		    } catch (Exception e) {
		        System.out.println("Skipping a malformed job record.");
		    }
		}
		
		//System.out.println("Next step");
		
		//Click on the searched record
		List<WebElement> searchListelements = driver.findElements(By.cssSelector("ul.job_listings"));
		for (WebElement jobs : searchListelements) {
		    try {
		    	WebElement tocheck = driver.findElement(By.tagName("h3"));
		        String checkk = jobs.findElement(By.tagName("h3")).getText(); // Locate job title by h3 tag
		        tocheck.click();
		        System.out.println(checkk);
		        
		    } catch (Exception e) {
		        System.out.println("Skipping a malformed job record.");
		    }
		}		
		//System.out.println("Clicked");
		
		
        driver.navigate().back();
		
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		WebElement clickHereLink = driver.findElement(By.xpath("//div[contains(text(), 'Job listed successfully. To view your listing ')]/a"));
		System.out.println("Click here Message: " + clickHereLink.getText());			
		clickHereLink.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
	    //Verify the record
	    String jobTitleMessage = driver.findElement(By.cssSelector("h1.entry-title")).getText();
	    Assert.assertEquals(jobTitletext, jobTitleMessage);
	    
	    wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    System.out.println("Test Passed, Activity7 is completed");
		
	}
	
	//Browser cleanup function
	@AfterClass
	public void tearDown()
	{
		//Close the browser
		driver.quit();
		
	}
	
	

}
