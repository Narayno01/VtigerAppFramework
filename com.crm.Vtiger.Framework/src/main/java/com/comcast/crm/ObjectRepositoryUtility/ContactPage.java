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
	
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement Orgplus_icon;
	
	@FindBy(name="support_end_date")
	private WebElement end_date;
	
	@FindBy(name="support_start_date")
	private WebElement start_date;

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement header_info;
	
	@FindBy(name="//span[@id='dtlview_Last Name']")
	private WebElement Expected_lastname;
	
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=DetailView&record=2']")
	private WebElement Expected_orgname;
	

	
	

	public WebElement getHeader_info() {
		return header_info;
	}

	public WebElement getExpected_lastname() {
		return Expected_lastname;
	}

	public WebElement getExpected_orgname() {
		return Expected_orgname;
	}

	public WebElement getEnd_date() {
		return end_date;
	}

	public WebElement getStart_date() {
		return start_date;
	}

	public WebElement getOrgplus_icon() {
		return Orgplus_icon;
	}

	
	
	
	
	
	
}
