package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity4Test {
	
	public static void main(String[] args) {
		  
	    // Initializing a driver
	    WebDriver driver = new FirefoxDriver();
	    
	    // Open the browser
	    driver.get("https://training-support.net/webelements/target-practice");
	    System.out.println(driver.getTitle());
	    
	    WebElement Header3 = driver.findElement(By.xpath("//*[contains(text(),'Heading #3')]"));
	    System.out.println(Header3);
	    
	    WebElement Header5 = driver.findElement(By.xpath("//*[contains(text(),'Heading #5')]"));
	    System.out.println(Header5);
	    
	 // Open the page
        driver.get("https://training-support.net/webelements/target-practice");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the 3rd header and print its text
        String thirdHeaderText = driver.findElement(By.xpath("//h3[contains(text(), '#3')]")).getText();
        System.out.println(thirdHeaderText);
        // Find the 5th header and print its color
        Color fifthHeaderColor = Color.fromString(driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color"));
        System.out.println("Color as RGB: " + fifthHeaderColor.asRgb());
        System.out.println("Color as hexcode: " + fifthHeaderColor.asHex());

        // Find the violet button and print its classes
        String purpleButtonClass = driver.findElement(By.xpath("//button[text()='Purple']")).getDomAttribute("class");
        System.out.println(purpleButtonClass);
        // Find the grey button and print its text
        String slateButtonText = driver.findElement(By.xpath("//button[contains(@class, 'slate')]")).getText();
        System.out.println(slateButtonText);
	    driver.quit();
	  }

}