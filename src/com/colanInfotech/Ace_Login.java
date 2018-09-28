package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ace_Login {

	public static void main(String[] args) 
	{
		
		WebDriver  driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		driver.get("https://acegrades.com/");
		driver.findElement(By.linkText("LOG IN")).click();
		driver.findElement(By.id("email")).sendKeys("sample.teacher@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("loginId")).sendKeys(Keys.RETURN);
		
		
		if (driver.findElement(By.xpath("//a[@class='dropdown-button add-class']")).isDisplayed()) 
		{
			System.out.println("TEST PASS");
			
		} else 
		{
			System.out.println("TEST FAIL");

		}
		
		driver.close();
	}

}
