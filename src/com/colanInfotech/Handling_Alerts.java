package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Alerts {

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
		driver.get("http://primusbank.qedgetech.com/");
		Assert.assertEquals(driver.getTitle(), "Primus BANK");
		
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='login']")).sendKeys(Keys.RETURN);
		
		Alert alt=driver.switchTo().alert();
		String alttext=alt.getText();
		Assert.assertEquals(alttext, "InCorrect BankerName/Password");
		alt.accept();// Means OK
		//alt.dismiss(); //Means Cancel 
		driver.close();
	}
}
