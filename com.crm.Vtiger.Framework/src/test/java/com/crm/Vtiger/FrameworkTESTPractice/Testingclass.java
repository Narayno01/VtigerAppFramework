package com.crm.Vtiger.FrameworkTESTPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Testingclass {

	@Test
	public void test() throws IOException {
		
		FileInputStream fis=new FileInputStream("./ConfigureData/CommonData/CommondataVtiger.properties");

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

	}
}
