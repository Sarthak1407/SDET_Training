package youtubeYT.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import youTube.util.Property_reader;

public class SearchPage_YT extends Property_reader {
	
	 
	@BeforeClass(groups = "Smoke")
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
	
    @Test(groups = "Smoke")
    public void Test11_Launch_application() 
    {
    	Elements();
    	driver.get(obj.getProperty("URL"));
    	String ExpectedTitle = "YouTub";
    	String ActualTitle = driver.getTitle();
    	Assert.assertEquals(ExpectedTitle, ActualTitle, "Title mismatch:" );
    }
    @Test(groups = "Smoke")
    public void Test12_Verfiy_Search_bar_is_working() throws Exception  {
    	Elements();
    	WebElement search= driver.findElement(By.cssSelector(obj.getProperty("search_Ba")));	
    	search.click();
    	search.sendKeys("What is ChatGPT? | The Hindu");
    	WebElement SBtn = driver.findElement(By.cssSelector(obj.getProperty("search_Btn")));
    	SBtn.click();
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    	String ActURL=	driver.getCurrentUrl();
    		Boolean A= ActURL.contains("ChatGPT");
    		System.out.println(A);
    		Assert.assertEquals(true, ActURL.contains("ChatGPT") ,"Search_bar is working");
    	
    }
    @Test
    public void Test13_Play_video_from_search_result() {
    	Elements();
    	WebElement video= driver.findElement(By.xpath(obj.getProperty("Video_CGPT")));	
    	video.click();
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	String ActURL = driver.getCurrentUrl();
    	Assert.assertEquals(true, ActURL.contains("watch?v=X-tI7I6ii-U"), "Video is played");
    }
    
	public void screenshot() throws IOException {
		 File ScrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(ScrFile, new File(".//Test_Screenshots//" + ".jpg"));
	}
   
    @AfterClass(groups = "Smoke")
    public void EndSession() {
    	driver.close();
    }

}
