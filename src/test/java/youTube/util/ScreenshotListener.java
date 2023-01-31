package youTube.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import youtubeYT.tests.SearchPage_YT;

public class ScreenshotListener extends Property_reader implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		try {
			screenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		try {
			screenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
