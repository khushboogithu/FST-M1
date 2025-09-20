package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	
	//Declaring the required drivers
			AppiumDriver driver;
			WebDriverWait wait;
			
			//Setup function
			@BeforeClass
			public void setUp() throws MalformedURLException, URISyntaxException
			{
				//Set the Capabilities
				UiAutomator2Options options = new UiAutomator2Options();
				options.setPlatformName("android");
				options.setAutomationName("UiAutomator2");
				options.noReset();
				//options.setApp("C:/Users/Khushboo/OneDrive - IBM/other/Desktop/FST/Calculator.apk");
				
				//Only for Android
				options.setAppPackage("com.android.chrome");
				options.setAppActivity("com.google.android.apps.chrome.Main");
				
				//Set the appium Server URL
				URL serverUrl = new URI("http://localhost:4723").toURL();
				
				//Initialize the driver
				driver = new AndroidDriver(serverUrl, options);
				
			}
			
			//Test Method
			
			@Test		
			public void chromeAccess()
			{
				// Open the browser with the URL
				driver.get("https://training-support.net");

				// Locate heading on page and print it
				//String pageTitle = driver.findElement(AppiumBy....()).getText();
				//System.out.println("Heading: " + pageTitle);
				
			}
			
			
			@AfterClass
			public void tearDown()
			{
				driver.quit();
			}

}
