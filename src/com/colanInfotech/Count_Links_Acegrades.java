package com.colanInfotech;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Count_Links_Acegrades {

	public static void main(String[] args) 
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.acegrades.com");
		
		List<WebElement> Total_Links_Yuvanestam=driver.findElements(By.tagName("a"));
		System.out.println(Total_Links_Yuvanestam.size());
		
		      for (int i = 0; i<Total_Links_Yuvanestam.size(); i++) 
		      {
		    	 String linksnames= Total_Links_Yuvanestam.get(i).getText();
		    	 System.out.println(linksnames);	
			}
		        driver.close();
		    }
}
