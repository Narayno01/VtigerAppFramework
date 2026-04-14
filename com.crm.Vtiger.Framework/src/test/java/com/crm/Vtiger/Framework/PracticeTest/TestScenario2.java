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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.CreatingNewORGpage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.crm.Vtiger.Framework.Base.BaseClass;

public class TestScenario2 extends BaseClass {

	@Test
	public void Testing1() throws IOException {
        String lastname=Elib.getDataFromExcelFile("Sheet1", 1, 2)+Jlib.getRandomNumber();

		// click on create contact add name and phone number
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		//add data in textfield
		ContactPage cnp=new ContactPage(driver);
		cnp.getContactplusicon().click();
		cnp.getLastname().sendKeys(lastname);
		cnp.getSavebtn().click();
	    String Expected=cnp.getExpectedtoconfirm().getText();
		
		if(Expected.contains(lastname)) 
			System.out.println(lastname+" lastname is added of organization----> passed");
		
		else 
			System.out.println(lastname+" lastname is failed to add");
			

	   
}
	@Test
	public void Testing2() throws IOException {
		

		String lastname=Elib.getDataFromExcelFile("Sheet1", 13, 2)+Jlib.getRandomNumber();

		
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		
		ContactPage cnp=new ContactPage(driver);
		cnp.getContactplusicon().click();
		cnp.getLastname().sendKeys(lastname);

//					//Launching browser
//
//					WebDriver driver;	
//
//					if(Browser=="chrome")
//						driver=new ChromeDriver();
//
//					else if(Browser=="edge")
//						driver=new EdgeDriver();
//
//					else if(Browser=="firefox")
//						driver=new FirefoxDriver();
//
//					else
//						driver=new ChromeDriver();
//			        driver.manage().window().maximize();
//				    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
//
//					//Accessing webpage==>>URL
//					driver.get(URL);
//
//					//Login into application

//					driver.findElement(By.name("user_name")).sendKeys(UN);
//					driver.findElement(By.name("user_password")).sendKeys(PW);
//					driver.findElement(By.id("submitButton")).click();

					// click on create contact add name and phone number
//					driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//					driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
//					
//					//add data in textfield
//					driver.findElement(By.name("lastname")).sendKeys(lastname);
			
//					Date d= new Date();
//					SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
//					String startDate= sdf.format(d);
		
		            Jlib.getSystemDate();
		            Jlib.getRequiredDate(30);
					
//					Calendar cal= sdf.getCalendar();
//					cal.add(Calendar.DAY_OF_MONTH, 30);
//					String End_date=sdf.format(cal.getTime());
					
					//support start date
		            cnp.
					driver.findElement(By.name("support_start_date")).clear();
					driver.findElement(By.name("support_start_date")).sendKeys(startDate);
					
					//support end date
					driver.findElement(By.name("support_end_date")).clear();
					driver.findElement(By.name("support_end_date")).sendKeys(End_date);
					
					
					//click on save button
					driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
					
					String expected_contact=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
					
					if(expected_contact.contains(lastname)) {
    					System.out.println(lastname+" lastname is added of organization----> passed");
    				}
    				else {
    					System.out.println(lastname+" lastname is failed to add");
    					
    				}
    			    driver.quit();	
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
    					crog.getAddlastname().sendKeys(lastname);
    					
    					crog.getActualOrgNameAdded().sendKeys(OrgName);
    					crog.getSavebtn().click();
    					
    					
    					
    					//Check Page Header Information == Expected result
    					String headerInfo=driver.findElement(By.xpath("//span[contains(@class,'dvHeaderText')]")).getText();

    					if(headerInfo.contains(orgName)) 
    						System.out.println(orgName+"  is created ==PASS");
    					else
    						System.out.println(orgName+" is not created==FAIL");

    					
    					//Verify Header orgName info ==Expected result
    					String actualorgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
    					if(actualorgName.equals(orgName))
    						System.out.println(orgName+"  is created == PASS");
    					else
    						System.out.println(orgName+" is not created ==FAIL");

    					
    					//contact create
    					driver.findElement(By.xpath("(//a[contains(text(),'Contacts')])[1]")).click();
    					driver.findElement(By.xpath("//img[contains(@title,'Create Contact')]")).click();
    					
    					//add data in textfield
    					driver.findElement(By.name("lastname")).sendKeys(lastname);
    					System.out.println(lastname);
    					
    					//click + icon for organization name
    				    driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
    				    
    				    String parent_window= driver.getWindowHandle();
    				    
    				     Set<String> child = driver.getWindowHandles();
    				     
    				     for(String obj: child) {
    				    	 
    				    	 if(!parent_window.equals(obj)) {
    				    		 driver.switchTo().window(obj);
    				    		
    				    	 }
    				     }
    					
    				    //switch it
    				    driver.findElement(By.id("search_txt")).sendKeys(lastname);
    				    driver.findElement(By.xpath("//input[@name='search']")).click();
    				    driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
    				    
    				    driver.switchTo().window(parent_window);
    				    
    				    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
    					
    				  //Check Page Header Information == Expected result

    					
    					  headerInfo=driver.findElement(By.xpath(
    					  "//span[contains(@class,'dvHeaderText')]")).getText();
    					  
    					  if(headerInfo.contains(lastname))
    					  
    					  System.out.println(lastname+"  is created ==PASS");
    					  
    					  else
    					  
    					  System.out.println(lastname+" is not created==FAIL");
    					  
    					  
    					  
    					  //Verify Header orgName info ==Expected result
    					  
    					  String
    					  actualLastName=driver.findElement(By.id("mouseArea_Last Name")).getText();
    					  
    					  if(actualLastName.equals(lastname))
    					  
    					  System.out.println(lastname+"  is created == PASS");
    					  
    					  else
    					  
    					  System.out.println(lastname+" is not created ==FAIL");
    					  
    					  
    					  
    					  //verify header orgName expected result
    					  
    					  String
    					  actualOrgName=driver.findElement(By.id("mouseArea_Organization Name")).
    					  getText();
    					  
    					  if(actualOrgName.trim().equals(orgName))
    					  
    					  System.out.println(orgName+"  is created==PASS");
    					  
    					  else
    					  
    					  System.out.println(orgName+"  is not created==FAIL");
    					 
    					
    					
    					
    					driver.quit();

}
}
