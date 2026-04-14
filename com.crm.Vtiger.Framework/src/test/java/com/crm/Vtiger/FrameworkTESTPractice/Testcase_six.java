package com.crm.Vtiger.FrameworkTESTPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
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

public class Testcase_six {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream
				("C:\\Users\\aDMIN\\eclipse-workspace\\com.Mavenselenium\\src\\test\\resources\\Commondata\\CommondataVtiger.properties");

				Properties p=new Properties();
				p.load(fis);

					String Browser=p.getProperty("browser");
					String URL=p.getProperty("url");
					String UN=p.getProperty("username");
					String PW=p.getProperty("password");
					System.out.println(Browser+" "+URL+" "+UN+" "+PW);

					//Launching browser

					WebDriver driver;	

					if(Browser=="chrome")
						driver=new ChromeDriver();

					else if(Browser=="edge")
						driver=new EdgeDriver();

					else if(Browser=="firefox")
						driver=new FirefoxDriver();

					else
						driver=new ChromeDriver();
			        driver.manage().window().maximize();
				    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	

					//Accessing webpage==>>URL
					driver.get(URL);

					//Login into application

					driver.findElement(By.name("user_name")).sendKeys(UN);
					driver.findElement(By.name("user_password")).sendKeys(PW);
					driver.findElement(By.id("submitButton")).click();

					//Click on Organization
					driver.findElement(By.linkText("Organizations")).click();

					//Create new organization page by clicking on plus icon
					driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

					//Read Data from Excel file
					FileInputStream fis1=new FileInputStream
					("C:\\Users\\aDMIN\\eclipse-workspace\\com.Mavenselenium\\src\\test\\resources\\Testdata\\TestScriptmxjdata.xlsx");

					Workbook wb=WorkbookFactory.create(fis1);
					Sheet sh=wb.getSheet("Sheet1");
					Row r=sh.getRow(1);
					Cell c=r.getCell(2);
					
					Row r1=sh.getRow(13);
					Cell c1=r1.getCell(2);
					
					Random random=new Random();
					int randomInt=random.nextInt(1000);

					String orgName=c.getStringCellValue()+randomInt;
					String lastname=c1.getStringCellValue()+randomInt;
					wb.close();

					//Organization Name Textfield
					driver.findElement(By.name("accountname")).sendKeys(orgName);

					//click on Save button
					driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
					
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
