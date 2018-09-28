package com.colanInfotech;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Link_Available_Or_Not {

	public static void main(String[] args)
	{
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.softmindinformatics.com/");
		
		
		List<WebElement> total_links=driver.findElements(By.tagName("a"));
		System.out.println(total_links.size());
		
		String actlink,explink;
		explink="Careers"; 
		boolean linkexist=false;
		
		 for (int i = 0; i < total_links.size(); i++)
		 {
			 actlink=total_links.get(i).getText();
			if (explink.equalsIgnoreCase(actlink)) 
			{
				linkexist=true;
				break;	
			}	
		}
		 if (linkexist)
		 {
			 System.out.println(explink +" IS PRESENT, TEST PASS");
			
		} else
		{
			System.out.println(explink +"  IS NOT PRESENT, TEST FAIL");
		}
		 driver.close();
	}

}
