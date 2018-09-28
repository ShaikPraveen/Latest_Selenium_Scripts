package com.colanInfotech;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Printing_Total_Dropdown_Values {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
		WebDriver driver;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		Select sele=new Select(driver.findElement(By.id("month")));
		 
		List<WebElement> months_list=sele.getOptions();
		
		int total_months=months_list.size();
		Assert.assertEquals(total_months, 13);
		System.out.println("Total Number of Months are "+total_months);
		
		 for(WebElement ele :months_list )
		 {
			 String month_names=ele.getText();
			 System.out.println(month_names);
		 }
		 driver.close();
	}

}
