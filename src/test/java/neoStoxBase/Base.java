package neoStoxBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Base {
	protected WebDriver driver;
	public void launchBrowser() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","G:\\Supriya selenium\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();  //to maximize window
		driver.get("https://neostox.com/");  //to open or hit url
		
		Reporter.log("Launching Browser",true);
		Thread.sleep(1000);
		
	}

}
