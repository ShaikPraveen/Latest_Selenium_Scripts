package com.colanInfotech;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Suggestions {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
		WebDriver driver;
		//driver=new FirefoxDriver();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		String pageTitle=driver.getTitle();
		System.out.println("Page Title is -> "+pageTitle);
		
		String pageUrl=driver.getCurrentUrl();
		System.out.println("Page URL is "+pageUrl);
		
	    String currentwindowId=driver.getWindowHandle();
		System.out.println("Current Window Id is->  "+currentwindowId);
		
		driver.findElement(By.id("FromTag")).sendKeys("Hyd");
		driver.findElement(By.id("FromTag")).click();
		
		List<WebElement> citylist=driver.findElements(By.xpath("html/body/ul[1]/li/a"));
		System.out.println(citylist.size());
		
		for (int i = 0; i < citylist.size(); i++)
		{
			System.out.println(citylist.get(i).getText());
			
		}
		driver.close();
	}

}
