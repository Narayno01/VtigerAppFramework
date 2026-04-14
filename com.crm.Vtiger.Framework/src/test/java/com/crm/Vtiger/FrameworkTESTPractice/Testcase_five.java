package com.crm.Vtiger.FrameworkTESTPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

public class Testcase_five {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream
				("C:\\Users\\aDMIN\\eclipse-workspace\\com.Mavenselenium\\src\\test\\resources\\Commondata\\CommondataVtiger.properties");

				Properties p=new Properties();
				p.load(fis);

					String Browser=p.getProperty("browser");
					String URL=p.getProperty("url");
					String UN=p.getProperty("username");
					String PW=p.getProperty("password");
					System.out.println(Browser+" "+URL+" "+UN+" "+PW);
					
					//excel database is connection building
					
					FileInputStream fis1=new FileInputStream
							("C:\\Users\\aDMIN\\eclipse-workspace\\com.Mavenselenium\\src\\test\\resources\\Testdata\\TestScriptmxjdata.xlsx");

							Workbook wb=WorkbookFactory.create(fis1);
							Sheet sh=wb.getSheet("Sheet1");
							Row r=sh.getRow(10); 
							Cell c=r.getCell(2);
							
							Random random=new Random();
							int randomInt=random.nextInt(1000);

							String lastname=c.getStringCellValue()+randomInt;

							/*
							 * Cell c1=r.getCell(3);
							 * 
							 * String phone_num= c1.getStringCellValue()+randomInt;
							 * System.out.println(phone_num);
							 */
							wb.close();

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

					// click on create contact add name and phone number
					driver.findElement(By.xpath("//a[text()='Contacts']")).click();
					driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
					
					//add data in textfield
					driver.findElement(By.name("lastname")).sendKeys(lastname);
			
					Date d= new Date();
					SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
					String startDate= sdf.format(d);
					
					Calendar cal= sdf.getCalendar();
					cal.add(Calendar.DAY_OF_MONTH, 30);
					String End_date=sdf.format(cal.getTime());
					
					//support start date
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
}
