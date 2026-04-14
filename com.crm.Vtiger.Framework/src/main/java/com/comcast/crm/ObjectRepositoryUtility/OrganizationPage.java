package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	public OrganizationPage(WebDriver driver) {

		PageFactory.initElements(driver,this);

	}

	@FindBy(xpath="//img[@alt='Create Organization...']")
	WebElement createNewOrgBtn;

	@FindBy(name="search_text")
	WebElement searchTF;

	@FindBy(name="search_field")
	WebElement searchDd;

	@FindBy(name="submit")
	WebElement searchBtn;


	public WebElement getSearchBtn() {
		return searchBtn;

	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;

	}


	public WebElement getSearchTF() {
		return searchTF;

	}

	public WebElement getSearchDd() {
		return searchDd;

	}
	
}
