package activities;

//import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity14 {

	public static void main(String[] args) {
		
		// Initializing a driver
	    WebDriver driver = new FirefoxDriver();
	    //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    
	    // Open the browser
	    driver.get("https://training-support.net/webelements/tables");
	    System.out.println(driver.getTitle());
	    
	    //Print the number of rows and columns
	    List<WebElement> columns = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th"));
	    
	    List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'table-auto')]/tbody/tr"));
	    
	    System.out.println("No. of rows: " + rows.size());
	    
	    System.out.println("No. of columns: " + columns.size());
	    
	    //Print the 5th row book title from the table
	    
	    WebElement fifthRowbook = driver.findElement(By.xpath("//table[contains(@class,'table-auto')]/tbody/tr[3]/td[2]"));
	    
	    System.out.println("the 5th row book title from the table: " + fifthRowbook.getText());
	    
	    //Sort the table by price
	    
	    driver.findElement(By.xpath("//table[contains(@class,'table-auto')]/thead/tr/th[5]"));	    
	        
	    // Print the 5th row book title from the table again
	    
	    System.out.println("the 5th row book title from the table: " + fifthRowbook.getText());
	    
	    // close the browser
	    driver.quit();
	    
		}  
}
