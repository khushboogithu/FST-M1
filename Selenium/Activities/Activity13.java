package activities;

//import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity13 {

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
	    
	    //Find and print all the cell values in the third row of the table.
	    
	    WebElement thirdRow = driver.findElement(By.xpath("//table[contains(@class,'table-auto')]/tbody/tr[3]"));
	    
	    System.out.println("third row of the table: " + thirdRow.getText());
	    
	    //Find and print the cell value at the second row second column.
	    
	    WebElement row2cell2 = driver.findElement(By.xpath("//table[contains(@class,'table-auto')]/tbody/tr[2]/td[2]"));
	    
	    System.out.println("Second row, second cell: " + row2cell2.getText());
	    
	    // close the browser
	    driver.quit();
	    
		}  
}
