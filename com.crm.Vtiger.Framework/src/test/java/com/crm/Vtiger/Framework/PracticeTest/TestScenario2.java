package com.crm.Vtiger.Framework.PracticeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.CreatingNewORGpage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.ThroughContact_Orgpage;
import com.crm.Vtiger.Framework.Base.BaseClass;

public class TestScenario2 extends BaseClass {

	@Test
	public void Testing1() throws IOException {
        String lastname=Elib.getDataFromExcelFile("Sheet1", 10, 2)+Jlib.getRandomNumber();

		// click on create contact add name and phone number
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		//add data in textfield
		ContactPage cnp=new ContactPage(driver);
		cnp.getContactplusicon().click();
		cnp.getLastname().sendKeys(lastname);
		cnp.getSavebtn().click();
	    String Expected=cnp.getExpected_lastname().getText();
		
	    Assert.assertEquals(true, Expected.contains(lastname));
	    
	 
			

	   
}
	@Test
	public void Testing2() throws IOException {
		

		String lastname=Elib.getDataFromExcelFile("Sheet1", 13, 2)+Jlib.getRandomNumber();

		
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		
		ContactPage cnp=new ContactPage(driver);
		cnp.getContactplusicon().click();
		cnp.getLastname().sendKeys(lastname);
					
					//support start date
	    String start=Jlib.getSystemDate();
        String end=Jlib.getRequiredDate(30);
		            cnp.getStart_date().clear();
		            cnp.getStart_date().sendKeys(start);
		            cnp.getEnd_date().clear();
		            cnp.getEnd_date().sendKeys(end);
		            cnp.getSavebtn().click();
				
					String Expected_name=cnp.getExpected_lastname().getText();
					
					Assert.assertEquals(true, Expected_name.contains(lastname));
					
    			 
	}	    
    			    @Test
    			    public void Testing3() throws IOException {
    			    
    			    	String lastname=Elib.getDataFromExcelFile("Sheet1", 13, 2)+Jlib.getRandomNumber();
                        String OrgName=Elib.getDataFromExcelFile("Sheet1", 7, 2)+Jlib.getRandomNumber();
    					
    					HomePage hp=new HomePage(driver);
    					hp.getOrgLink().click();
    					
    					OrganizationPage org= new OrganizationPage(driver);
    					org.getCreateNewOrgBtn().click();
    					
    					CreatingNewORGpage crog= new CreatingNewORGpage(driver);
    				
    					crog.getAddOrgName().sendKeys(OrgName);
    					crog.getSavebtn();
    					
    					String Expected_orgname=crog.getActualOrgNameAdded().getText();
    					
    					Assert.assertEquals(true, Expected_orgname.contains(OrgName));

    					

    					
    					//Contact Page
    					hp.getContactLink().click();
    					
    					ContactPage Cpage=new ContactPage(driver);
    					
    					Cpage.getContactplusicon();
    					Cpage.getLastname().sendKeys(lastname);
    					
    					Cpage.getOrgplus_icon().click();
    					
    					
    					ThroughContact_Orgpage Ntab= new ThroughContact_Orgpage(driver);
    					String partialUrl=Ntab.PartialUrl();
    					Wlib.switchNewBrowserTab(driver, partialUrl);
    				    
    					WebElement Ele=Ntab.getDropdown_forOrg();
    				    Wlib.selectbyVText(Ele, "Organization Name");
    				    
    				    Ntab.getAddText_toSearch().sendKeys(OrgName);
    				    Ntab.getSearch_nowbtn();
    				    
    				    Ntab.getVerify_orgname().click();
    					
    				    Wlib.switchTo_mainTab(driver);
    				    Cpage.getSavebtn(); 
    				    
    				   String Header_lastname= Cpage.getHeader_info().getText();
    				

    				   Assert.assertEquals(true, Header_lastname.contains(lastname));
    					  
    					  
    					  
    					  
    					  
    					  //Verify Header orgName info ==Expected result
    					  
    					 String Lastname=Cpage.getExpected_lastname().getText();
    					  
    					 Assert.assertEquals(true, Lastname.contains(lastname));
    					  
    					  
    					  System.out.println(lastname+" is not created ==FAIL");
    					  
    					  String actualorgname=Cpage.getExpected_orgname().getText();
    					  
    					  //verify header orgName expected result
    					  
    					  Assert.assertEquals(true, actualorgname.trim().equals(OrgName));
    					 
    					 
    					 
    					
    					
    					
    				
}
}
