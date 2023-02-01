package savaan.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import javax.swing.plaf.basic.BasicEditorPaneUI;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import general.util.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage extends Property_reader {
	// WebDriver driver;
	// public Properties obj;
	@BeforeClass(groups = "Smoke")
	@Parameters("Browser")
	public void Launch_browser(@Optional String Browser) {
		String S1 = "Chrome";
		Browser = "Chrome";
		if (Browser.equals(S1)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
	}

	@Test(groups = "Smoke") // (retryAnalyzer = youTube.util.RetryAnalyzerYT.class) // for using retry
							// analyzer for specific test
	public void Test01_Launch_application() {
		Elements();
		driver.get(obj.getProperty("URL"));
		String ExpectedTitle = "Online Songs on JioSaavn: Download & Play Latest Music for Free";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle, "Title mismatch:");
	}

	@Test(groups = "Smoke")
	public void Test02_Verfiy_Search_menu_is_present() {
		Elements();
//    	WebElement var1= driver.findElement(By.xpath(obj.getProperty("Horizontal_Music")));
		WebElement ele1 = driver.findElement(By.cssSelector(obj.getProperty("search")));
//    	var1.click();
		ele1.isDisplayed();
		Assert.assertEquals(true, ele1.isDisplayed(), "Search bar is not available");
	}

	@Test
	public void Test03_Verify_User_Is_Able_To_Search() {
		Elements();
//		WebElement search = driver.findElement(By.cssSelector(obj.getProperty("search_Bar")));
//		Assert.assertEquals(true, search.isDisplayed(), "Search_bar is available");
		
		WebElement searchBar = driver.findElement(By.cssSelector(obj.getProperty("search")));
		searchBar.click();
		WebElement searchExpand = driver.findElement(By.cssSelector(obj.getProperty("searchBar")));
		searchExpand.sendKeys("Pathaan");
//		searchExpand.sendKeys(Keys.ENTER);
	}
	
	@Test
	public void Test04_Verify_Language_Dropdown_Is_Available() {
		driver.navigate().refresh();
		WebElement languageDropdown = driver.findElement(By.cssSelector(obj.getProperty("dropdownIcon")));
		languageDropdown.click();
		WebElement languageModel = driver.findElement(By.cssSelector(obj.getProperty("dropdownMenu")));
		languageModel.isDisplayed();
		Assert.assertEquals(true, languageModel, "Language Modal Not displaying");
	}

//	@AfterClass(groups = "Smoke")
//	public void EndSession() {
//		driver.close();
//	}

}
