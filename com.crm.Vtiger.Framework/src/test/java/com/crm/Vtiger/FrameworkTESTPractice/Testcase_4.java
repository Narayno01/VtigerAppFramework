package com.crm.Vtiger.FrameworkTESTPractice;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPage;
import com.crm.Vtiger.Framework.Base.BaseClass;
import com.crm.Vtiger.Framework.DatabaseUtility.DatabaseUtility;
import com.crm.Vtiger.Framework.Fileutility.ExcelFileUtility;
import com.crm.Vtiger.Framework.Fileutility.PropertyFileUtility;
import com.crm.Vtiger.Framework.WebDriverUtility.JavaUtility;

public class Testcase_4 extends BaseClass {
	@Test (retryAnalyzer =com.crm.Vtiger.FrameworkTESTPractice.RetryAnalyzser.class)
	public void createContact() throws IOException {
		            String lastname=Elib.getDataFromExcelFile("Sheet1", 1, 2)+Jlib.getRandomNumber();
		
					// click on create contact add name and phone number
					HomePage hp=new HomePage(driver);
					hp.getContactLink().click();
					
					//add data in textfield
					ContactPage cnp=new ContactPage(driver);
					cnp.getContactplusicon().click();
					cnp.getLastname().sendKeys(lastname);
					cnp.getSavebtn().click();
				    //String Expected=cnp.getExpectedtoconfirm().getText();
					
//					if(Expected.contains(lastname)) 
//    					System.out.println(lastname+" lastname is added of organization----> passed");
//    				
//    				else 
//    					System.out.println(lastname+" lastname is failed to add");
//    					
//    		
    			   
	}

}
