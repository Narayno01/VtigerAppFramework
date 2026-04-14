package com.crm.Vtiger.FrameworkTESTPractice;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtility.CreatingNewORGpage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.crm.Vtiger.Framework.Base.BaseClass;

public class SimpleTest extends BaseClass{

	@Test
	public void CreateOrgTest() throws EncryptedDocumentException, IOException {
		//read testScript data from Excel file
		String OrgName= Elib.getDataFromExcelFile("Sheet1", 4, 2)+Jlib.getRandomNumber();
		
		//Stage2: navigate to organization module
		HomePage hp= new HomePage(driver);
		hp.getOrgLink().click();
		
		//step 3: click on create Organization 
		OrganizationPage org= new OrganizationPage(driver);
		org.getCreateNewOrgBtn().click();
		
		//step 4: enter all the deatils and create new organization
		CreatingNewORGpage cnop= new CreatingNewORGpage(driver);
		cnop.getAddOrgName().sendKeys(OrgName);
		cnop.getSavebtn().click();
		
		//verify header msg expected result
		String Headermessage =cnop.getActualOrgNameAdded().getText();
		Assert.assertEquals(true, Headermessage.contains(OrgName));
		
	}
	
	public void createLastnameWithOrgTest() throws EncryptedDocumentException, IOException {
		String orgName= Elib.getDataFromExcelFile("Sheet1",16,2)+Jlib.getRandomNumber();
		String lastname= Elib.getDataFromExcelFile("Sheet1",16,3)+Jlib.getRandomNumber();
		
	    //step 2: navigate to organization module
		HomePage hp= new HomePage(driver);
		hp.getOrgLink().click();
		
		//step 3: click on create organization button
		OrganizationPage org= new OrganizationPage(driver);
		org.getCreateNewOrgBtn().click();
		
		//step 4: enter all the deatils and create new organization
		CreatingNewORGpage cnop= new CreatingNewORGpage(driver);
	    cnop.getAddOrgName().sendKeys(orgName);
		cnop.getAddlastname().sendKeys(lastname);
		cnop.getSavebtn().click();
	}
}
