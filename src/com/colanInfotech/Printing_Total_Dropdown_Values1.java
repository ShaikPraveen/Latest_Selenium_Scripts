package com.colanInfotech;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Printing_Total_Dropdown_Values1 {

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
		Select sele=new Select(driver.findElement(By.id("gi_class")));
		 
		List<WebElement> classValues=sele.getOptions();
		
		int total_vales=classValues.size();
		Assert.assertEquals(total_vales, 4);
		System.out.println("Total Number of Class are "+total_vales);
		
		 for(WebElement ele:classValues)
		 {
			 String class_names=ele.getText();
			 System.out.println(class_names);
		 }
		 driver.close();
	}
}
