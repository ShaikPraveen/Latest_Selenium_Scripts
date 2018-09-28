package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Navigation_Methods{

	public static void main(String[] args) throws InterruptedException
	{
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://licindia.in/");
		String title=driver.getTitle();
		System.out.println(title);
		Thread.sleep(3000);
		driver.navigate().to("https://www.zoho.in/crm/");
		String title1=driver.getTitle();
		System.out.println(title1);
		
		Thread.sleep(3000);
		driver.navigate().back();
		String title2=driver.getTitle();
		System.out.println(title2);
		
		Thread.sleep(3000);
		driver.navigate().forward();
		String title3=driver.getTitle();
		System.out.println(title3);
		
		Thread.sleep(3000);
		driver.navigate().to("https://acegrades.com");
		String title4=driver.getTitle();
		System.out.println(title4);
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		driver.close();
	}
}
