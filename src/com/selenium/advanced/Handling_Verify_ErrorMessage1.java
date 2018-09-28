package com.selenium.advanced;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Verify_ErrorMessage1 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
		WebDriver driver;
		//driver=new ChromeDriver();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		driver.get("https://www.acegrades.com/");
		driver.findElement(By.linkText("LOG IN")).click();
		
		driver.findElement(By.xpath("//button[@id='loginId']")).click();
		
		String act_errormessage=driver.findElement(By.xpath("//div[@class='errors ng-binding']")).getAttribute("innerHTML");
		String exp_errormessage="Parameter check failed: body is empty object";
		
		//Type 1
		Assert.assertEquals(act_errormessage, exp_errormessage);
		
		//Type 2
		Assert.assertTrue(act_errormessage.contains("Parameter check failed: body is empty object"));
		System.out.println("TEST COMPLETED");
		driver.close();
	}

}
