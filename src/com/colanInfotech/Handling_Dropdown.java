package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Handling_Dropdown {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
		WebDriver driver;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		String pageTitle=driver.getTitle();
		System.out.println("Page Title is -> "+pageTitle);
		
		String pageUrl=driver.getCurrentUrl();
		System.out.println("Page URL is "+pageUrl);
		
	    String currentwindowId=driver.getWindowHandle();
		System.out.println("Current Window Id is->  "+currentwindowId);
		Select sele=new Select(driver.findElement(By.id("month")));
		sele.selectByIndex(2); //Feb
		Thread.sleep(2000);
		sele.selectByVisibleText("Dec");//Dec
		Thread.sleep(2000);
		sele.selectByValue("5"); //May 
		driver.close();
	}

}
