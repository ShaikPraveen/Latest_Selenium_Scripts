package com.seleniumGrid;


import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest 
{
	
	  @Test
	  public void LoginTest() throws MalformedURLException
	  {
		  DesiredCapabilities cap = DesiredCapabilities.firefox();
		  cap.setPlatform(Platform.WINDOWS);
		  
	RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wb/hub"),cap);
	driver.get("http://acegrades.com");	  
 }
}
