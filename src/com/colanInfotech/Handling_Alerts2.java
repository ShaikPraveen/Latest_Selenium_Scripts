package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Alerts2 {

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
		driver.get("file:///C:/Users/Manohar/Desktop/alert2.html");
		Assert.assertEquals(driver.getTitle(), "Selenium Easy Prompt popup Sample");
		driver.findElement(By.xpath("//button[@onclick='promptFunction()']")).click();
		
		Alert alt=driver.switchTo().alert();
		driver.switchTo().alert().sendKeys("Praveen123");
		alt.accept();
	    driver.close();
	}
}
