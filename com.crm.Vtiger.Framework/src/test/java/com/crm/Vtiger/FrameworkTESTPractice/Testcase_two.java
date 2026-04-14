package com.crm.Vtiger.FrameworkTESTPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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

public class Testcase_two {

	public static void main(String[] args) throws IOException  {
		
	
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
				Row r=sh.getRow(1); // i have to change row and cell
				Cell c=r.getCell(2);
				
				Random random=new Random();
				int randomInt=random.nextInt(1000);

				String ActorgName=c.getStringCellValue()+randomInt;

				wb.close();

				//Organization Name Textfield
				driver.findElement(By.name("accountname")).sendKeys(ActorgName);
				
				// handle dropdown to fill industry and type details
				
				WebElement ele=driver.findElement(By.name("industry"));
				Select sel = new Select(ele);
				sel.selectByValue("Education");
				
				WebElement Type=driver.findElement(By.name("accounttype"));
				Select se = new Select(Type);
				se.selectByValue("Analyst");
				
				//click save button
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				//expected using get text
				String expectedAccount=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				
				if(expectedAccount.contains(ActorgName)) {
					System.out.println(ActorgName+"  account is created of organization----> passed");
				}
				else {
					System.out.println(ActorgName+" account is failed to create");
					
				}
			    driver.quit();	
				
	}
}
