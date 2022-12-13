package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


import neoStoxUtility.UtilityNew;

public class NeoStoxHomePage {
	
	@FindBy(xpath="(//a[text()='OK'])[2]")private WebElement okButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]")private WebElement closeButton;
	@FindBy(id="lbl_username")private WebElement userName;
	@FindBy(id="lbl_curbalancetop")private WebElement acBalance;
	@FindBy(xpath="//span[text()='Logout']")private WebElement logOut;
	
	public NeoStoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void handlePopUp(WebDriver driver) throws InterruptedException
	{
		if(okButton.isDisplayed())
		{
		UtilityNew.wait(driver, 1000);
		okButton.click();
		Reporter.log("clicking on ok button", true);
		UtilityNew.wait(driver, 1000);
		closeButton.click();
		Reporter.log("clicking on close button", true);
		}
		else
		{
			Thread.sleep(1000);
		}
	}
	
	public String getActualUserName(WebDriver driver)
	{
		UtilityNew.wait(driver, 1000);
			String realUserName=userName.getText();
			String actualUserName=realUserName.substring(3);
			Reporter.log("Actual User Name "+actualUserName, true);
			
		return actualUserName;
		
	}
	
	public String getAccountBalance(WebDriver driver)
	{
		UtilityNew.wait(driver, 1000);
		String accBalance=acBalance.getText();
		Reporter.log("Account Balance is "+accBalance,true);
		return accBalance;
		
	}
	
	public void logOut(WebDriver driver)
	{
		UtilityNew.wait(driver, 1000);
		userName.click();
		UtilityNew.wait(driver, 1000);
		logOut.click();
		
	}
}
