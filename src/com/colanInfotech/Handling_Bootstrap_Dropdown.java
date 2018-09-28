package com.colanInfotech;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Bootstrap_Dropdown {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
		WebDriver driver;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		driver.get("http://www.softmindinformatics.com/");
		driver.findElement(By.linkText("Services")).click();
		
		List<WebElement> services_menu=driver.findElements(By.xpath("html/body/div[2]/nav/div/div[2]/ul/li[3]/ul/li/a"));
		System.out.println(services_menu.size());
		
		  for (int i = 0; i < services_menu.size(); i++) 
		  {
			  WebElement ele=services_menu.get(i);
			  String innerhtml= ele.getAttribute("innerHTML");
			  
			  if (innerhtml.contentEquals("Software Testing")) 
			  {
				  ele.click();
				  break;		
			}
			  System.out.println("Values from drop down is "+innerhtml);
		}
		driver.close();
	}
}
