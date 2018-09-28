package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Handling_Mouse_Operations {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
	    WebDriver driver;
	    //driver=new ChromeDriver();
	    driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.get("http://way2automation.com/");
	    Assert.assertEquals(driver.getTitle(), "Best Selenium Training - Rahul Arora (Raman) | Selenium Training Institute in Noida, Delhi, Gurgaon, Ghaziabad");
	    
	    
	    Actions act=new Actions(driver);
	    act.moveToElement(driver.findElement(By.linkText("SELENIUM"))).build().perform();
	    driver.findElement(By.linkText("Video Tutorials")).click();
	    Assert.assertEquals(driver.getTitle(), "Free Selenium Tutorial | Introduction to Selenium | Selenium WebDriver Tutorials");
	    System.out.println("TEST PASS");
	    driver.close();
	}
}
