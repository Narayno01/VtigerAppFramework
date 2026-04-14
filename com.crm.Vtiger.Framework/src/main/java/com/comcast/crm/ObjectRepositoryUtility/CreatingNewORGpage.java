package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewORGpage {

	public CreatingNewORGpage(WebDriver driver) {

		PageFactory.initElements(driver,this);

	}

	@FindBy(xpath="//input[@name='accountname']")
	WebElement AddOrgName;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement AddphoneNum;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	WebElement Savebtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	WebElement ActualOrgNameAdded;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	WebElement Addlastname;

	

	public WebElement getAddlastname() {
		return Addlastname;
	}

	public WebElement getActualOrgNameAdded() {
		return ActualOrgNameAdded;
	}

	public WebElement getAddOrgName() {
		return AddOrgName;
	}

	public WebElement getAddphoneNum() {
		return AddphoneNum;
	}

	public WebElement getSavebtn() {
		return Savebtn;
	}
	
}

