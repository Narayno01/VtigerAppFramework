package com.crm.Vtiger.FrameworkTESTPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestWithPom {

	 @FindBy(name="user_name")
		private WebElement Ele1;
	    
	    @FindBy(xpath="//input[@type='password']")
	    private WebElement Ele2;
	    
	    @FindBy(id="submitButton")
	    private WebElement Ele3;
	    
	    @Test
	    public void sampleTest() {
	    	WebDriver driver= new ChromeDriver();
	    	driver.get("http://localhost:8888/");
	    	SampleTestWithPom som=PageFactory.initElements(driver,SampleTestWithPom.class);
	    	
	    	som.Ele1.sendKeys("admin");
	    	som.Ele2.sendKeys("admin");
	    	som.Ele3.click();
	    	
	    }
	    
	    
}
