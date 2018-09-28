package com.colanInfotech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_CheckBox_Operations {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
		WebDriver driver;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		driver.get("https://acegrades.com");
		driver.findElement(By.linkText("LOG IN")).click();
		
		WebElement remember_me=driver.findElement(By.xpath("//label[contains(text(),'Remember me')]"));
		
		//Verify the Check box is Displayed on the Webpage
		boolean remembercheckboxisdisplayed=remember_me.isDisplayed();
		System.out.println("Is Remember me check box is displayed on the web page -> "+remembercheckboxisdisplayed);
		
		//Verify the Check box is Enabled on the webpage
		boolean remembercheckboxisenabled=remember_me.isEnabled();
		System.out.println("Is Remember me check box is enabled on the web page -> "+remembercheckboxisenabled);
		
		//Verify the Selection status of the Remember me checkbox
		boolean remembercheckboxisselected=remember_me.isSelected();
		System.out.println("Is Remember me check box is selected on the web page -> "+remembercheckboxisselected);
		
		//Select Remember check box
		
		remember_me.click();
		
		//Verify new status 
		
		boolean remembercheckboxnewstatus=remember_me.isSelected();
		System.out.println("Remember me check box after perform click() operation -> "+remembercheckboxnewstatus);
		driver.close();
	}

}
