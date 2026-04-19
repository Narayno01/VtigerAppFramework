package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThroughContact_Orgpage {

	WebDriver driver;
    
	public ThroughContact_Orgpage(WebDriver driver) {
		
	this.driver=driver;
	PageFactory.initElements(driver, this);	
	
	
	}
	
	  @FindBy(xpath="//select[@name='search_field']")
		private WebElement dropdown_forOrg;
	
	  @FindBy(id="search_txt")
	  private WebElement AddText_toSearch;
	  
	  @FindBy(xpath="//input[@type='button']")
	  private WebElement Search_nowbtn;
	  
	  @FindBy(id="1")
	  private WebElement verify_orgname;
	  
	  public WebElement getVerify_orgname() {
		return verify_orgname;
	}

	

	public WebElement getDropdown_forOrg() {
		return dropdown_forOrg;
	}

	public WebElement getAddText_toSearch() {
		return AddText_toSearch;
	}

	public WebElement getSearch_nowbtn() {
		return Search_nowbtn;
	}

	public String PartialUrl() {
		  String Partial_url=driver.getCurrentUrl();
		  return Partial_url;
	  }
	  
	  
}
