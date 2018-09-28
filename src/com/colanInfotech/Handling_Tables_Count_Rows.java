package com.colanInfotech;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Tables_Count_Rows {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
		WebDriver  driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://money.rediff.com/tools/forex");
		
		WebElement table;
		List<WebElement> rows;
		table=driver.findElement(By.className("dataTable"));
		rows=table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		
		
		//Printing Data
		for (int i = 0; i < rows.size(); i++)
		{
			System.out.println(rows.get(i).getText());
			
		}
		driver.close();
	}

}
