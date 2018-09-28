package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Handling_Mouse_Operations1 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
		WebDriver driver;
		//driver=new ChromeDriver();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.nexaexperience.com/");
		
		String title=driver.getTitle();
		Assert.assertEquals(title, "Top Luxury Cars in India: Price, Showrooms & Dealership | NEXA");
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("LOCATOR"))).build().perform();
		driver.findElement(By.linkText("SHOWROOM")).click();
		String title1=driver.getTitle();
		Assert.assertEquals(title1, "Showroom Locations | NEXA");
		driver.close();
	}
}
