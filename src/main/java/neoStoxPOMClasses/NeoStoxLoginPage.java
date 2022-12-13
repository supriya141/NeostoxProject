package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


import neoStoxUtility.UtilityNew;

public class NeoStoxLoginPage {
	
	
	@FindBy(id="MainContent_signinsignup_txt_mobilenumber") private WebElement mobileNoField;
	@FindBy(id="lnk_signup1") private WebElement signInButton;
	
	public NeoStoxLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void sendMobileNo(WebDriver driver,String mobNum)
	{
		UtilityNew.wait(driver, 1000);
		mobileNoField.sendKeys(mobNum);
		Reporter.log("Entering Mobile No",true);
	}
	public void clickOnSignInButton(WebDriver driver)
	{
		UtilityNew.wait(driver, 1000);
		signInButton.click();
		Reporter.log("Clicking on SignIn Button",true);
	}
}
