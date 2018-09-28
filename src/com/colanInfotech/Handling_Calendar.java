package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Calendar {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.get("https://www.cleartrip.com/");
	    
	   WebElement date= driver.findElement(By.id("DepartDate"));
	   String dateValue="Sun, 30 Sept, 2018";
	   dateByJS(driver, date, dateValue);

	}
	
	  public static void dateByJS(WebDriver driver, WebElement element, String datevalue)
	  {
		  JavascriptExecutor js=((JavascriptExecutor)driver);
		  js.executeScript("arguments[0].setAttribute(value='DepartDate','"+datevalue+"');",element);	  
	  }
}
