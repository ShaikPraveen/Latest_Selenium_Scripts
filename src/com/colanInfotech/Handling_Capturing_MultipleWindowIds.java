package com.colanInfotech;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Handling_Capturing_MultipleWindowIds {

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
		driver.get("https://www.vistaprint.in");
		
		driver.findElement(By.linkText("Brand Store")).click();
		
		Set<String> windows=driver.getWindowHandles();
		System.out.println(windows.size());
		
		Iterator<String> it=windows.iterator();
		while (it.hasNext()) 
		{
			String windowId=it.next();
			System.out.println(windowId);
		}
	}

}
