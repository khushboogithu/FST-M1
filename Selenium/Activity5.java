package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {
    public static void main(String[] args) {
        //Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open page
        driver.get("https://training-support.net/webelements/dynamic-controls");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        //checkbox
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        
        //toggle button
        driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
        
        // Check if it is displayed on the page
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());
        
        // Click the button again
        driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
        
        // Check if it is displayed on the page
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());

        // Close browser
        driver.quit();
    }
}