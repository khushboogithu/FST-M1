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

public class Activity3 {
	
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
				options.setApp("C:/Users/Khushboo/OneDrive - IBM/other/Desktop/FST/Calculator.apk");
				
				//Only for Android
				//options.setAppPackage("com.miui.calculator");
				//options.setAppActivity(".cal.CalculatorActivity");
				
				//Set the appium Server URL
				URL serverUrl = new URI("http://localhost:4723").toURL();
				
				//Initialize the driver
				driver = new AndroidDriver(serverUrl, options);
				
			}
			
			//Test Method
			
			@Test		
			public void multiply()
			{
				//Find the path to number and tap it
				driver.findElement(AppiumBy.id("digit_2"));
				//Find the path to multiply and tap it
				driver.findElement(AppiumBy.accessibilityId("multiply"));
				//Find the path to number and tap it
				driver.findElement(By.id("digit_5"));
				//Find the path to equals to and tap it
				driver.findElement(AppiumBy.accessibilityId("equals"));
				//find and assert the result
				String result = driver.findElement(AppiumBy.id("result_final")).getText();
				assertEquals(result,"10");	
				
				
			}
			
			
			@AfterClass
			public void tearDown()
			{
				driver.quit();
			}


}
