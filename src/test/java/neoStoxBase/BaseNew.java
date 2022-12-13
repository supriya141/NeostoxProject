package neoStoxBase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;

public class BaseNew {
	protected WebDriver driver;
	public void launchBrowser() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		System.setProperty("webdriver.chrome.driver","G:\\Supriya selenium\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();  //to maximize window
		driver.get(UtilityNew.readDataFromPropertyFile("url"));  //to open or hit url
		
		Reporter.log("Launching Browser",true);
		Thread.sleep(1000);
		
		
		
		
	}
	
}
