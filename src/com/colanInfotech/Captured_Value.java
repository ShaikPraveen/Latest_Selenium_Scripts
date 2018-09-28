package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Captured_Value {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
		WebDriver driver;
		//driver=new FirefoxDriver();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http://orangehrm.qedgetech.com");
		String pageTitle=driver.getTitle();
		System.out.println("Page Title is -> "+pageTitle);
		
		String pageUrl=driver.getCurrentUrl();
		System.out.println("Page URL is "+pageUrl);
		
	    String currentwindowId=driver.getWindowHandle();
		System.out.println("Current Window Id is->  "+currentwindowId);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='btnLogin' and @type='submit']")).sendKeys(Keys.RETURN);
        
        driver.findElement(By.linkText("PIM")).click();
        driver.findElement(By.linkText("Add Employee")).click();
        String capturedValue= driver.findElement(By.id("employeeId")).getAttribute("value");
        System.out.println("Captured Valyes is "+capturedValue);
        driver.findElement(By.id("welcome")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
        driver.close();
	}
}
