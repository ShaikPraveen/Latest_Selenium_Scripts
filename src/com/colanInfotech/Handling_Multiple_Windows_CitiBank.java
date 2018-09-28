package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Multiple_Windows_CitiBank {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
		WebDriver driver;
		driver=new FirefoxDriver();
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.online.citibank.co.in/");
		Assert.assertEquals(driver.getTitle(), "Citi India - Credit Card | Loan | Investment | Insurance | Banking");
		String parentwindow=driver.getWindowHandle();
		
		driver.findElement(By.cssSelector(".hidden-phone.visible-dektop.loginnowlink.overlay-login>img")).click();
		
		for(String subwindow :driver.getWindowHandles())
		{
			driver.switchTo().window(subwindow);
		}
		
		    String pageheading=driver.findElement(By.cssSelector(".bold")).getText();
		    System.out.println(pageheading);
		    driver.close();
		    
		    driver.switchTo().window(parentwindow);
		    driver.close();
	}

}
