package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextBox_Operations {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
		WebDriver driver;
		//driver=new FirefoxDriver();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://acegrades.com/");
		String pageTitle=driver.getTitle();
		System.out.println("Page Title is -> "+pageTitle);
		
		String pageUrl=driver.getCurrentUrl();
		System.out.println("Page URL is "+pageUrl);
		
	    String currentwindowId=driver.getWindowHandle();
		System.out.println("Current Window Id is->  "+currentwindowId);
		
		driver.findElement(By.linkText("LOG IN")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("sample.teacher@gamil.com");
		String enteredValue=driver.findElement(By.id("email")).getAttribute("value");
		System.out.println("Captured Value is-> "+enteredValue);
		driver.close();	
	}

}
