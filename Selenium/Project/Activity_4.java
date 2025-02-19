package HRM_Project_selenium;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity_4 
{
	WebDriver driver;
	String message;
	WebDriverWait wait;
	String firstName = "Test__123";
	String lastName = "Test__123";
		
	@BeforeClass
	public void setup() 
    {
		//create a WebDriver instance
		driver = new FirefoxDriver();
        
        //go to a web page
		driver.get("http://alchemy.hguy.co/orangehrm");

		//do stuff on the page
		System.out.println("Title of the main page is : " + driver.getTitle());
    }
	
	@BeforeTest
	public void setupBeforeTest() 
    {
		// Initialize wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));		
    }
 
	@AfterClass
	public void tearDown() 
	{
 	     // Close the driver
		//driver.close();
	}
	
	@DataProvider(name = "LoginCredientials")
	public static Object[][] credentials() {
	    return new Object[][] { 
	        { "orange", "orangepassword123", "Welcome Mary" }
	    };
	}
	
	@Test(priority = 1, dataProvider = "LoginCredientials")
    public void login(String sUsername, String sPassword, String expectedMessage) 
    {
		// Find the username and password fields
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.name("txtPassword"));

        // Enter credentials
        username.sendKeys(sUsername);
        password.sendKeys(sPassword);

        // Click login
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();

        System.out.println("Title of the new page is : " + driver.getTitle());
        
        // Read login message
        String loginMessage = driver.findElement(By.id("welcome")).getText();
        
        System.out.println("Confirmation message is - " + loginMessage);
        
        //Verify that the homepage has opened
        message = driver.findElement(By.tagName("h1")).getText();
        System.out.println("You are on " + message);
        
        Assert.assertEquals(message, "Dashboard");
    }
	

	@Test(priority = 2)
    public void addEmployeeToPIM() 
    {
		//Find the PIM option in the menu and click it.
		
		WebElement PIM=driver.findElement(By.xpath("//div[@class='menu']/ul/li[2]/a"));
		System.out.println("Currently on "+PIM.getText()+" Page");
		PIM.click();
		
		//WebElement emp_name=driver.findElement(By.id("empsearch_employee_name_empName"));
		//emp_name.sendKeys("testng");
		//adding member
		WebElement add_btn=driver.findElement(By.id("menu_pim_addEmployee"));
		add_btn.click();
		WebElement f_name= driver.findElement(By.id("firstName"));
		f_name.sendKeys(firstName);
		WebElement l_name=driver.findElement(By.id("lastName"));
		l_name.sendKeys(lastName);
		//saved
		System.out.println("member added: "+f_name+""+l_name);
		driver.findElement(By.id("btnSave")).click();
		
        
    }

	@Test(priority = 3)
    public void searchEmployeeToPIM()
    {
		//Find the PIM option in the menu and click it.
		WebElement PIM=driver.findElement(By.xpath("//div[@class='menu']/ul/li[2]/a"));
		System.out.println("Currently on "+PIM.getText()+" Page");
		PIM.click();
		
		//click on Employee list
		//driver.findElement(By.xpath("//*[@id=\"menu_pim_viewEmployeeList\"]")).click();
     
        
		String input = firstName+" "+lastName;
		System.out.println("Searching for employee :  " + input);
		
		WebElement search_employee=driver.findElement(By.id("empsearch_employee_name_empName"));
        search_employee.sendKeys(input);
        search_employee.click();
        
        List<WebElement> searchData = driver.findElements(By.xpath("//div[@class='ac_results']/ul/li"));
        System.out.println("Select name from dropdown : ");
            
        System.out.println("Dropdown list values : " + searchData.size());
	    //iterate the dropdown list
        for(int i=0; i < searchData.size(); i++) 
        {
        	System.out.println(searchData.get(i).getText());
            
            if (searchData.get(i).getText().contains(input))
            {
            	System.out.println("Match found, selecting the option : " + searchData.get(i).getText());
            	searchData.get(i).click();
            	System.out.println("Clicked!");
            	break;
            }
            else 
            {
            	System.out.println("Match not found, selecting next option ");
            }
        }
        
        WebElement search = driver.findElement(By.xpath("//*[@id=\"searchBtn\"]"));
        
        // click on search button
        search.click(); 
        
	    //get detail form result table
        //Find the number of columns from header in the table and print them.
	    List<WebElement> cols = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/thead/tr/th"));
	    System.out.println("total number of columns in header: " + cols.size()); 
        
        //Find the number of rows in the table and print them. 
	    List<WebElement> row = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr"));
	    System.out.println("total number of rows in header: " + row.size());

	    for (int i = 1; row.size() >= i; ++i)
	    {
	    	int a = i;
	    	
	    	//Find and print all the cell values in the first row of the table.
	    	List<WebElement> rowData = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[" + a + "]"));
	    
	    	System.out.println(a + " row cell values: ");
	    	
	    	if (rowData.get(0).getText().contains("No Records Found"))
    		{
    			System.out.println("No Records Found..!!");
    			break;
    		}
	    	else
	    	{
	    		for(WebElement cell : rowData) 
	    		{
	    			System.out.println(cell.getText());
	    		}
	    	}
	    
	    	//Find and print the first name and last name from column.
	    	WebElement fName = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[" + a + "]/td[3]"));
	    	System.out.println("First Name: " + fName.getText());
	    	
	    	WebElement lName = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[" + a + "]/td[4]"));
	    	System.out.println("Last Name: " + lName.getText());
	    }
    }

}