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
	
	@FindBy(xpath="//select[@name='industry']")
	WebElement AddIndustry;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	WebElement Expected_OrgNameAdded;
	
	@FindBy(xpath="//select[@name='accounttype']")
	WebElement AddType;
	
	@FindBy(id="dtlview_Phone")
	WebElement Expected_Phonenum;
	
	public WebElement getExpected_Phonenum() {
		return Expected_Phonenum;
	}

	public WebElement getAddIndustry() {
		return AddIndustry;
	}

	public WebElement getExpected_OrgNameAdded() {
		return Expected_OrgNameAdded;
	}

	public WebElement getAddType() {
		return AddType;
	}

	public WebElement getActualOrgNameAdded() {
		return Expected_OrgNameAdded;
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

