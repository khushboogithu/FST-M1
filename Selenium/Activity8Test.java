package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity8Test {
	
	public static void main(String[] args) {
		  
	    // Initializing a driver
	    WebDriver driver = new FirefoxDriver();
	    Actions builder = new Actions(driver);
	    
	    // Open the browser
	    driver.get("https://training-support.net/webelements/mouse-events");
	    System.out.println(driver.getTitle());	    
	    
	    //find all the button on the page	    
	    WebElement cargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
	    WebElement cargoToml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
	    WebElement srcButton = driver.findElement(By.xpath("//h1[text()='src']"));
	    WebElement targetButton = driver.findElement(By.xpath("//h1[text()='target']"));
	    
	    /*Left click on the Cargo.lock button, 
	    move the cursor to the Cargo.toml button and then click it. 
	    Print the confirmation text at the end of the sequence.*/    
	    
	    builder.click(cargoLock).pause(5000L).moveToElement(cargoToml).pause(5000L).click().build().perform();
	    
	    //print the message at the end of the sequence
	    System.out.println(driver.findElement(By.id("result")).getText());
	    
	    /*Double click on the src button. 
	     * Then right click on the target button and select open.
	     *  Print the confirmation text at the end of the sequence.*/
	    
	    builder.doubleClick(srcButton).pause(5000L).contextClick(targetButton).pause(5000L).build().perform();
	    
	    //Click on Open option
	    
	    driver.findElement(By.xpath("//div[@id='menu']//ul/li[1]")).click();
	    
	  //print the message at the end of the sequence
	    System.out.println(driver.findElement(By.id("result")).getText());
	    
	    
	    
	   driver.quit();
	  }

}
