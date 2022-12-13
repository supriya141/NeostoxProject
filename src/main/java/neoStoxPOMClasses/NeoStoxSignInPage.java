package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import neoStoxUtility.UtilityNew;

public class NeoStoxSignInPage {
	
	@FindBy(xpath="//a[text()='Sign In']")private WebElement signInButton;
	public NeoStoxSignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignInButton(WebDriver driver)
	{
		UtilityNew.wait(driver, 1000);
		signInButton.click();
	}
	

}
