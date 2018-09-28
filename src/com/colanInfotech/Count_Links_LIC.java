package com.colanInfotech;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Count_Links_LIC {

	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://licindia.in/");
		
		List<WebElement> Total_Lic_Links=driver.findElements(By.tagName("a"));
		System.out.println(Total_Lic_Links.size());
		
		       for (int i = 0; i<Total_Lic_Links.size() ; i++)
		       {
		    	   String linknames=Total_Lic_Links.get(i).getText();
		    	   System.out.println(linknames);	
			}
		       driver.close();
	}

}
