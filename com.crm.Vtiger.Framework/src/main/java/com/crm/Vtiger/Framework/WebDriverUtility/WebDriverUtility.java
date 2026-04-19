package com.crm.Vtiger.Framework.WebDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility  {

public void waitForPagetoLoad(WebDriver driver) {
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	

	public void waitForElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	

	public void switchNewBrowserTab(WebDriver driver,String partialURL) {

	

	 Set<String>set=driver.getWindowHandles();

	 Iterator<String> it=set.iterator();

	 while(it.hasNext()) {

		 String windowID=it.next();

		 driver.switchTo().window(windowID);

		 

		 String actURL=driver.getCurrentUrl();

		 if(actURL.contains(partialURL))

			 break;

	 }

	}
	
	public void switchTo_mainTab(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	

	 

	 public void switchToFrame(WebDriver driver,int index) {

		 driver.switchTo().frame(index);

	 }

	  

	 public void switchToFrame(WebDriver driver,String name) {

		 driver.switchTo().frame(name);

	 }

	 

	 public void switchToFrame(WebDriver driver,WebElement element) {

		 driver.switchTo().frame(element);

	 }

	 

	 public void switchToAlertandAccept(WebDriver driver) {

		 driver.switchTo().alert().accept();

	 }

	 

	 public void switchToAlertandCancel(WebDriver driver) {

		 driver.switchTo().alert().dismiss();

	 }

	 

	 public void selectbyVText(WebElement element,String text) {

		 Select s=new Select(element);

		 s.selectByVisibleText(text);

	 }

	 

	 public void selectbyIndex(WebElement element,int index) {

		 Select s=new Select(element);

         s.selectByIndex(index);

	 }

	 

	 public void mouseMoveOnElement(WebDriver driver,WebElement element) {

		 Actions a=new Actions(driver);

		 a.moveToElement(element).perform();

	 }

	 
}
