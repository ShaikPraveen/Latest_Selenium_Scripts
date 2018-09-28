package com.colanInfotech;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Number_Of_RadioButtons {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
		WebDriver driver;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com/");
		
		List<WebElement> allradios=driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println(allradios.size());
		
		for (int i = 0; i < allradios.size(); i++) 
		{
			WebElement local_radio=allradios.get(i);
			String value= local_radio.getAttribute("value");
			System.out.println("Values form Radio Buttons are "+value);	
		}
		driver.close();
	}

}
