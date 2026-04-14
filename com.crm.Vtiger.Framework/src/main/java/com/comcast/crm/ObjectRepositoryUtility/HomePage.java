package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {

		PageFactory.initElements( driver,this);//this >>refers to current class object

	}

	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;

	@FindBy(linkText="Contacts")
	private WebElement contactLink;


	@FindBy(linkText = "Leads")
	private WebElement leadLink;

	@FindBy(linkText = "Products")
	private WebElement productLink;

	@FindBy(linkText = "Opportunities")
    private WebElement opportunitiesLink;

	@FindBy(linkText = "Email")
	private WebElement emailLink;

	@FindBy(linkText = "Trouble Tickets")
	private WebElement troubleTicketsLink;

	@FindBy(linkText = "Documents")
	private WebElement documentsLink;

	@FindBy(linkText = "Dashboard")
	private WebElement dashboardLink;

	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homeIcon;

	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;

	@FindBy(linkText="More")
	private WebElement moreLink;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;



	

	public WebElement getOrgLink() {
		return orgLink;

	}



	public WebElement getContactLink() {
		return contactLink;

	}

	public WebElement getLeadLink() {
		return leadLink;

	}



	public WebElement getProductLink() {
		return productLink;

	}



	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;

	}

	public WebElement getEmailLink() {
		return emailLink;
	}

	public WebElement getTroubleTicketsLink() {
		return troubleTicketsLink;

	}



	public WebElement getDocumentsLink() {
		return documentsLink;

	}

	public WebElement getDashboardLink() {
		return dashboardLink;

	}

	public WebElement getHomeIcon() {
		return homeIcon;

	}

	public WebElement getCampaignLink() {
		return campaignLink;

	}

	public WebElement getMoreLink() {
		return moreLink;

	}

	public WebElement getAdminImg() {
		return adminImg;

	}

	public WebElement getSignout() {
		return signout;

	}

	public void navigateToCampaigninPage(WebDriver driver) {
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignLink.click();

	}

	public void logout(WebDriver driver) {
		Actions act=new Actions(driver);
		act.moveToElement(adminImg).perform();
		signout.click();

	}
	
	    }

