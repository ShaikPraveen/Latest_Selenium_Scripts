package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Handling_Keyboard_Operations {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.get("https://www.google.com/");
	    Assert.assertEquals(driver.getTitle(), "Google");
	    System.out.println("Pass");
	    
	    Actions act=new Actions(driver);
	    act.moveToElement(driver.findElement(By.linkText("Gmail")));
	    act.contextClick();
	    act.sendKeys(Keys.ARROW_DOWN);
	    act.sendKeys(Keys.ARROW_DOWN);
	    act.sendKeys(Keys.ENTER);
	    act.build().perform();    
	}
}
