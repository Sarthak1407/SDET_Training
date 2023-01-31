package youtubeYT.tests;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import youTube.util.*;

public class HomePage_YT extends Property_reader {
	//WebDriver driver;
	//public Properties obj;
	@BeforeClass (groups = "Smoke")
	@Parameters("Browser")
	public void Launch_browser(@Optional String Browser) {
		String S1= "Chrome";
		Browser = "Chrome";
		if(Browser.equals(S1)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();	
	}
	
    @Test(groups = "Smoke")//(retryAnalyzer = youTube.util.RetryAnalyzerYT.class) // for using retry analyzer for specific test
    public void Test01_Launch_application() 
    {
    	Elements();
    	driver.get(obj.getProperty("URL"));
    	String ExpectedTitle = "YouTube";
    	String ActualTitle = driver.getTitle();
    	Assert.assertEquals(ExpectedTitle, ActualTitle, "Title mismatch:" );
    }
    @Test(groups = "Smoke")
    public void Test02_Verfiy_Music_Tab_Hor_menu_is_present()  {
    	Elements();
    	WebElement var1= driver.findElement(By.xpath(obj.getProperty("Horizontal_Music")));	
    	var1.click();
    	Assert.assertEquals(true, var1.isDisplayed(), "Music tab is available");
    	
    }
    @Test
    public void Test03_Verify_search_bar_is_present() {
    	Elements();
    	WebElement search= driver.findElement(By.cssSelector(obj.getProperty("search_Bar")));	
    	Assert.assertEquals(true, search.isDisplayed(), "Search_bar is available");
    }
   
    @AfterClass(groups = "Smoke")
    public void EndSession() {
    	driver.close();
    }
   
}

