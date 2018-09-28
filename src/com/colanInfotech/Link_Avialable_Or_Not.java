package com.colanInfotech;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Link_Avialable_Or_Not {

	public static void main(String[] args)
	{
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://freecrm.com/");
		
		List<WebElement> way2links=driver.findElements(By.tagName("a"));
		System.out.println(way2links.size());
		
		String actlink,explink;
		explink="Contact";
		boolean linkexist=false;
		
		for (int i = 0; i < way2links.size(); i++)
		{
			actlink=way2links.get(i).getText();
			
			if (explink.equalsIgnoreCase(actlink)) 
			{
				linkexist=true;
				break;
			} 	
		}
		if (linkexist) 
		{
			System.out.println(explink +" IS PRESENT, TEST PASS");
			
		}else 
		{
			System.out.println(explink +" IS NOT PRESNT, TEST FAIL");
		}
		
		driver.close();
	}
}
