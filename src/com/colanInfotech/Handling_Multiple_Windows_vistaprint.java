package com.colanInfotech;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Handling_Multiple_Windows_vistaprint {

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
		driver.get("https://www.vistaprint.in/");
		Assert.assertEquals(driver.getTitle(), "Vistaprint India: visiting cards, t-shirts & photo calendars");
		
		String homewindowId=driver.getWindowHandle();
		driver.findElement(By.linkText("Brand Store")).click();
		
		Set<String> allwindows=driver.getWindowHandles();
		Iterator<String> it=allwindows.iterator();
		
		while(it.hasNext())
		{
			String recruterwindowId=it.next();
			
			 if (!homewindowId.equals(recruterwindowId)) 
			 {
				 driver.switchTo().window(recruterwindowId);
				 Assert.assertEquals(driver.getTitle(), "Brand Store by Vistaprint: Custom t-shirts & more");
				 driver.close();
			}		 
	}
		 driver.switchTo().window(homewindowId);
		 Actions act=new Actions(driver);
		 act.moveToElement(driver.findElement(By.linkText("Visiting Cards"))).build().perform();
		 driver.findElement(By.linkText("Slim")).click();
		 Assert.assertEquals(driver.getTitle(), "Slim Visiting Cards | Vistaprint.in");
		 driver.close();
	}

}
