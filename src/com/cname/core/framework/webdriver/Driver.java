package com.cname.core.framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cname.core.framework.utility.Constants;
import com.cname.core.framework.utility.Global;

public class Driver 
{
	public static WebDriver driver = null;
	
	public static WebDriver getBrowserInstance()
	{
		switch(Global.browser.toLowerCase())
		{
			case "chrome":
				System.setProperty("webdriver.chrome.driver", Constants.chromeDriverPath);
				driver = new ChromeDriver();
				break;
				
			case "firefox":
				System.setProperty("webdriver.gecko.driver", Constants.firefoxDriverPath);
				driver = new FirefoxDriver();
				break;
				
			case "ie":
				System.setProperty("webdriver.ie.driver", Constants.ieDriverPath);
				driver = new InternetExplorerDriver();
				break;
		}
		return driver;
	}
}
