package com.crm.Vtiger.Framework.PracticeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtility.CreatingNewORGpage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.crm.Vtiger.Framework.Base.BaseClass;

public class TestScenario1 extends BaseClass {

	@Test
	public void Testing1() throws IOException {
		//read testScript data from Excel file
				String OrgName= Elib.getDataFromExcelFile("Sheet1", 1, 2)+Jlib.getRandomNumber();
				
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
	@Test
	public void Testing2() throws IOException {
		
					//Click on Organization
					String OrgName= Elib.getDataFromExcelFile("Sheet1", 4, 2)+Jlib.getRandomNumber();
					String indu_name= Elib.getDataFromExcelFile("Sheet1", 4, 3);
					String type_s= Elib.getDataFromExcelFile("Sheet1", 4, 4);
					//Stage2: navigate to organization module
					HomePage hp= new HomePage(driver);
					hp.getOrgLink().click();

					OrganizationPage orgP= new OrganizationPage(driver);
					orgP.getCreateNewOrgBtn().click();
					
					CreatingNewORGpage cnop= new CreatingNewORGpage(driver);

					cnop.getAddOrgName().sendKeys(OrgName);
					WebElement industry=cnop.getAddIndustry();
					WebElement type=cnop.getAddType();
					Wlib.selectbyVText(industry, indu_name);// add industry by using excel, instead of orgname
					Wlib.selectbyVText(type, type_s);// add type
					cnop.getSavebtn().click();
					
					String expected_orgname=cnop.getActualOrgNameAdded().getText();
					Assert.assertEquals(true, expected_orgname.contains(OrgName));
					
				  
				    
	}
	@Test
	public void Testing3() throws IOException {
	
		String OrgName= Elib.getDataFromExcelFile("Sheet1", 7, 2)+Jlib.getRandomNumber();
		
		String Phone= Elib.getDataFromExcelFile("Sheet1", 7, 3)+Jlib.getRandomNumber();
		//Stage2: navigate to organization module
		HomePage hp= new HomePage(driver);
		hp.getOrgLink().click();

		CreatingNewORGpage conp= new CreatingNewORGpage(driver);

		conp.getAddphoneNum().sendKeys(Phone);
		conp.getAddOrgName().sendKeys(OrgName);
		conp.getSavebtn();
		
		String expected_phone=conp.getExpected_Phonenum().getText();
		
		Assert.assertEquals(true, expected_phone.contains(Phone));
		
		
}
}
