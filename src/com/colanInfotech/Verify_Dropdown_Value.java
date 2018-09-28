package com.colanInfotech;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Verify_Dropdown_Value {

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
		List<WebElement> allclass_values=sele.getOptions();
		System.out.println(allclass_values.size());
		
		String actclass,expclass;
		expclass="Business";
		boolean classexist=false;
		
		 for (int i = 0; i < allclass_values.size(); i++) 
		 {
			 actclass=allclass_values.get(i).getText();
			 if (expclass.equalsIgnoreCase(actclass)) 
			 {
				 classexist=true;
				 break;	
			}	
		}
		 if (classexist) 
		 {
			 System.out.println(expclass +" IS PRESENT, TEST PASS");
			
		} else 
		{
			System.out.println(expclass +"  IS NOT PRESENT, TEST FAIL");

		}
		 driver.close();
	}

}
