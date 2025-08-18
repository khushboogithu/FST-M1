package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {
    public static void main(String[] args) {
        //Firefox driver
        WebDriver driver = new FirefoxDriver();
        
        // Open page
        driver.get("https://training-support.net/webelements/dynamic-controls");
        
        // Page title
        System.out.println("Page title: " + driver.getTitle());

        //text field
        WebElement textbox = driver.findElement(By.id("textInput"));
        
        // Check if it is enabled
        System.out.println("Input field is enabled: " + textbox.isEnabled());
        
        // Click the toggle button to enable it
        driver.findElement(By.id("textInputButton")).click();
        
        // Check if the text field is enabled
        System.out.println("Input field is enabled: " + textbox.isEnabled());
        
        // Type something in to it
        textbox.sendKeys("Example text");
        System.out.println(textbox.getDomProperty("value"));

        // Close browser
        driver.quit();
    }
}