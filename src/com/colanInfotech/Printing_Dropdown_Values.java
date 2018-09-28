package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Printing_Dropdown_Values
{
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
		WebElement option=sele.getFirstSelectedOption();
		String defaultselectedItem=option.getText();
		System.out.println(defaultselectedItem);
		
		sele.selectByIndex(6);
		WebElement option1=sele.getFirstSelectedOption();
	    String afterselectedValue=option1.getText();
	    System.out.println(afterselectedValue);
	    
	    sele.selectByVisibleText("Dec");
	    WebElement option2=sele.getFirstSelectedOption();
	    String afterselectedValue1=option2.getText();
	    System.out.println(afterselectedValue1);
	    
	    sele.selectByValue("5");
	    WebElement option3=sele.getFirstSelectedOption();
	    String afterselectedValue2=option3.getText();
	    System.out.println(afterselectedValue2);  
	    driver.close();
	}
}
