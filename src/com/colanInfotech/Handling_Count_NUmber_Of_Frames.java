package com.colanInfotech;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Handling_Count_NUmber_Of_Frames {

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
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_button_formtarget");	
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		List<WebElement> totalframes=driver.findElements(By.tagName("iframe"));
		System.out.println(totalframes.size());
		for(WebElement ele :totalframes)
		{
			  System.out.println("Frame Id   "+ele.getAttribute("id"));
			  System.out.println("Frame Nmae "+ele.getAttribute("name"));	
		}
	}
}
