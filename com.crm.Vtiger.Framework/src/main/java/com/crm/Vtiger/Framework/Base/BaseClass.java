package com.crm.Vtiger.Framework.Base;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPage;
import com.crm.Vtiger.Framework.DatabaseUtility.DatabaseUtility;
import com.crm.Vtiger.Framework.Fileutility.ExcelFileUtility;
import com.crm.Vtiger.Framework.Fileutility.PropertyFileUtility;
import com.crm.Vtiger.Framework.WebDriverUtility.JavaUtility;
import com.crm.Vtiger.Framework.WebDriverUtility.WebDriverUtility;

public class BaseClass {



		public DatabaseUtility DBlib= new DatabaseUtility();
		public PropertyFileUtility PUlib= new PropertyFileUtility();
		public JavaUtility Jlib= new JavaUtility();
		public WebDriverUtility Wlib= new WebDriverUtility();
		public ExcelFileUtility Elib= new ExcelFileUtility();
		public WebDriver driver;
		public static WebDriver sdriver;
		
		
		@BeforeSuite
		public void configBS() throws SQLException {
		
		DBlib.getDatabaseconnection();
		
		}
		
		
		
		@BeforeClass
	    public void configBC() throws IOException {
			
		String Browser=	PUlib.getPropertyValue("browser");	
		
		if(Browser=="chrome")
			driver=new ChromeDriver();

		else if(Browser=="edge")
			driver=new EdgeDriver();

		else if(Browser=="firefox")
			driver=new FirefoxDriver();

		else
			driver=new ChromeDriver();
		
		}
		
		
		
		
		
		@BeforeMethod
	     public void configBM() throws IOException {
			LoginPage lp= new LoginPage(driver);
			String URL=PUlib.getPropertyValue("url");
			driver.get(URL);
			Wlib.waitForPagetoLoad(driver);
			String USERNAME=PUlib.getPropertyValue("username");
			String PASSWORD=PUlib.getPropertyValue("password");
			lp.loginToapp( USERNAME, PASSWORD);
			
		}
		@AfterMethod
	    public void configAM() {
			HomePage HM= new HomePage(driver);
			HM.logout(driver);
			
			
		}
		@AfterClass
	     public void configAC() {
			driver.quit();
		}
		
		@AfterSuite
		public void configAs() {
			System.out.println("---Database disconnected--");
		}
		
	   
		
	}


