package neoStoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityNew {

	//screenshot scrolling wait excel reading
	
	public static String readDataFromPropertyFile(String key) throws EncryptedDocumentException, IOException
	{
		Properties prop=new Properties();
				
		FileInputStream myFile=new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\Selenium Project\\propertyFile.properties");
		prop.load(myFile);
		String value=prop.getProperty(key);
		Reporter.log("reading "+key+" from property file",true);
		return value;
		
	}
	
	public static void screenshot(WebDriver driver,String screenShotName) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("G:\\Supriya selenium\\screeshot\\"+screenShotName+".png");
		FileHandler.copy(src, dest);
		Reporter.log("taking screenshot", true);
		
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		
			JavascriptExecutor js=(JavascriptExecutor)driver,WebElement;
			js.executeScript("js.arguments[0].scrollIntoView(true)",element);
			Reporter.log("Scrolling into view", true);
		
	}
	
	public static void wait(WebDriver driver,int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		Reporter.log("Waiting for time"+waitTime+"ms",true);
	}
	
	
	

}

