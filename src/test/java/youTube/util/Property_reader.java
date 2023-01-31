package youTube.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.Currency;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import youtubeYT.tests.SearchPage_YT;

public class Property_reader {
	public Properties obj;
	public static WebDriver driver=null;
	 public void Elements(){
			try {
				obj = new Properties();
				FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/Resources/Object_Repo.properties");
				obj.load(objfile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			}
	}
	 
		public void screenshot() throws IOException {
			java.util.Date curDate= new java.util.Date();
			String ScrFileName= curDate.toString().replace(" ","-").replace(":","-");
			 File ScrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(ScrFile, new File(".//Test_Screenshots//"+ScrFileName + ".jpg"));
		}
	 
 }
