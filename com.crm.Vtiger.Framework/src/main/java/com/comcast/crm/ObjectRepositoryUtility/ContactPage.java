package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	public ContactPage(WebDriver driver) {

		PageFactory.initElements( driver,this);//this >>refers to current class object

	}
	

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement Contactplusicon;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	public WebElement getContactplusicon() {
		return Contactplusicon;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getMobilenumber() {
		return mobilenumber;
	}

	public WebElement getSavebtn() {
		return Savebtn;
	}

	@FindBy(name="mobile")
	private WebElement mobilenumber;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	private WebElement Savebtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement Expectedtoconfirm;

	public WebElement getExpectedtoconfirm() {
		return Expectedtoconfirm;
	}
	
	
	
}
