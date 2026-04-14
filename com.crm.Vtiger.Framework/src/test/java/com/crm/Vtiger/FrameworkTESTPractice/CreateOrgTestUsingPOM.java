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

import com.crm.Vtiger.Framework.Fileutility.PropertyFileUtility;

public class CreateOrgTestUsingPOM {

	public void Test_org() throws IOException {
			PropertyFileUtility p=new PropertyFileUtility();
            
				String Browser=p.getPropertyValue("browser");
				String URL=p.getPropertyValue("url");
				String UN=p.getPropertyValue("username");
				String PW=p.getPropertyValue("password");
				

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
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	

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
				
				Random random=new Random();
				int randomInt=random.nextInt(1000);

				String orgName=c.getStringCellValue()+randomInt;

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

				
					driver.quit();
}
}
