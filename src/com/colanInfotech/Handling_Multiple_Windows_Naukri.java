package com.colanInfotech;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Multiple_Windows_Naukri {

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
		driver.get("https://www.naukri.com/");
		Assert.assertEquals(driver.getTitle(), "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com");
		
		String parentwindow=driver.getWindowHandle();
		driver.findElement(By.xpath("//div[contains(text(),'Recruiters') and @class='mTxt']")).click();
		Set<String> windows=driver.getWindowHandles();
		
		Iterator<String> it=windows.iterator();
		
		while(it.hasNext())
		{
			String recruterwindow=it.next();
			
			if (!parentwindow.equals(recruterwindow)) 
			{
				driver.switchTo().window(recruterwindow);
				Assert.assertEquals(driver.getTitle(), "HR Manager - HR Executive - HR Recruiter Consultants - Naukri.com");
				System.out.println(driver.findElement(By.cssSelector(".SrchHd>span")).getText());
				driver.close();
			}
		}
		
		driver.switchTo().window(parentwindow);
		Assert.assertEquals(driver.getTitle(), "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com");
		driver.close();
	}
}
