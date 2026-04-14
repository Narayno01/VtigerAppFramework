package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.Framework.WebDriverUtility.WebDriverUtility;

    public class LoginPage extends WebDriverUtility{
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		
	this.driver=driver;
	PageFactory.initElements(driver, this);	
	
	}
    @FindBy(name="user_name")
	private WebElement usernameEdt;
    
    @FindBy(xpath="//input[@type='password']")
    private WebElement passwordEdt;
    
    @FindBy(id="submitButton")
    private WebElement loginbutton;

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
    
	//provide action for business utility.
	
	public void loginToapp(String username, String password) {
		waitForPagetoLoad(driver);
		//driver.get(url);;
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginbutton.click();
		
	}
    
}
