package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Handling_Select_Multiple_Dropdown_Values {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
		WebDriver driver;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		driver.get("file:///C:/Users/Manohar/Desktop/dropdown.html");
		Select sele=new Select(driver.findElement(By.id("Testing Courses")));
		WebElement option=sele.getFirstSelectedOption();
		String defaultselectedValue=option.getText();
		System.out.println(defaultselectedValue);
		
		sele.selectByVisibleText("APPIUM");
		WebElement option1=sele.getFirstSelectedOption();
		String afterselectedValue=option1.getText();
		System.out.println(afterselectedValue);
		
		sele.selectByVisibleText("JMETER");
		WebElement option2=sele.getFirstSelectedOption();
		String afterselectedValue1=option2.getText();
		System.out.println(afterselectedValue1);
		
		
		sele.selectByVisibleText("LOAD RUNNER");
		WebElement option3=sele.getFirstSelectedOption();
		String afterselectedValue2=option3.getText();
		System.out.println(afterselectedValue2);
		
		driver.close();
	}

}
