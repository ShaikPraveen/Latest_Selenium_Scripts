package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Alerts1 {

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
		driver.get("file:///C:/Users/Manohar/Desktop/alert1.html");
		Assert.assertEquals(driver.getTitle(), "Selenium Easy Confirm popup Sample");
		
		driver.findElement(By.xpath("//button[@onclick='confirmFunction()']")).click();
		
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
		driver.close();
	}
}
