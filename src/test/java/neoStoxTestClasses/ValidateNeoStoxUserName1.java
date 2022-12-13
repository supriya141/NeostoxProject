package neoStoxTestClasses;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.annotations.BeforeMethod;

import neoStoxBase.Base;
import neoStoxPOMClasses.NeoStoxHomePage;
import neoStoxPOMClasses.NeoStoxLoginPage;
import neoStoxPOMClasses.NeoStoxPasswordPage;
import neoStoxPOMClasses.NeoStoxSignInPage;

import neoStoxUtility.UtilityNew;

public class ValidateNeoStoxUserName1 extends Base{
	NeoStoxLoginPage login;
	NeoStoxPasswordPage password;
	NeoStoxHomePage home;
	NeoStoxSignInPage signIn;
	
	@BeforeClass
	public void launchNeoStox() throws InterruptedException
	{
		launchBrowser();
		signIn=new NeoStoxSignInPage(driver);
		login=new NeoStoxLoginPage(driver);
		password=new NeoStoxPasswordPage(driver);
		home=new NeoStoxHomePage(driver);
		
	}
	
	@BeforeMethod
	public void loginItoNeostox() throws EncryptedDocumentException, IOException, InterruptedException {
		signIn.clickOnSignInButton(driver);
		UtilityNew.wait(driver,1000);
		login.sendMobileNo(driver, UtilityNew.readDataFromPropertyFile("mobNum"));
		login.clickOnSignInButton(driver);
		UtilityNew.wait(driver, 1000);
		password.enterPassword(driver, UtilityNew.readDataFromPropertyFile("password"));
		Thread.sleep(1000);
		password.clickOnSubmitButton(driver);
		Thread.sleep(1000);
		home.handlePopUp(driver);
		
		
		
	}
	
	
	
  @Test(priority=-1)
  public void validateUserID() throws EncryptedDocumentException, IOException {
	  
	  Assert.assertEquals(home.getActualUserName(driver), UtilityNew.readDataFromPropertyFile("userName"),"TC is failed Actual and expected User Name not matching");
	  UtilityNew.screenshot(driver, home.getActualUserName(driver));
  }
  
  @Test
  public void validateAccountBalance() throws IOException
  {
	  Assert.assertNotNull(home.getAccountBalance(driver),"TC is failed unable to fetch account balance");
	  UtilityNew.screenshot(driver, home.getActualUserName(driver)+" Account Balance");
  }
  
  @AfterMethod
  public void logOut()
  {
	  home.logOut(driver);
  }

@AfterClass
public void closeBrowser()
{
	driver.close();
	
}

}
